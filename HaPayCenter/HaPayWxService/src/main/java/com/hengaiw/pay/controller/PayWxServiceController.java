package com.hengaiw.pay.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.binarywang.wxpay.bean.request.WxEntPayRequest;
import com.github.binarywang.wxpay.bean.request.WxPayRefundRequest;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxEntPayResult;
import com.github.binarywang.wxpay.bean.result.WxPayBillResult;
import com.github.binarywang.wxpay.bean.result.WxPayRefundResult;
import com.github.binarywang.wxpay.bean.result.WxPayUnifiedOrderResult;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.constant.WxPayConstants;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import com.github.binarywang.wxpay.util.SignUtils;
import com.hengaiw.model.dao.model.EntpayOrder;
import com.hengaiw.model.dao.model.MchInfo;
import com.hengaiw.model.dao.model.PayChannel;
import com.hengaiw.model.dao.model.PayOrder;
import com.hengaiw.model.dao.model.RefundOrder;
import com.hengaiw.model.dao.model.TransOrder;
import com.hengaiw.model.service.EntpayOrderService;
import com.hengaiw.model.service.HaPayOrderService;
import com.hengaiw.model.service.MchInfoService;
import com.hengaiw.model.service.PayChannelService;
import com.hengaiw.model.service.RefundOrderService;
import com.hengaiw.pay.config.WxPayProperties;
import com.hengaiw.pay.config.WxPayUtil;
import com.hengaiw.pub.constant.PayConstants;
import com.hengaiw.pub.constant.PayEnum;
import com.hengaiw.pub.utils.HaBase64;
import com.hengaiw.pub.utils.HaLog;
import com.hengaiw.pub.utils.HaPayUtil;
import com.hengaiw.pub.utils.IPUtility;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 支付渠道接口:微信
 */
@RestController
@RequestMapping(value = "/pay/wx")
public class PayWxServiceController {

	private final HaLog _log = HaLog.getLog(PayWxServiceController.class);

	@Autowired
	private HaPayOrderService payOrderService;

	@Autowired
	private PayChannelService payChannelService;

	@Autowired
	private MchInfoService mchInfoService;

	@Autowired
	private RefundOrderService refundOrderService;

	@Autowired
	private EntpayOrderService entpayOrderService;
	
	@Resource
	private WxPayProperties wxPayProperties;
	
	/**
	 * 微信转帐到个人微信的零钱
	 */
	@RequestMapping(value="entpay")
	public String wxEntPayReq(@RequestParam String jsonParam) {
		try {
			JSONObject paramObj = JSON.parseObject(new String(HaBase64.decode(jsonParam)));
			EntpayOrder entpayOrder = paramObj.getObject("entpayOrder", EntpayOrder.class);
			String logPrefix = "【微信支付转帐】";
			String mchId = entpayOrder.getMchId();
			String channelId = entpayOrder.getChannelId();
			MchInfo mchInfo = mchInfoService.selectByMchId(mchId);
			_log.info("{}获取商户信息:mchInfo={}", logPrefix, JSON.toJSON(mchInfo));
			String resKey = mchInfo == null ? "" : mchInfo.getResKey();
			if ("".equals(resKey))
				return HaPayUtil.makeRetFail(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_FAIL, "",
						PayConstants.RETURN_VALUE_FAIL, PayEnum.ERR_0001));
			PayChannel payChannel = payChannelService.selectPayChannel(channelId, mchId);
			_log.info("{}获取通道信息:payChannel={}", logPrefix, JSON.toJSON(payChannel));
			WxPayConfig wxPayConfig = WxPayUtil.getWxPayConfig(payChannel.getParam(),"",wxPayProperties.getCertRootPath(),"");
	        WxPayService wxPayService = new WxPayServiceImpl();
	        wxPayService.setConfig(wxPayConfig);
	        WxEntPayRequest wxEntPayRequest=buildEntPayOrderRequest(entpayOrder,wxPayConfig);
	        WxEntPayResult wxEntPayResult;
	        try {
	        		wxEntPayResult=wxPayService.entPay(wxEntPayRequest);
				_log.info("{} >>> 转帐成功,返回结果:{}", logPrefix,JSON.toJSONString(wxEntPayResult));
		        Map<String, Object> map = HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_SUCCESS, "", PayConstants.RETURN_VALUE_SUCCESS, null);
		        map.put("result", JSON.toJSONString(wxEntPayResult));
				int result = entpayOrderService.updateStatusSuccess(entpayOrder.getEntPayOrderId(),wxEntPayResult.getPaymentNo());
				_log.info("更新转帐订单号:entpayOrderId={},result={}", entpayOrder.getEntPayOrderId(), result);
				return HaPayUtil.makeRetData(map, resKey);
	        }catch (WxPayException e) {
	            _log.error(e, "转帐失败");
	            //出现业务错误
	            _log.info("{}转帐返回失败", logPrefix);
	            _log.info("err_code:{}", e.getErrCode());
	            _log.info("err_code_des:{}", e.getErrCodeDes());
	            return HaPayUtil.makeRetData(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_FAIL, "", PayConstants.RETURN_VALUE_FAIL, "0111", "转帐返回失败," + e.getErrCode() + ":" + e.getErrCodeDes()), resKey);
	        }
		}catch (Exception e) {
            _log.error(e, "微信支付转帐异常");
            return HaPayUtil.makeRetFail(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_FAIL, "", PayConstants.RETURN_VALUE_FAIL, PayEnum.ERR_0001));
        }
	}
	/**
	 * 获取微信的帐单
	 * 
	 * @param jsonParam
	 * @return
	 */
	@RequestMapping(value = "/bill")
	public String payWxBill(@RequestParam String jsonParam) {
		try {
			JSONObject paramObj = JSON.parseObject(new String(HaBase64.decode(jsonParam)));
			String bill_date = paramObj.getString("bill_date");
			String bill_type = paramObj.getString("bill_type");
			String mchId = paramObj.getString("mchId");
			String channelId = paramObj.getString("channelId");
			String logPrefix = "【获取微信帐单】";
			MchInfo mchInfo = mchInfoService.selectByMchId(mchId);
			_log.info("{}获取商户信息:mchInfo={}", logPrefix, JSON.toJSON(mchInfo));
			String resKey = mchInfo == null ? "" : mchInfo.getResKey();
			if ("".equals(resKey))
				return HaPayUtil.makeRetFail(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_FAIL, "",
						PayConstants.RETURN_VALUE_FAIL, PayEnum.ERR_0001));
			PayChannel payChannel = payChannelService.selectPayChannel(channelId, mchId);
			_log.info("{}获取通道信息:payChannel={}", logPrefix, JSON.toJSON(payChannel));
			WxPayConfig wxPayConfig = WxPayUtil.getWxPayConfig(payChannel.getParam(),"",wxPayProperties.getCertRootPath(),"");
	        WxPayService wxPayService = new WxPayServiceImpl();
	        wxPayService.setConfig(wxPayConfig);
	        WxPayBillResult wxPayBillResult;
	        try {
	        		wxPayBillResult=wxPayService.downloadBill(bill_date, bill_type,"","");
	        		_log.info("{} >>> 下载帐单成功,返回结果:{}", logPrefix,JSON.toJSONString(wxPayBillResult));
			    Map<String, Object> map = HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_SUCCESS, "", PayConstants.RETURN_VALUE_SUCCESS, null);
			    map.put("totalRecord",wxPayBillResult.getTotalRecord());
			    map.put("totalCouponFee",wxPayBillResult.getTotalCouponFee());
			    map.put("totalFee", wxPayBillResult.getTotalFee());
			    map.put("totalPoundageFee", wxPayBillResult.getTotalPoundageFee());
			    map.put("totalRefundFee", wxPayBillResult.getTotalRefundFee());
			    map.put("payBillBaseResultLst", JSON.toJSONString(wxPayBillResult.getWxPayBillBaseResultLst()));
			    return HaPayUtil.makeRetData(map, resKey);
	        }catch (WxPayException e) {
	            _log.error(e, "下载帐单失败");
	            //出现业务错误
	            _log.info("{}下载帐单返回失败", logPrefix);
	            _log.info("err_code:{}", e.getErrCode());
	            _log.info("err_code_des:{}", e.getErrCodeDes());
	            return HaPayUtil.makeRetData(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_FAIL, "", PayConstants.RETURN_VALUE_FAIL, "0111", "下载帐单失败," + e.getErrCode() + ":" + e.getErrCodeDes()), resKey);
	        }
		}catch (Exception e) {
            _log.error(e, "微信支付下载帐单异常");
            return HaPayUtil.makeRetFail(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_FAIL, "", PayConstants.RETURN_VALUE_FAIL, PayEnum.ERR_0001));
        }
	}
	

	/**
	 * 微信的退款下单
	 * 
	 * @param jsonParam
	 * @return
	 */
	@RequestMapping(value = "/refund")
	public String payWxRefund(@RequestParam String jsonParam) {
		try {
			JSONObject paramObj = JSON.parseObject(new String(HaBase64.decode(jsonParam)));
			RefundOrder refundOrder = paramObj.getObject("refundOrder", RefundOrder.class);
			//String tradeType = paramObj.getString("tradeType");
			String logPrefix = "【微信支付退款】";
			String mchId = refundOrder.getMchId();
			String channelId = refundOrder.getChannelId();
			MchInfo mchInfo = mchInfoService.selectByMchId(mchId);
			_log.info("{}获取商户信息:mchInfo={}", logPrefix, JSON.toJSON(mchInfo));
			String resKey = mchInfo == null ? "" : mchInfo.getResKey();
			if ("".equals(resKey))
				return HaPayUtil.makeRetFail(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_FAIL, "",
						PayConstants.RETURN_VALUE_FAIL, PayEnum.ERR_0001));
			PayChannel payChannel = payChannelService.selectPayChannel(channelId, mchId);
			_log.info("{}获取通道信息:payChannel={}", logPrefix, JSON.toJSON(payChannel));
			WxPayConfig wxPayConfig = WxPayUtil.getWxPayConfig(payChannel.getParam(),"",wxPayProperties.getCertRootPath(),"");
	        WxPayService wxPayService = new WxPayServiceImpl();
	        wxPayService.setConfig(wxPayConfig);
	        WxPayRefundRequest wxPayRefundRequest=buildPayRefundRequest(refundOrder,wxPayConfig);
	        WxPayRefundResult wxPayRefundResult;
	        try {
				wxPayRefundResult=wxPayService.refund(wxPayRefundRequest);
				_log.info("{} >>> 退款成功,返回结果:{}", logPrefix,JSON.toJSONString(wxPayRefundResult));
		        Map<String, Object> map = HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_SUCCESS, "", PayConstants.RETURN_VALUE_SUCCESS, null);
		        map.put("RefundOrderId", refundOrder.getRefundOrderId());
				int result = refundOrderService.updateStatus4Complete(refundOrder.getRefundOrderId(),
						wxPayRefundResult.getRefundId());
				_log.info("更新第三方退款订单号:payOrderId={},refund_id={},result={}", refundOrder.getPayOrderId(),
						wxPayRefundResult.getRefundId(), result);
				
				/**
				 * 未实现的功能，需要对发起退款的支付单号更新状态
				 */
				result = payOrderService.updateStatus4Refund(refundOrder.getPayOrderId());
				_log.info("更新第三方支付订单号:payOrderId={},refund_id={},result={}", refundOrder.getPayOrderId(),
						wxPayRefundResult.getRefundId(), result);
				return HaPayUtil.makeRetData(map, resKey);
	        }catch (WxPayException e) {
	            _log.error(e, "退款失败");
	            //出现业务错误
	            _log.info("{}退款返回失败", logPrefix);
	            _log.info("err_code:{}", e.getErrCode());
	            _log.info("err_code_des:{}", e.getErrCodeDes());
	            return HaPayUtil.makeRetData(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_FAIL, "", PayConstants.RETURN_VALUE_FAIL, "0111", "退款返回失败," + e.getErrCode() + ":" + e.getErrCodeDes()), resKey);
	        }
		}catch (Exception e) {
            _log.error(e, "微信支付退款异常");
            return HaPayUtil.makeRetFail(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_FAIL, "", PayConstants.RETURN_VALUE_FAIL, PayEnum.ERR_0001));
        }
	}

	/**
	 * 发起微信支付(统一下单)
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/unifiedOrder")
	public String doUnifiedOrderReq(@RequestParam String jsonParam) {
		try {
			_log.info("{} >>> 下单参数", jsonParam);
			JSONObject paramObj = JSON.parseObject(new String(HaBase64.decode(jsonParam)));
			PayOrder payOrder = paramObj.getObject("payOrder", PayOrder.class);
			String tradeType = paramObj.getString("tradeType");
			String logPrefix = "【微信支付统一下单】";
			String mchId = payOrder.getMchId();
			String channelId = payOrder.getChannelId();
			MchInfo mchInfo = mchInfoService.selectByMchId(mchId);
			String resKey = mchInfo == null ? "" : mchInfo.getResKey();
			if ("".equals(resKey))
				return HaPayUtil.makeRetFail(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_FAIL, "",
						PayConstants.RETURN_VALUE_FAIL, PayEnum.ERR_0001));
			PayChannel payChannel = payChannelService.selectPayChannel(channelId, mchId);
			WxPayConfig wxPayConfig = WxPayUtil.getWxPayConfig(payChannel.getParam(), tradeType,
					wxPayProperties.getCertRootPath(), wxPayProperties.getNotifyUrl());
			WxPayService wxPayService = new WxPayServiceImpl();
			wxPayService.setConfig(wxPayConfig);
			WxPayUnifiedOrderRequest wxPayUnifiedOrderRequest = buildUnifiedOrderRequest(payOrder, wxPayConfig);
			String payOrderId = payOrder.getPayOrderId();
			WxPayUnifiedOrderResult wxPayUnifiedOrderResult;
			try {
				wxPayUnifiedOrderResult = wxPayService.unifiedOrder(wxPayUnifiedOrderRequest);
				_log.info("{} >>> 下单成功", logPrefix);
				Map<String, Object> map = HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_SUCCESS, "",
						PayConstants.RETURN_VALUE_SUCCESS, null);
				map.put("payOrderId", payOrderId);
				map.put("prepayId", wxPayUnifiedOrderResult.getPrepayId());
				int result = payOrderService.updateStatus4Ing(payOrderId, wxPayUnifiedOrderResult.getPrepayId());
				_log.info("更新第三方支付订单号:payOrderId={},prepayId={},result={}", payOrderId,
						wxPayUnifiedOrderResult.getPrepayId(), result);
				switch (tradeType) {
				case PayConstants.WxConstant.TRADE_TYPE_NATIVE: {
					map.put("codeUrl", wxPayUnifiedOrderResult.getCodeURL()); // 二维码支付链接
					break;
				}
				case PayConstants.WxConstant.TRADE_TYPE_APP: {
					Map<String, String> payInfo = new HashMap<>();
					String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
					String nonceStr = String.valueOf(System.currentTimeMillis());
					// APP支付绑定的是微信开放平台上的账号，APPID为开放平台上绑定APP后发放的参数
					String appId = wxPayConfig.getAppId();
					Map<String, String> configMap = new HashMap<>();
					// 此map用于参与调起sdk支付的二次签名,格式全小写，timestamp只能是10位,格式固定，切勿修改
					String partnerId = wxPayConfig.getMchId();
					configMap.put("prepayid", wxPayUnifiedOrderResult.getPrepayId());
					configMap.put("partnerid", partnerId);
					String packageValue = "Sign=WXPay";
					configMap.put("package", packageValue);
					configMap.put("timestamp", timestamp);
					configMap.put("noncestr", nonceStr);
					configMap.put("appid", appId);
					// 此map用于客户端与微信服务器交互
					payInfo.put("sign", SignUtils.createSign(configMap, wxPayConfig.getMchKey()));
					payInfo.put("prepayId", wxPayUnifiedOrderResult.getPrepayId());
					payInfo.put("partnerId", partnerId);
					payInfo.put("appId", appId);
					payInfo.put("packageValue", packageValue);
					payInfo.put("timeStamp", timestamp);
					payInfo.put("nonceStr", nonceStr);
					map.put("payParams", payInfo);
					break;
				}
				case PayConstants.WxConstant.TRADE_TYPE_JSPAI: {
					Map<String, String> payInfo = new HashMap<>();
					String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
					String nonceStr = String.valueOf(System.currentTimeMillis());
					payInfo.put("appId", wxPayUnifiedOrderResult.getAppid());
					// 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
					payInfo.put("timeStamp", timestamp);
					payInfo.put("nonceStr", nonceStr);
					payInfo.put("package", "prepay_id=" + wxPayUnifiedOrderResult.getPrepayId());
					payInfo.put("signType", WxPayConstants.SignType.MD5);
					payInfo.put("paySign", SignUtils.createSign(payInfo, wxPayConfig.getMchKey()));
					map.put("payParams", payInfo);
					break;
				}
				case PayConstants.WxConstant.TRADE_TYPE_MWEB: {
					map.put("payUrl", wxPayUnifiedOrderResult.getMwebUrl()); // h5支付链接地址
					break;
				}
				}
				return HaPayUtil.makeRetData(map, resKey);
			} catch (WxPayException e) {
				_log.error(e, "下单失败");
				// 出现业务错误
				_log.info("{}下单返回失败", logPrefix);
				_log.info("err_code:{}", e.getErrCode());
				_log.info("err_code_des:{}", e.getErrCodeDes());
				return HaPayUtil.makeRetData(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_FAIL, "",
						PayConstants.RETURN_VALUE_FAIL, "0111", "调用微信支付失败," + e.getErrCode() + ":" + e.getErrCodeDes()),
						resKey);
			}
		} catch (Exception e) {
			_log.error(e, "微信支付统一下单异常");
			return HaPayUtil.makeRetFail(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_FAIL, "",
					PayConstants.RETURN_VALUE_FAIL, PayEnum.ERR_0001));
		}
	}

	/**
	 * 构建微信统一下单请求数据
	 * 
	 * @param payOrder
	 * @param wxPayConfig
	 * @return
	 */
	WxPayUnifiedOrderRequest buildUnifiedOrderRequest(PayOrder payOrder, WxPayConfig wxPayConfig) {
		String tradeType = wxPayConfig.getTradeType();
		String payOrderId = payOrder.getPayOrderId();
		Integer totalFee = payOrder.getAmount().intValue();// 支付金额,单位分
		String deviceInfo = payOrder.getDevice();
		String body = payOrder.getBody();
		String detail = null;
		String attach = null;
		String outTradeNo = payOrderId;
		String feeType = "CNY";
		String spBillCreateIP = payOrder.getClientIp();
		String timeStart = null;
		String timeExpire = null;
		String goodsTag = null;
		String notifyUrl = wxPayConfig.getNotifyUrl();
		String productId = null;
		if (tradeType.equals(PayConstants.WxConstant.TRADE_TYPE_NATIVE))
			productId = JSON.parseObject(payOrder.getExtra()).getString("productId");
		String limitPay = null;
		String openId = null;
		if (tradeType.equals(PayConstants.WxConstant.TRADE_TYPE_JSPAI)) {
			openId = JSON.parseObject(payOrder.getExtra()).getString("openId");
		}
		String sceneInfo = null;
		if (tradeType.equals(PayConstants.WxConstant.TRADE_TYPE_MWEB))
			sceneInfo = JSON.parseObject(payOrder.getExtra()).getString("sceneInfo");
		// 微信统一下单请求对象
		WxPayUnifiedOrderRequest request = new WxPayUnifiedOrderRequest();
		request.setDeviceInfo(deviceInfo);
		request.setBody(body);
		if(!StringUtils.isEmpty(wxPayConfig.getSubMchId())) {
			request.setSubMchId(wxPayConfig.getSubMchId());
		}
		if(!StringUtils.isEmpty(wxPayConfig.getSubAppId())) {
			request.setSubAppId(wxPayConfig.getSubAppId());
     		request.setSubOpenid(openId);
		}else {
			request.setOpenid(openId);
		}
		//request.setOpenid("oZ2FfwvgX8o5KoImIG8h6IVuvxB8");
		request.setDetail(detail);
		request.setAttach(attach);
		request.setOutTradeNo(outTradeNo);
		request.setFeeType(feeType);
		request.setTotalFee(totalFee);
		request.setSpbillCreateIp(spBillCreateIP);
		request.setTimeStart(timeStart);
		request.setTimeExpire(timeExpire);
		request.setGoodsTag(goodsTag);
		request.setNotifyURL(notifyUrl);
		request.setTradeType(tradeType);
		request.setProductId(productId);
		request.setLimitPay(limitPay);
		
		request.setSceneInfo(sceneInfo);
		_log.info("统一下单参数:{}", JSON.toJSONString(request));
		return request;
	}

	/**
	 * 构建微信退款订单请求数据
	 * 
	 * @param payOrder
	 * @param wxPayConfig
	 * @return
	 */
	WxPayRefundRequest buildPayRefundRequest(RefundOrder refundOrder, WxPayConfig wxPayConfig) {

		String outRefundNo = refundOrder.getRefundOrderId();
		String outTradeNo = refundOrder.getPayOrderId();
		String refundDesc = "";
		Integer refundFee = Integer.parseInt(String.valueOf(refundOrder.getRefundAmount()));
		String refundFeeType = "CNY";
		Integer totalFee = Integer.parseInt(String.valueOf(refundOrder.getPayAmount()));
		// 微信统一下单请求对象
		WxPayRefundRequest request = new WxPayRefundRequest();
		request.setOutRefundNo(outRefundNo);
		request.setOutTradeNo(outTradeNo);
		if(!StringUtils.isEmpty(wxPayConfig.getSubMchId())) {
			request.setSubMchId(wxPayConfig.getSubMchId());
		}
		if(!StringUtils.isEmpty(wxPayConfig.getSubAppId())) {
			request.setSubAppId(wxPayConfig.getSubAppId());
		}
		// request.setRefundAccount(refundAccount);
		request.setRefundDesc(refundDesc);
		request.setRefundFee(refundFee);
		request.setRefundFeeType(refundFeeType);
		request.setTotalFee(totalFee);
		// request.setTransactionId(transactionId);
		_log.info("统一退款参数:{}", JSON.toJSONString(request));
		return request;
	}
	
	/**
	 * 构建微信转帐订单请求数据
	 * 
	 * @param payOrder
	 * @param wxPayConfig
	 * @return
	 */
	WxEntPayRequest buildEntPayOrderRequest(EntpayOrder entpayOrder, WxPayConfig wxPayConfig) {

		String outTransNo = entpayOrder.getEntPayOrderId();
		String deviceInfo=entpayOrder.getDeviceInfo();
//		String openId=entpayOrder.getOpenId();
//		String checkName=entpayOrder.getCheckName();
//		String userName=entpayOrder.getUserName();
		Integer amount = Integer.parseInt(String.valueOf(entpayOrder.getAmount()));
		String  desc=entpayOrder.getRemarkInfo();
		String clientIp=entpayOrder.getClientIp();
		String extra=entpayOrder.getExtra();
		JSONObject extraObject = JSON.parseObject(extra);
		// 微信统一下单请求对象
		WxEntPayRequest request = new WxEntPayRequest();
		request.setMchAppid(wxPayConfig.getAppId());
		request.setDeviceInfo(deviceInfo);
		request.setPartnerTradeNo(outTransNo);
		request.setOpenid(extraObject.getString("openId"));
		request.setCheckName(extraObject.getString("checkName"));
		request.setReUserName(extraObject.getString("userName"));
		request.setAmount(amount);
		request.setDescription(desc);
		request.setSpbillCreateIp(clientIp);
		// request.setTransactionId(transactionId);
		_log.info("统一退款参数:{}", JSON.toJSONString(request));
		return request;
	}
}
