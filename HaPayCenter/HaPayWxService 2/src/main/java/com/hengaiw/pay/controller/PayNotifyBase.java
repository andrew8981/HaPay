package com.hengaiw.pay.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengaiw.model.dao.model.MchInfo;
import com.hengaiw.model.dao.model.PayOrder;
import com.hengaiw.model.service.MchInfoService;
import com.hengaiw.pay.mq.Mq4PayNotify;
import com.hengaiw.pub.constant.PayConstants;
import com.hengaiw.pub.utils.HaLog;
import com.hengaiw.pub.utils.HaPayUtil;
import com.hengaiw.pub.utils.PayDigestUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 支付通知处理基类

 */
@Component
public class PayNotifyBase {

	private static final HaLog _log = HaLog.getLog(PayNotifyBase.class);

	@Autowired
	private Mq4PayNotify mq4PayNotify;

	@Autowired
	private MchInfoService mchInfoService;

	
	public String createNotify(PayOrder payOrder) {
		String mchId = payOrder.getMchId();
		MchInfo mchInfo = mchInfoService.selectByMchId(mchId);
		String resKey = mchInfo.getResKey();
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("payOrderId", payOrder.getPayOrderId() == null ? "" : payOrder.getPayOrderId());           // 支付订单号
		paramMap.put("mchId", payOrder.getMchId() == null ? "" : payOrder.getMchId());                      	// 商户ID
		paramMap.put("mchOrderNo", payOrder.getMchOrderNo() == null ? "" : payOrder.getMchOrderNo());       	// 商户订单号
		paramMap.put("channelId", payOrder.getChannelId() == null ? "" : payOrder.getChannelId());              // 渠道ID
		paramMap.put("amount", payOrder.getAmount() == null ? "" : payOrder.getAmount());                      	// 支付金额
		paramMap.put("currency", payOrder.getCurrency() == null ? "" : payOrder.getCurrency());                 // 货币类型
		paramMap.put("status", payOrder.getStatus() == null ? "" : payOrder.getStatus());               		// 支付状态
		paramMap.put("clientIp", payOrder.getClientIp()==null ? "" : payOrder.getClientIp());   				// 客户端IP
		paramMap.put("device", payOrder.getDevice()==null ? "" : payOrder.getDevice());               			// 设备
		paramMap.put("subject", payOrder.getSubject()==null ? "" : payOrder.getSubject());     	   				// 商品标题
		paramMap.put("channelOrderNo", payOrder.getChannelOrderNo()==null ? "" : payOrder.getChannelOrderNo()); // 渠道订单号
		paramMap.put("param1", payOrder.getParam1()==null ? "" : payOrder.getParam1());               		   	// 扩展参数1
		paramMap.put("param2", payOrder.getParam2()==null ? "" : payOrder.getParam2());               		   	// 扩展参数2
		paramMap.put("paySuccTime", payOrder.getPaySuccTime()==null ? "" : payOrder.getPaySuccTime());			// 支付成功时间
		// 先对原文签名
		String reqSign = PayDigestUtil.getSign(paramMap, resKey);
		paramMap.put("sign", reqSign);   // 签名
		// 签名后再对有中文参数编码
		try {
			paramMap.put("device", URLEncoder.encode(payOrder.getDevice()==null ? "" : payOrder.getDevice(), PayConstants.RESP_UTF8));
			paramMap.put("subject", URLEncoder.encode(payOrder.getSubject()==null ? "" : payOrder.getSubject(), PayConstants.RESP_UTF8));
			paramMap.put("param1", URLEncoder.encode(payOrder.getParam1()==null ? "" : payOrder.getParam1(), PayConstants.RESP_UTF8));
			paramMap.put("param2", URLEncoder.encode(payOrder.getParam2()==null ? "" : payOrder.getParam2(), PayConstants.RESP_UTF8));
		}catch (UnsupportedEncodingException e) {
			_log.error("URL Encode exception.", e);
			return null;
		}
		return JSON.toJSONString(paramMap);
	}
	/**
	 * 创建响应URL
	 * @param payOrder
	 * @param backType 1：前台页面；2：后台接口
	 * @return
	 */
	public String createNotifyUrl(PayOrder payOrder, String backType) {
		String mchId = payOrder.getMchId();
		MchInfo mchInfo = mchInfoService.selectByMchId(mchId);
		String resKey = mchInfo.getResKey();
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("payOrderId", payOrder.getPayOrderId() == null ? "" : payOrder.getPayOrderId());           // 支付订单号
		paramMap.put("mchId", payOrder.getMchId() == null ? "" : payOrder.getMchId());                      	// 商户ID
		paramMap.put("mchOrderNo", payOrder.getMchOrderNo() == null ? "" : payOrder.getMchOrderNo());       	// 商户订单号
		paramMap.put("channelId", payOrder.getChannelId() == null ? "" : payOrder.getChannelId());              // 渠道ID
		paramMap.put("amount", payOrder.getAmount() == null ? "" : payOrder.getAmount());                      	// 支付金额
		paramMap.put("currency", payOrder.getCurrency() == null ? "" : payOrder.getCurrency());                 // 货币类型
		paramMap.put("status", payOrder.getStatus() == null ? "" : payOrder.getStatus());               		// 支付状态
		paramMap.put("clientIp", payOrder.getClientIp()==null ? "" : payOrder.getClientIp());   				// 客户端IP
		paramMap.put("device", payOrder.getDevice()==null ? "" : payOrder.getDevice());               			// 设备
		paramMap.put("subject", payOrder.getSubject()==null ? "" : payOrder.getSubject());     	   				// 商品标题
		paramMap.put("channelOrderNo", payOrder.getChannelOrderNo()==null ? "" : payOrder.getChannelOrderNo()); // 渠道订单号
		paramMap.put("param1", payOrder.getParam1()==null ? "" : payOrder.getParam1());               		   	// 扩展参数1
		paramMap.put("param2", payOrder.getParam2()==null ? "" : payOrder.getParam2());               		   	// 扩展参数2
		paramMap.put("paySuccTime", payOrder.getPaySuccTime()==null ? "" : payOrder.getPaySuccTime());			// 支付成功时间
		paramMap.put("backType", backType==null ? "" : backType);
		// 先对原文签名
		String reqSign = PayDigestUtil.getSign(paramMap, resKey);
		paramMap.put("sign", reqSign);   // 签名
		// 签名后再对有中文参数编码
		try {
			paramMap.put("device", URLEncoder.encode(payOrder.getDevice()==null ? "" : payOrder.getDevice(), PayConstants.RESP_UTF8));
			paramMap.put("subject", URLEncoder.encode(payOrder.getSubject()==null ? "" : payOrder.getSubject(), PayConstants.RESP_UTF8));
			paramMap.put("param1", URLEncoder.encode(payOrder.getParam1()==null ? "" : payOrder.getParam1(), PayConstants.RESP_UTF8));
			paramMap.put("param2", URLEncoder.encode(payOrder.getParam2()==null ? "" : payOrder.getParam2(), PayConstants.RESP_UTF8));
		}catch (UnsupportedEncodingException e) {
			_log.error("URL Encode exception.", e);
			return null;
		}
		String param = HaPayUtil.genUrlParams(paramMap);
		StringBuffer sb = new StringBuffer();
		sb.append(payOrder.getNotifyUrl()).append("?").append(param);
		return sb.toString();
	}

	/**
	 * 处理支付结果前台页面跳转
	 */
	public boolean doPage(PayOrder payOrder, HttpServletResponse response) {
		String redirectUrl = createNotifyUrl(payOrder, "1");
		_log.info("redirect to respUrl:"+redirectUrl);
		// 前台跳转业务系统
		try {
			response.sendRedirect(redirectUrl);
		} catch (IOException e) {
			_log.error("Pay sendRedirect exception. respUrl="+redirectUrl, e);
			return false;
		}
		return true;
	}

	/**
	 * 处理支付结果后台服务器通知
	 */
	public void doNotify(PayOrder payOrder) {
		_log.info(">>>>>> PAY开始回调通知业务系统 <<<<<<");
		// 发起后台通知业务系统
		JSONObject object = createNotifyInfo(payOrder);
		try {
			/**
			 * 此处编写通知给商户的代码，可选方案多种，可以使用消息中间件。也可以直接对商户提交的消息接收地址发送。
			 */
			_log.info("回调参数:{}", object.toJSONString());
			//String result=HaPayUtil.call4Post(payOrder.getNotifyUrl() + "?params=" + createNotify(payOrder));
			mq4PayNotify.send(object.toJSONString());
			//_log.info("回调结果:{}",result);
		} catch (Exception e) {
			_log.error("payOrderId={},sendMessage error.", payOrder != null ? payOrder.getPayOrderId() : "", e);
		}
		_log.info(">>>>>> PAY回调通知业务系统完成 <<<<<<");
	}

	public JSONObject createNotifyInfo(PayOrder payOrder) {
		JSONObject object = new JSONObject();
		object.put("method", "GET");
		object.put("url", createNotifyUrl(payOrder, "2"));
		object.put("orderId", payOrder.getPayOrderId());
		object.put("count", payOrder.getNotifyCount());
		object.put("createTime", System.currentTimeMillis());
		return object;
	}

}
