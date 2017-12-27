package com.hengaiw.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengaiw.pub.utils.HaPayUtil;
import com.hengaiw.pub.utils.PayDigestUtil;

@Controller
@RequestMapping("/web/pay")
public class RefundOrderController {
	@Value("${mch.reqKey}")
	private  String reqKey;
	@Value("${mch.resKey}")
	private  String resKey;
	@Value("${pay.refundOrderUrl}")
	private String refundOrderUrl;

	@RequestMapping("/testRefund.html")
	public String testRefund(ModelMap model, HttpServletRequest request) {
		String mchId=request.getParameter("mchId");
		String PayOrderId=request.getParameter("PayOrderId");
		String RefundAmount=request.getParameter("RefundAmount");
		String result="";
		if(!StringUtils.isBlank(PayOrderId)) {
			JSONObject paramMap = new JSONObject();
			paramMap.put("mchId", mchId);
			paramMap.put("PayOrderId", PayOrderId);
			paramMap.put("RefundAmount", RefundAmount);
			String reqSign = PayDigestUtil.getSign(paramMap, reqKey);
			paramMap.put("sign", reqSign); // 签名
			String reqData = "params=" + paramMap.toJSONString();
			
			result = HaPayUtil.call4Post(refundOrderUrl + reqData);
			Map retMap = JSON.parseObject(result);
	        if("SUCCESS".equals(retMap.get("retCode"))) {
	            // 验签
	            String checkSign = PayDigestUtil.getSign(retMap, resKey, "sign", "payParams");
	            String retSign = (String) retMap.get("sign");
	            if(checkSign.equals(retSign)) {
	                System.out.println("=========支付中心退款验签成功=========");
	            }else {
	                System.err.println("=========支付中心退款验签失败=========");
	                return null;
	            }
	        }
		}
		model.put("result", result);
		return "web/testRefund";
	}
}
