package com.hengaiw.test;

import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengaiw.pub.utils.HaPayUtil;
import com.hengaiw.pub.utils.PayDigestUtil;
import com.hengaiw.pub.utils.QRCodeUtil;

public class testRefund {
	private String mchId = "ee857b555d2472965d36ef7564507bb7";
	private String reqKey = "jjiewr52jogc48d1ltdngfp5tuoivod1u3fg0ip1r4q6ruf9filc1b63l9rpstww2u8imtkccd2bg14tij2nern5v4ds4io03s3lkdbgg6gefi6iknwdjul6bu2o53ds";
	private String resKey = "utq9abvmfv172kd0tbqdcoc13v8dvjpneo2d79gegv02d3rnol5k24jou6kphogv9ct7t7v5ednt7ofitlhmrdlrujmigar7jj19geak1ssqu3he4qiqvlt9ba4e7mpm";

	@Test
	public void testWxRefund() {
		JSONObject paramMap = new JSONObject();
		paramMap.put("mchId", mchId);
		paramMap.put("PayOrderId", "P0020171220143606284000033");
		paramMap.put("RefundAmount", "1");
		String reqSign = PayDigestUtil.getSign(paramMap, reqKey);
		paramMap.put("sign", reqSign); // 签名
		String reqData = "params=" + paramMap.toJSONString();

		String result = HaPayUtil.call4Post("https://www.hengaikj.com/api/pay/order/refund?" + reqData);
		System.out.println(result);
		Map retMap = JSON.parseObject(result);
		if ("SUCCESS".equals(retMap.get("retCode"))) {
			// 验签
			String checkSign = PayDigestUtil.getSign(retMap, resKey, "sign", "payParams");
			String retSign = (String) retMap.get("sign");
			if (checkSign.equals(retSign)) {
				System.out.println("=========支付中心退款验签成功=========");
			} else {
				System.err.println("=========支付中心退款验签失败=========");
				// return null;
			}
		}
	}

	// @Test
	// public void testDecode() {
	// try {
	// String
	// result=QRCodeUtil.decode("/Users/jianhuizhang/Documents/HTML5/testCount/images/34043588.jpg");
	// System.out.println(result);
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
}
