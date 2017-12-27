package com.hengaiw.test;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.binarywang.wxpay.bean.request.WxPayRefundRequest;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxPayRefundResult;
import com.github.binarywang.wxpay.bean.result.WxPayUnifiedOrderResult;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.constant.WxPayConstants;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import com.github.binarywang.wxpay.util.SignUtils;
import com.hengaiw.model.dao.model.MchInfo;
import com.hengaiw.model.dao.model.PayChannel;
import com.hengaiw.model.dao.model.PayOrder;
import com.hengaiw.model.dao.model.RefundOrder;
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
import com.hengaiw.pub.utils.HaPayUtil;

public class TestWxPay {
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
	private static String certRootPath = "/Users/jianhuizhang/Downloads/cert";
	String configParam = "{\"mchId\":\"1435642402\",\"sub_mch_id\":\"1494346192\",\"appId\":\"wx9ed8fbe06bde3bad\",\"sub_appid\":\"wxdb599665a42a37c6\",\"key\":\"EIOHGdsgihdsiogs20ds1g2sdggsd211\",\"certLocalPath\":\"1435642402/apiclient_cert.p12\"}";
	String jsonParam="eyJ0cmFkZVR5cGUiOiJKU0FQSSIsInBheU9yZGVyIjp7InBheU9yZGVySWQiOiJQMDAyMDE3MTIyMDEwMzkxODk4OTAwMDAxNiIsImFtb3VudCI6MSwibWNoSWQiOiJlZTg1N2I1NTVkMjQ3Mjk2NWQzNmVmNzU2NDUwN2JiNyIsIm1jaE9yZGVyTm8iOiJTMjAxNzEyMjAxMDM5MTgwMDAwMTYiLCJzdWJqZWN0IjoidGVzdF8wMDAxIiwiYm9keSI6InRlc3RfMDAwMSIsImNoYW5uZWxNY2hJZCI6IjE0OTQzNDYxOTIiLCJwYXJhbTEiOiIiLCJwYXJhbTIiOiIiLCJjbGllbnRJcCI6IjEwLjQ0LjU2LjEwOCIsImV4dHJhIjoie1wib3BlbklkXCI6XCJvXzlQTXdfNk9Id2JfMmtuNUNzMTVNY3FCUEhFXCJ9Iiwibm90aWZ5VXJsIjoiaHR0cDovL20uaGVuZ2Fpa2ouY29tL3dlYi9wYXkvcGF5Tm90aWZ5IiwiY3VycmVuY3kiOiJjbnkiLCJkZXZpY2UiOiJXRUIiLCJjaGFubmVsSWQiOiJXWF9KU0FQSSJ9fQ==";
	@Test
	public void testCreateOrder() {
		
		    JSONObject paramObj = JSON.parseObject(new String(HaBase64.decode(jsonParam)));
			PayOrder payOrder = paramObj.getObject("payOrder", PayOrder.class);
			String tradeType = paramObj.getString("tradeType");
			
			WxPayConfig wxPayConfig = WxPayUtil.getWxPayConfig(configParam, tradeType,
					certRootPath, "http://www.hengaiw.com/html");
			WxPayService wxPayService = new WxPayServiceImpl();
			wxPayService.setConfig(wxPayConfig);
			WxPayUnifiedOrderRequest wxPayUnifiedOrderRequest = buildUnifiedOrderRequest(payOrder, wxPayConfig);
			//String payOrderId = payOrder.getPayOrderId();
			WxPayUnifiedOrderResult wxPayUnifiedOrderResult;
			try {
				wxPayUnifiedOrderResult = wxPayService.unifiedOrder(wxPayUnifiedOrderRequest);
				System.out.print("{} >>> 下单成功"+JSON.toJSONString(wxPayUnifiedOrderResult));
				
			} catch (WxPayException e) {
				System.out.print("{} >>> 下单失败"+JSON.toJSONString(e));
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
     		wxPayConfig.setSubMchId(wxPayConfig.getSubMchId());
		}
		if(!StringUtils.isEmpty(wxPayConfig.getSubAppId())) {
     		wxPayConfig.setSubAppId(wxPayConfig.getSubAppId());
     		request.setSubOpenid(openId);
		}
		request.setOpenid("oZ2FfwvgX8o5KoImIG8h6IVuvxB8");
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
		//_log.info("统一下单参数:{}", JSON.toJSONString(request));
		return request;
	}
}
