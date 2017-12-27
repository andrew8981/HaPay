package com.hengaiw.api.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengaiw.api.serviceclient.PayWxServiceClient;
import com.hengaiw.api.serviceclient.PayAlipayServiceClient;
import com.hengaiw.pub.constant.PayConstants;
import com.hengaiw.pub.utils.HaJsonFormat;
import com.hengaiw.pub.utils.HaPayUtil;
import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 支付订单,包括:统一下单,订单查询,补单等接口
 */
@RestController
@RequestMapping(value = "/pay/order")
public class PayBillController extends PayBaseController {

	@Autowired
	private PayWxServiceClient payWxServiceClient;

	@Autowired
	private PayAlipayServiceClient payAlipayServiceClient;

	
	
	/**
	 * 下载微信的对帐单接口
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/bill")
	public String wxbill(@RequestParam String params) {
		_log.info("###### 开始接收商户请求微信对帐单的请求 ######");
		String logPrefix = "【商户统一退款】";
		ServiceInstance instance = client.getLocalServiceInstance();
		_log.info("{}/pay/order/refund, host:{}, service_id:{}, params:{}", logPrefix, instance.getHost(),
				instance.getServiceId(), params);
		try {
			JSONObject po = JSONObject.parseObject(params);
			JSONObject billObject = null;
			// 验证参数有效性
			Object object = validateBillParams(po);
			if (object instanceof String) {
				_log.info("{}参数校验不通过:{}", logPrefix, object);
				return HaPayUtil.makeRetFail(
						HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_FAIL, object.toString(), null, null));
			}
			if (object instanceof JSONObject)
				billObject = (JSONObject) object;
			if (billObject == null)
				return HaPayUtil
						.makeRetFail(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_FAIL, "支付中心获取对帐单失败", null, null));
			String channelName = billObject.getString("channelName");
			_log.info("请求对帐渠道,ID:{}", channelName);
			switch (channelName) {
			case PayConstants.PayType.PAY_TYPE_WX:// 微信的JSAPI支付
				return payWxServiceClient.doWxBillReq(JSON.toJSONString(billObject));
			case PayConstants.PayType.PAY_TYPE_ALIPAY:
				return payAlipayServiceClient
						.doAlipayBillReq(JSON.toJSONString(billObject));
			default:
				return HaPayUtil.makeRetFail(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_FAIL,
						"不支持的支付渠道类型[channelName=" + channelName + "]", null, null));
			}
			
		} catch (Exception e) {
			_log.error(e, "");
			return HaPayUtil.makeRetFail(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_FAIL, "支付中心系统异常", null, null));
		}
	}

	
	/**
	 * 验证对帐单的参数
	 * @param params
	 * @return
	 */
	private Object validateBillParams(JSONObject params) {
		// 验证请求参数,参数有问题返回错误提示
		String errorMessage;
		String mchId = params.getString("mchId"); // 商户ID
		String channelId = params.getString("channelId"); // 渠道ID号
		String bill_date = params.getString("bill_date"); // 查询日期，类似"20171102"
		String bill_type = params.getString("bill_type");
		// 查询类型ALL，返回当日所有订单信息，默认值 SUCCESS，返回当日成功支付的订单
		// REFUND，返回当日退款订单
		// RECHARGE_REFUND，返回当日充值退款订单（相比其他对账单多一栏“返还手续费”）
		String sign = params.getString("sign"); // 签名
		// 验证请求参数有效性（必选项）
		if (StringUtils.isBlank(mchId)) {
			errorMessage = "request params[mchId] error.";
			return errorMessage;
		}
		if (StringUtils.isBlank(channelId)) {
			errorMessage = "request params[channelId] error.";
			return errorMessage;
		}
		if (StringUtils.isBlank(bill_date)) {
			errorMessage = "request params[bill_date] error.";
			return errorMessage;
		}
		String[] typeArray = { "ALL", "SUCCESS", "REFUND", "RECHARGE_REFUND" };
		if (StringUtils.isBlank(bill_type) || (Arrays.binarySearch(typeArray, bill_type) == -1)) {
			errorMessage = "request params[bill_type] error.";
			return errorMessage;
		}
		// 签名信息
		if (StringUtils.isEmpty(sign)) {
			errorMessage = "request params[sign] error.";
			return errorMessage;
		}

		// 验证商户信息和签名
		Object valResult = validateMchInfoParams(params);
		if (valResult instanceof String) {
			errorMessage = valResult.toString();
			return errorMessage;
		}
		// 验证参数通过,返回JSONObject对象
		JSONObject wxBillObject = new JSONObject();
		wxBillObject.put("mchId", mchId);
		wxBillObject.put("channelId", channelId);
		wxBillObject.put("bill_date", bill_date);
		wxBillObject.put("bill_type", bill_type);
		if(channelId.indexOf(PayConstants.PayType.PAY_TYPE_WX)!=-1) {
			wxBillObject.put("channelName", PayConstants.PayType.PAY_TYPE_WX);
		}else if(channelId.indexOf(PayConstants.PayType.PAY_TYPE_ALIPAY)!=-1) {
			wxBillObject.put("channelName", PayConstants.PayType.PAY_TYPE_ALIPAY);
		}
		return wxBillObject;

	}
}
