package com.hengaiw.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.Test;

import com.github.binarywang.wxpay.config.WxPayConfig;
import com.hengaiw.pay.config.WxPayUtil;
import com.hengaiw.pay.utils.WXPay;
import com.hengaiw.pay.utils.WxUtil;
import com.hengaiw.pub.utils.HaBase64;
import com.hengaiw.pub.utils.HaSerial;
import com.hengaiw.pub.utils.IPUtility;
import com.hengaiw.pub.utils.RSAEncrypt;

import java.lang.reflect.Method;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
public class TestWx {
	private static String certRootPath = "/Users/jianhuizhang/Downloads/cert";
	private static AtomicLong send_seq = new AtomicLong(0L);
//	@Test
//	public void sendWeixin() {
//		String configParam = "{\"mchId\":\"1490527632\",\"appId\":\"wx9ed8fbe06bde3bad\",\"key\":\"EIOHGdsgihdsiogs20ds1g2sdggsd211\",\"certLocalPath\":\"apiclient_cert.p12\"}";
//		WxPayConfig wxPayConfig = WxPayUtil.getWxPayConfig(configParam,"",certRootPath,"");
//		try {
//			WXPay wxPay=new WXPay(wxPayConfig);
//			Map<String, String> reqData=new HashMap<>();
//			reqData.put("mch_appid", wxPayConfig.getAppId());
//			reqData.put("mchid", wxPayConfig.getMchId());
//			reqData.put("partner_trade_no", HaSerial.getTrans());
//			reqData.put("openid", "oZ2FfwvgX8o5KoImIG8h6IVuvxB8");
//			reqData.put("check_name", "NO_CHECK");
//			reqData.put("amount", "100");
//			reqData.put("desc", "测试");
//			reqData.put("spbill_create_ip", IPUtility.getLocalIP());
//			String result=wxPay.requestWithCert("api.mch.weixin.qq.com", "/mmpaymkttransfers/promotion/transfers", reqData, 6*1000, 8*1000);
//			Map<String, String> resultData=new HashMap<>();
//			resultData=WxUtil.xmlToMap(result);
//			System.out.print(result);
//		}catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	
//	@Test
//	public void sendCard() {
//		String configParam = "{\"mchId\":\"1494346192\",\"appId\":\"wxdb599665a42a37c6\",\"key\":\"uuwkei7782939327sdflslfwpwefwfew\",\"certLocalPath\":\"/1494346192/apiclient_cert.p12\"}";
//		//String RsaPubKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuA7XMt4U3grB+XVDekdUMOGeV7iqhUppMQjxRtMPq7V7BvJSil65r/2GVxbszY+pjpb7OJtBGJrP2Efw6SY/39JrPH2tHPujbbwc5kpZbqUZ+cXSnAiyWfwkMusbN3gS5pf6Z4w3Ok56R8jJHFiKcD4qmWw0yuDGE4CGwxurDVTPTdTx1PQKk+D+2KUfzD/c94tJR9hyQ6/8kY7v/cM1pOkFEP+zFJTdyOl2fQSr5pxwTSGRe11rPLo4K7NdUYBgC50Vc2G5q3FgcXbXvpBvstzfso8phm7/7hQ38cproHqZqa5/+3Y/c9Ynoxz4iJ2oPsIsBnX/zXbL9gKynYAK9QIDAQAB";
//		WxPayConfig wxPayConfig = WxPayUtil.getWxPayConfig(configParam,"",certRootPath,"");
//		try {
//			WXPay wxPay=new WXPay(wxPayConfig);
//			Map<String, String> reqData=new HashMap<>();
//			reqData.put("partner_trade_no", HaSerial.getTrans());
//			String bank_no="6228440018001342070";
//			PublicKey pub=TestRsa.getPubKey("/Users/jianhuizhang/Downloads/cert/1494346192/public_key_8.pem","RSA"); 
//			byte[] cipherData=TestRsa.encrypt(bank_no.getBytes(),pub,2048, 11,"RSA/ECB/PKCS1Padding");    
//	        String enc_bank_no=HaBase64.encode(cipherData);
//	        String true_name="张建辉";
//	        byte[] nameData=TestRsa.encrypt(true_name.getBytes("UTF-8"),pub,2048, 11,"RSA/ECB/PKCS1Padding");;
//	        String enc_true_name=HaBase64.encode(nameData);
//			reqData.put("enc_bank_no", enc_bank_no);
//			reqData.put("enc_true_name", enc_true_name);
//			String bank_code="1005";
//			reqData.put("bank_code", bank_code);
//			reqData.put("amount", "1");
//			reqData.put("desc", "test");
//			reqData.put("bank_note", "test");
//			String result=wxPay.requestWithCert("api.mch.weixin.qq.com", "/mmpaysptrans/pay_bank", reqData, 6*1000, 8*1000);
//			Map<String, String> resultData=new HashMap<>();
//			resultData=WxUtil.xmlToMap(result);
//			System.out.print(result);
//		}catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	

//	
//	
	@Test
	public void getCert() {
		String configParam = "{\"mchId\":\"1494346192\",\"appId\":\"wxdb599665a42a37c6\",\"key\":\"uuwkei7782939327sdflslfwpwefwfew\",\"certLocalPath\":\"/1494346192/apiclient_cert.p12\"}";
		WxPayConfig wxPayConfig = WxPayUtil.getWxPayConfig(configParam,"",certRootPath,"");
		try {
			WXPay wxPay=new WXPay(wxPayConfig);
			Map<String, String> reqData=new HashMap<>();
			String result=wxPay.requestWithCert("fraud.mch.weixin.qq.com", "/risk/getpublickey", reqData, 6*1000, 8*1000);
			Map<String, String> resultData=new HashMap<>();
			resultData=WxUtil.xmlToMap(result);
			System.out.println(resultData.get("pub_key"));
		
//			String plainText="342444555666";
//			byte[] cipherData=RSAEncrypt.encrypt(RSAEncrypt.loadPublicKeyByStr(pubKey),plainText.getBytes());  
//	        String cipher=HaBase64.encode(cipherData);
//	        System.out.println(cipher);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
