package com.hengaiw.api.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengaiw.api.serviceclient.PayWxServiceClient;
import com.hengaiw.api.serviceclient.PayAlipayServiceClient;
import com.hengaiw.api.serviceclient.PayBaseServiceClient;
import com.hengaiw.pub.constant.PayConstants;
import com.hengaiw.pub.utils.HaJsonFormat;
import com.hengaiw.pub.utils.HaLog;
import com.hengaiw.pub.utils.HaPayUtil;
import com.hengaiw.pub.utils.HaSerial;

import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 支付订单,包括:统一下单,订单查询,补单等接口
 */
@RestController
@RequestMapping(value = "/pay/order")
public class PayEntpayController extends PayBaseController {

	@Autowired
	private PayWxServiceClient payWxServiceClient;

	@Autowired
	private PayAlipayServiceClient payAlipayServiceClient;

	/**
	 * 转帐接口
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/entpay")
	public String entpay(@RequestParam String params) {
		_log.info("###### 开始接收商户请求微信转帐的请求 ######");
		String logPrefix = "【商户转帐】";
		ServiceInstance instance = client.getLocalServiceInstance();
		_log.info("{}/pay/order/entpay, host:{}, service_id:{}, params:{}", logPrefix, instance.getHost(),
				instance.getServiceId(), params);
		try {
			JSONObject po = JSONObject.parseObject(params);
			JSONObject entpayObject = null;
			// 验证参数有效性
			Object object = validateEntpayParams(po);
			if (object instanceof String) {
				_log.info("{}参数校验不通过:{}", logPrefix, object);
				return HaPayUtil.makeRetFail(
						HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_FAIL, object.toString(), null, null));
			}
			if (object instanceof JSONObject)
				entpayObject = (JSONObject) object;
			if (entpayObject == null)
				return HaPayUtil
						.makeRetFail(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_FAIL, "支付中心申请转帐失败", null, null));

			String result = payBaseServiceClient
					.createEntpayOrder(JSON.toJSONString(entpayObject));
			_log.info("{}创建转帐订单,结果:{}", logPrefix, result);
			if (StringUtils.isEmpty(result)) {
				return HaPayUtil
						.makeRetFail(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_FAIL, "创建转帐订单失败", null, null));
			}
			JSONObject resObj = JSON.parseObject(result);
			if (resObj == null || !"1".equals(resObj.getString("result")))
				return HaPayUtil
						.makeRetFail(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_FAIL, "创建转帐订单失败", null, null));

			String channelName = entpayObject.getString("channelName");
			_log.info("请求转帐渠道,ID:{}", channelName);
			switch (channelName) {
			case PayConstants.PayType.PAY_TYPE_WX:// 微信的JSAPI支付
				return payWxServiceClient.doWxEntpayReq(HaJsonFormat.getJsonParam("entpayOrder", entpayObject));
			case PayConstants.PayType.PAY_TYPE_ALIPAY:
				return payAlipayServiceClient
						.doAlipayEntpayReq(HaJsonFormat.getJsonParam("entpayOrder", entpayObject));
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
	 * 验证转帐的参数
	 * 
	 * @param params
	 * @return
	 */
	private Object validateEntpayParams(JSONObject params) {
		// 验证请求参数,参数有问题返回错误提示
		String errorMessage;
		String mchId = params.getString("mchId"); // 商户ID
		String channelId = params.getString("channelId"); // 渠道ID号
		String sign = params.getString("sign"); // 签名
		String deviceInfo = params.getString("deviceInfo");
		String amount = params.getString("amount");
		String remarkInfo = params.getString("remarkInfo");
		String clientIp = params.getString("clientIp");
		String extra = params.getString("extra"); // 特定渠道发起时额外参数
		// 验证请求参数有效性（必选项）
		if (StringUtils.isBlank(mchId)) {
			errorMessage = "request params[mchId] error.";
			return errorMessage;
		}
		if (StringUtils.isBlank(channelId)) {
			errorMessage = "request params[channelId] error.";
			return errorMessage;
		}
		// 签名信息
		if (StringUtils.isEmpty(sign)) {
			errorMessage = "request params[sign] error.";
			return errorMessage;
		}

		// 付款
		if (StringUtils.isEmpty(amount)) {
			errorMessage = "request params[amount] error.";
			return errorMessage;
		}
		// 转帐备注
		if (StringUtils.isEmpty(remarkInfo)) {
			errorMessage = "request params[remarkInfo] error.";
			return errorMessage;
		}
		// 客户端IP
		if (StringUtils.isEmpty(clientIp)) {
			errorMessage = "request params[clientIp] error.";
			return errorMessage;
		}
		if (StringUtils.isEmpty(extra)) {
			errorMessage = "request params[extra] error.";
			return errorMessage;
		}
		// 验证商户信息和签名
		Object valResult = validateMchInfoParams(params);
		if (valResult instanceof String) {
			errorMessage = valResult.toString();
			return errorMessage;
		}

		String channelName = PayConstants.PayType.PAY_TYPE_WX;
		if (channelId.indexOf(PayConstants.PayType.PAY_TYPE_WX) != -1) {
			channelName = PayConstants.PayType.PAY_TYPE_WX;
		} else if (channelId.indexOf(PayConstants.PayType.PAY_TYPE_ALIPAY) != -1) {
			channelName = PayConstants.PayType.PAY_TYPE_ALIPAY;
		}
		switch (channelName) {
		case PayConstants.PayType.PAY_TYPE_WX:
			JSONObject extraObject = JSON.parseObject(extra);
			String openId = extraObject.getString("openId");
			String checkName = extraObject.getString("checkName");
			String userName = extraObject.getString("userName");
			if (StringUtils.isEmpty(openId)) {
				errorMessage = "request params[openId] error.";
				return errorMessage;
			}
			if (StringUtils.isEmpty(checkName)) {
				errorMessage = "request params[checkName] error.";
				return errorMessage;
			}
			if (StringUtils.isEmpty(userName)) {
				errorMessage = "request params[userName] error.";
				return errorMessage;
			}
			break;
		case PayConstants.PayType.PAY_TYPE_ALIPAY:

			break;
		}

		
		// 验证参数通过,返回JSONObject对象
		JSONObject entpayObject = new JSONObject();
		entpayObject.put("entpayOrderId", HaSerial.getEntpay());
		entpayObject.put("mchId", mchId);
		entpayObject.put("channelId", channelId);
		entpayObject.put("channelName", channelName);
		entpayObject.put("deviceInfo", deviceInfo);
		entpayObject.put("extra", extra);
		entpayObject.put("amount", amount);
		entpayObject.put("remarkInfo", remarkInfo);
		entpayObject.put("clientIp", clientIp);
		return entpayObject;

	}

}
