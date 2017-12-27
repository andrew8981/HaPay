package com.hengaiw.test;

import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengaiw.pub.utils.HaPayUtil;
import com.hengaiw.pub.utils.PayDigestUtil;
import com.hengaiw.pub.utils.QRCodeUtil;

public class testQrcode {
	private String mchId = "20001223";
	private String reqKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCjVOuni/RIeXVA6KwXbfZhisopkIBFNwkg4kZjeYlINFv4i9uLccYnK9kUZcoJplbbf/fS/UeGwyQ77RSfG1wHeaYOYtBxV4lGoBao56hvT1PvBZd7Pw169uMO3l+wzMXmh5V4IXqp2RY9MmZ9U+V4jKjW90aztWc1zTDqXS4Z4wIDAQAB";
	private String resKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKNU66eL9Eh5dUDorBdt9mGKyimQgEU3CSDiRmN5iUg0W/iL24txxicr2RRlygmmVtt/99L9R4bDJDvtFJ8bXAd5pg5i0HFXiUagFqjnqG9PU+8Fl3s/DXr24w7eX7DMxeaHlXgheqnZFj0yZn1T5XiMqNb3RrO1ZzXNMOpdLhnjAgMBAAECgYAJyXHhdUJrAVQkUozVTpJ/38gjW3REMXsLjGN5XHP8bp7AMukx3txnxnnYfgzwLRZxSqa37tNVYOYP7THaItKNy5aSeZfDs3xbokk/lWnc1M0uIyjXd/u9TtzJCxmnVtYyxaWsDetcKKayoBpT+z0SRJ5+Aj9SwdtYwHuEq/ad6QJBANUG5CFKfwh8n95BN0vGpuJFIID+UXbxzX+Tbn9oGAiXkGnACvfkQWF9c3oWmT+AdXYsnJRmg5Osdf6QlKhw1mcCQQDER60laS2+2I6YUMqMupaDOLpJePvVlryds6I0KEPKy5l3s4wWyS+OSs2UQ+P6QAQ3W0QugbpSfA/vuZ5Lw9slAkEAkj7o3vIFxA3KswqSq7L1XuGWLvhpdP8L1Umh0lXkKgHjYrY00XoiaIt3e5mIG9BU04xM8pRuQDNlzh3z8K+GgQJAZXNuyVFt9aDVQ2Eu8EJZHYYqs2M3N5Tr9M8uXasaLy3BKx/Ant5qGDANxj65DVYdV8dynF8tQQki65OTgDHBiQJAQYZC591dOFKF+LiisRLx3e5VyHCadpYgwC2YhO37grqg366yP8pdVWZoY+HT9PltGMcvcv8dOCgD01Kk7d8D6A==";

	@Test
	public void testWxRefund() {
		JSONObject paramMap = new JSONObject();
		paramMap.put("mchId", mchId);
		paramMap.put("PayOrderId", "P0020171201190438319000391");
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
