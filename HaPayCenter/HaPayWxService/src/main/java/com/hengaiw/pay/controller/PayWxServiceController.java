package com.hengaiw.pay.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengaiw.model.dao.model.MchInfo;
import com.hengaiw.model.dao.model.PayChannel;
import com.hengaiw.model.dao.model.PayOrder;
import com.hengaiw.model.dao.model.RefundOrder;
import com.hengaiw.model.dao.model.WxBill;
import com.hengaiw.model.dao.model.WxBillDay;
import com.hengaiw.model.service.MchInfoService;
import com.hengaiw.model.service.PayChannelService;
import com.hengaiw.model.service.RefundOrderService;
import com.hengaiw.model.service.WxBIllDayService;
import com.hengaiw.model.service.WxBIllService;
import com.hengaiw.model.service.HaPayOrderService;
import com.hengaiw.pay.wx.config.HaWxConfigImpl;
import com.hengaiw.pay.wx.sdk.WXPay;
import com.hengaiw.pay.wx.sdk.WXPayConstants;
import com.hengaiw.pay.wx.sdk.WXPayConstants.SignType;
import com.hengaiw.pay.wx.sdk.WXPayUtil;
import com.hengaiw.pub.constant.PayConstants;
import com.hengaiw.pub.constant.PayEnum;
import com.hengaiw.pub.utils.HaBase64;
import com.hengaiw.pub.utils.HaLog;
import com.hengaiw.pub.utils.HaPayUtil;

/**
 * 微信支付相关接口
 * 
 * @author jianhuizhang
 *
 */
@RestController
@RequestMapping(value = "/pay/wx")
public class PayWxServiceController {

	private final HaLog _log = HaLog.getLog(PayWxServiceController.class);

	@Value("${wx.cert.root.path}")
	private String certRootPath;

	@Value("${wx.notify_url}")
	private String notify_url;

	private WXPay wxpay;

	@Autowired
	private MchInfoService mchInfoService;
	@Autowired
	private PayChannelService payChannelService;

	@Autowired
	private HaPayOrderService payOrderService;

	@Autowired
	private RefundOrderService refundOrderService;

	@Autowired
	private WxBIllDayService wxBillDayService;
	@Autowired
	private WxBIllService wxBillService;

	/**
	 * 更新微信的帐单信息
	 * 
	 * @param jsonParam
	 * @return
	 */
	@RequestMapping(value = "/bill")
	public String payWxBill(@RequestParam String jsonParam) {
		JSONObject paramObj = JSON.parseObject(new String(HaBase64.decode(jsonParam)));
		String bill_date = paramObj.getString("bill_date");
		String bill_type = paramObj.getString("bill_type");
		String mchId = paramObj.getString("mchId");
		String channelId = paramObj.getString("channelId");
		String logPrefix = "【获取微信帐单】";
		MchInfo mchInfo = mchInfoService.selectByMchId(mchId);
		_log.info("{}获取商户信息:mchInfo={}", logPrefix, JSON.toJSON(mchInfo));
		PayChannel payChannel = payChannelService.selectPayChannel(channelId, mchId);
		_log.info("{}获取通道信息:payChannel={}", logPrefix, JSON.toJSON(payChannel));
		String configParam = payChannel.getParam();
		HaWxConfigImpl config;
		try {
			config = HaWxConfigImpl.getInstance(configParam, certRootPath);
			wxpay = new WXPay(config);
			HashMap<String, String> data = new HashMap<String, String>();
			data.put("bill_date", bill_date);
			data.put("bill_type", bill_type);
			_log.info("{}请求参数:bill_date={},bill_type={}", logPrefix, bill_date, bill_type);
			Map<String, String> retMap = wxpay.downloadBill(data);
			_log.info("{}获取对帐单:result={}", logPrefix, JSON.toJSON(retMap));
			if ("SUCCESS".equals(retMap.get("return_code"))) {// 退款成功
				Map<String, Object> map = HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_SUCCESS, "",
						PayConstants.RETURN_VALUE_SUCCESS, null);
				String dataStr = retMap.get("data");
				String[] billList = dataStr.split("\r\n");
				if (billList.length > 0) {
					// 数级的最后一个是当天统计数据
					String dayDataStr = billList[billList.length - 1];
					String[] dayStrArray = dayDataStr.split(",");
					WxBillDay wxBillDay = new WxBillDay();
					wxBillDay.setBill_date(bill_date);
					wxBillDay.setTotal_order(dayStrArray[0].substring(1, dayStrArray[0].length()));
					wxBillDay.setTotal_pay(dayStrArray[1].substring(1, dayStrArray[1].length()));
					wxBillDay.setTotal_refund(dayStrArray[2].substring(1, dayStrArray[2].length()));
					wxBillDay.setTotal_company_refund(dayStrArray[3].substring(1, dayStrArray[3].length()));
					wxBillDay.setTotal_fee(dayStrArray[4].substring(1, dayStrArray[4].length()));
					wxBillDay.setMchId(mchId);
					wxBillDayService.createWxBillDay(wxBillDay);
					map.put("wxBillDay", wxBillDay);
					_log.info("{}添加日对帐单:wxBillDay={}", logPrefix, JSON.toJSON(wxBillDay));
					List<WxBill> retBillList = new ArrayList();
					for (int i = 0; i < billList.length - 2; i++) {
						String[] billStrArray = billList[i].split(",");
						WxBill wxBill = new WxBill();
						int k = 0;
						wxBill.setTradetime(billStrArray[k].substring(1, billStrArray[k].length()));
						k++;
						wxBill.setGhid(billStrArray[k].substring(1, billStrArray[k].length()));
						k++;
						wxBill.setMchid(billStrArray[k].substring(1, billStrArray[k].length()));
						k++;
						wxBill.setSubmch(billStrArray[k].substring(1, billStrArray[k].length()));
						k++;
						wxBill.setSubmch(billStrArray[k].substring(1, billStrArray[k].length()));
						k++;
						wxBill.setWxorder(billStrArray[k].substring(1, billStrArray[k].length()));
						k++;
						wxBill.setBzorder(billStrArray[k].substring(1, billStrArray[k].length()));
						k++;
						wxBill.setOpenid(billStrArray[k].substring(1, billStrArray[k].length()));
						k++;
						wxBill.setTradetype(billStrArray[k].substring(1, billStrArray[k].length()));
						k++;
						wxBill.setTradestatus(billStrArray[k].substring(1, billStrArray[k].length()));
						k++;
						wxBill.setBank(billStrArray[k].substring(1, billStrArray[k].length()));
						k++;
						wxBill.setCurrency(billStrArray[k].substring(1, billStrArray[k].length()));
						k++;
						wxBill.setTotalmoney(billStrArray[k].substring(1, billStrArray[k].length()));
						k++;
						wxBill.setRedpacketmoney(billStrArray[k].substring(1, billStrArray[k].length()));
						k++;
						wxBill.setWxrefund(billStrArray[k].substring(1, billStrArray[k].length()));
						k++;
						wxBill.setBzrefund(billStrArray[k].substring(1, billStrArray[k].length()));
						k++;
						wxBill.setRefundmoney(billStrArray[k].substring(1, billStrArray[k].length()));
						k++;
						wxBill.setRedpacketrefund(billStrArray[k].substring(1, billStrArray[k].length()));
						k++;
						wxBill.setRefundtype(billStrArray[k].substring(1, billStrArray[k].length()));
						k++;
						wxBill.setRefundstatus(billStrArray[k].substring(1, billStrArray[k].length()));
						k++;
						wxBill.setProductname(billStrArray[k].substring(1, billStrArray[k].length()));
						k++;
						wxBill.setBzdatapacket(billStrArray[k].substring(1, billStrArray[k].length()));
						k++;
						wxBill.setFee(billStrArray[k].substring(1, billStrArray[k].length()));
						k++;
						wxBill.setRate(billStrArray[k].substring(1, billStrArray[k].length()));
						wxBillService.createWxBill(wxBill);
						retBillList.add(wxBill);
						_log.info("{}添加帐单:wxBill={}", logPrefix, JSON.toJSON(wxBill));
					}
					return HaPayUtil.makeRetData(map, mchInfo.getResKey());
				} else {
					_log.error("{}解析对帐单失败:{}", logPrefix, dataStr);
					return HaPayUtil.makeRetFail(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_SUCCESS, "",
							PayConstants.RETURN_VALUE_FAIL, "000001", "解析对帐单失败"));
				}
			} else {
				_log.error("{}获取对帐单失败:error_code={},return_msg={}", logPrefix, retMap.get("error_code"),
						retMap.get("return_msg"));
				return HaPayUtil.makeRetFail(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_SUCCESS, "",
						PayConstants.RETURN_VALUE_FAIL, retMap.get("error_code"), retMap.get("return_msg")));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			_log.error("{}获取对帐单失败:{}", logPrefix, e.getMessage());
			return HaPayUtil.makeRetFail(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_SUCCESS, "",
					PayConstants.RETURN_VALUE_FAIL, "000001", "获取对帐单失败," + e.getMessage()));
		}

	}

	/**
	 * 微信的退款下单
	 * 
	 * @param jsonParam
	 * @return
	 */
	@RequestMapping(value = "/refundOrder")
	public String payWxRefundOrder(@RequestParam String jsonParam) {
		JSONObject paramObj = JSON.parseObject(new String(HaBase64.decode(jsonParam)));
		RefundOrder refundOrder = paramObj.getObject("refundOrder", RefundOrder.class);
		String tradeType = paramObj.getString("tradeType");
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
		String configParam = payChannel.getParam();
		HaWxConfigImpl config;
		try {
			config = HaWxConfigImpl.getInstance(configParam, certRootPath);
			wxpay = new WXPay(config);
			HashMap<String, String> data = createRefundOrderRequest(refundOrder, tradeType);
			Map<String, String> r = wxpay.refund(data);
			String return_code = r.get("return_code");
			if ("SUCCESS".equals(return_code)) {// 退款成功
				Map<String, Object> map = HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_SUCCESS, "",
						PayConstants.RETURN_VALUE_SUCCESS, null);
				map.put("RefundOrderId", refundOrder.getRefundOrderId());
				int result = refundOrderService.updateStatus4Complete(refundOrder.getRefundOrderId(),
						r.get("refund_id"));
				_log.info("更新第三方支付订单号:payOrderId={},refund_id={},result={}", refundOrder.getPayOrderId(),
						r.get("prepay_id"), result);
				return HaPayUtil.makeRetData(map, resKey);
			} else {// 退款失败
				return HaPayUtil.makeRetFail(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_SUCCESS, "",
						PayConstants.RETURN_VALUE_FAIL, "000001", "调用微信退款失败," + r.toString()));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return HaPayUtil.makeRetFail(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_SUCCESS, "",
					PayConstants.RETURN_VALUE_FAIL, "000001", "调用微信退款失败," + e.getMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			return HaPayUtil.makeRetFail(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_SUCCESS, "",
					PayConstants.RETURN_VALUE_FAIL, "000001", "调用微信退款失败," + e.getMessage()));
		}
	}

	/**
	 * 微信的统一下单
	 * 
	 * @param jsonParam
	 * @return
	 */
	@RequestMapping(value = "/unifiedOrder")
	public String payWxUnifiedOrder(@RequestParam String jsonParam) {
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
		String configParam = payChannel.getParam();
		HaWxConfigImpl config;
		try {
			config = HaWxConfigImpl.getInstance(configParam, certRootPath);
			wxpay = new WXPay(config);
			String subMchId = config.getSubMchId();
			HashMap<String, String> data = createUnifiedOrderRequest(payOrder, tradeType, subMchId);
			_log.info("{}微信下单参数:{}", JSON.toJSON(data));
			Map<String, String> r = wxpay.unifiedOrder(data);
			String return_code = r.get("return_code");
			System.out.println(r);
			_log.info("更新第三方支付订单号:payOrderId={},prepayId={},result={}", payOrder.getPayOrderId(), r.get("prepay_id"),
					r.toString());
			if ("SUCCESS".equals(return_code)) {
				Map<String, Object> map = HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_SUCCESS, "",
						PayConstants.RETURN_VALUE_SUCCESS, null);
				map.put("payOrderId", payOrder.getPayOrderId());
				map.put("prepayId", r.get("prepay_id"));
				int result = payOrderService.updateStatus4Ing(payOrder.getPayOrderId(), r.get("prepay_id"));
				_log.info("更新第三方支付订单号:payOrderId={},prepayId={},result={}", payOrder.getPayOrderId(),
						r.get("prepay_id"), result);
				switch (tradeType) {
				case PayConstants.PAY_CHANNEL_WX_JSAPI:
					Map<String, String> payInfo = new HashMap<>();
					String timestamp = String.valueOf(WXPayUtil.getCurrentTimestamp());// String.valueOf(System.currentTimeMillis()
																						// / 1000);
					String nonceStr = WXPayUtil.generateNonceStr();// String.valueOf(System.currentTimeMillis());
					payInfo.put("appId", r.get("appid"));
					// 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
					payInfo.put("timeStamp", timestamp);
					payInfo.put("nonceStr", nonceStr);
					payInfo.put("package", "prepay_id=" + r.get("prepay_id"));
					payInfo.put("signType", WXPayConstants.HMACSHA256);
					payInfo.put("paySign",
							WXPayUtil.generateSignature(payInfo, config.getKey(), WXPayConstants.SignType.HMACSHA256));
					map.put("payParams", payInfo);
					break;

				case PayConstants.PAY_CHANNEL_WX_MWEB:
					map.put("payUrl", r.get("mweb_url")); // h5支付链接地址
					break;

				case PayConstants.PAY_CHANNEL_WX_NATIVE:
					map.put("codeUrl", r.get("code_url")); // 二维码支付链接
					break;
				case PayConstants.PAY_CHANNEL_WX_APP:
					Map<String, String> appPayInfo = new HashMap<>();
                    String app_timestamp =String.valueOf(WXPayUtil.getCurrentTimestamp());
                    String app_nonceStr = WXPayUtil.generateNonceStr();
                    // APP支付绑定的是微信开放平台上的账号，APPID为开放平台上绑定APP后发放的参数
                    String appId = config.getAppID();
                    Map<String, String> configMap = new HashMap<>();
                    // 此map用于参与调起sdk支付的二次签名,格式全小写，timestamp只能是10位,格式固定，切勿修改
                    String partnerId = config.getMchID();
                    configMap.put("prepayid", r.get("prepayid"));
                    configMap.put("partnerid", partnerId);
                    String packageValue = "Sign=WXPay";
                    configMap.put("package", packageValue);
                    configMap.put("timestamp", app_timestamp);
                    configMap.put("noncestr", app_nonceStr);
                    configMap.put("appid", appId);
                    // 此map用于客户端与微信服务器交互
                    appPayInfo.put("sign", WXPayUtil.generateSignature(appPayInfo, config.getKey(), WXPayConstants.SignType.HMACSHA256));
                    appPayInfo.put("prepayId", r.get("prepayId"));
                    appPayInfo.put("partnerId", partnerId);
                    appPayInfo.put("appId", appId);
                    appPayInfo.put("packageValue", packageValue);
                    appPayInfo.put("timeStamp", app_timestamp);
                    appPayInfo.put("nonceStr", app_nonceStr);
                    map.put("payParams", appPayInfo);
					break;

				}
				return HaPayUtil.makeRetData(map, resKey);
			} else {
				return HaPayUtil.makeRetFail(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_SUCCESS, "",
						PayConstants.RETURN_VALUE_FAIL, "000001", "调用微信支付失败," + r.toString()));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return HaPayUtil.makeRetFail(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_SUCCESS, "",
					PayConstants.RETURN_VALUE_FAIL, "000001", "调用微信支付失败," + e.getMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			return HaPayUtil.makeRetFail(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_SUCCESS, "",
					PayConstants.RETURN_VALUE_FAIL, "000001", "调用微信支付失败," + e.getMessage()));
		}

	}

	/**
	 * 构建微信统一下单请求数据
	 * 
	 * @param payOrder
	 * @param wxPayConfig
	 * @return
	 */
	HashMap<String, String> createUnifiedOrderRequest(PayOrder payOrder, String tradeType, String subMchId) {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("device_info", payOrder.getDevice());
		data.put("body", payOrder.getBody());
		data.put("detail", payOrder.getSubject());
		if (!StringUtils.isBlank(subMchId)) {
			data.put("sub_mch_id	", subMchId);
		}
		data.put("out_trade_no", payOrder.getPayOrderId());
		data.put("fee_type", "CNY");
		data.put("total_fee", payOrder.getAmount().toString());
		data.put("spbill_create_ip", payOrder.getClientIp());
		data.put("notify_url", notify_url);
		switch (tradeType) {
		case PayConstants.PAY_CHANNEL_WX_JSAPI:
			data.put("openid", JSON.parseObject(payOrder.getExtra()).getString("openId"));
			data.put("trade_type", PayConstants.WxConstant.TRADE_TYPE_JSPAI);
			break;
		case PayConstants.PAY_CHANNEL_WX_NATIVE:
			data.put("product_id", JSON.parseObject(payOrder.getExtra()).getString("product_id"));
			data.put("trade_type", PayConstants.WxConstant.TRADE_TYPE_NATIVE);
			break;
		case PayConstants.PAY_CHANNEL_WX_MWEB:
			data.put("trade_type", PayConstants.WxConstant.TRADE_TYPE_MWEB);
			data.put("scene_info", JSON.parseObject(payOrder.getExtra()).getString("scene_info"));
			break;
		}
		return data;
	}

	HashMap<String, String> createRefundOrderRequest(RefundOrder refundOrder, String tradeType) {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("out_trade_no", refundOrder.getPayOrderId());
		data.put("out_refund_no", refundOrder.getRefundOrderId());
		data.put("total_fee", refundOrder.getPayAmount().toString());
		data.put("refund_fee", refundOrder.getRefundAmount().toString());
		data.put("refund_fee_type", refundOrder.getCurrency());
		// data.put("op_user_id", refundOrder.getMchId());
		switch (tradeType) {
		case PayConstants.PAY_CHANNEL_WX_JSAPI:

			break;
		}
		return data;
	}
}
