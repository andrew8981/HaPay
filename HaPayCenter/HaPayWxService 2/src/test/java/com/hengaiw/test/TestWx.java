package com.hengaiw.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.slf4j.Logger;

import com.alibaba.fastjson.JSON;
import com.hengaiw.pay.wx.config.HaWxConfigImpl;
import com.hengaiw.pay.wx.sdk.WXPay;
import com.hengaiw.pay.wx.sdk.WXPayUtil;

public class TestWx {
	private static String certRootPath = "/Users/jianhuizhang/Downloads/cert/";
	private static WXPay wxpay;

	@Test
	public void testRefund() {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("out_trade_no", "P0020171207213055514000001");
		data.put("out_refund_no", "R0020171207213155052000008");
		data.put("total_fee", "1");
		data.put("refund_fee", "1");
		data.put("refund_fee_type", "cny");
		try {
			Logger _log = WXPayUtil.getLogger();
			_log.info("sfsfsdfdsfsdffdssfd");
			String configParam = "{\"mchId\":\"1490527632\",\"appId\":\"wx9ed8fbe06bde3bad\",\"key\":\"EIOHGdsgihdsiogs20ds1g2sdggsd211\",\"certLocalPath\":\"\",\"certName\":\"apiclient_cert.p12\"}";
			HaWxConfigImpl config;
			config = HaWxConfigImpl.getInstance(configParam, certRootPath);
			System.out.println(config.getKey());
			wxpay = new WXPay(config);
			Map<String, String> r = wxpay.refund(data);
			System.out.println(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
//	@Test
//	public void testPostPay() {
//		HashMap<String, String> data = new HashMap<String, String>();
//		data.put("out_trade_no", "1493279484111-1");
//		data.put("body", "测试");
//		data.put("total_fee", "1");
//		data.put("auth_code", "135515101262729066");
//		try {
//			Logger _log = WXPayUtil.getLogger();
//			_log.info("sfsfsdfdsfsdffdssfd");
//			String configParam = "{\"mchId\":\"1490527632\",\"appId\":\"wx9ed8fbe06bde3bad\",\"key\":\"EIOHGdsgihdsiogs20ds1g2sdggsd211\",\"certLocalPath\":\"\",\"certName\":\"apiclient_cert.p12\"}";
//			HaWxConfigImpl config;
//			config = HaWxConfigImpl.getInstance(configParam, certRootPath);
//			System.out.println(config.getKey());
//			wxpay = new WXPay(config);
//			Map<String, String> r = wxpay.microPayWithPos(data);
//			System.out.println(r);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	
	//
	//
	// @Test
	// public void testNative() {
	// HashMap<String, String> data = new HashMap<String, String>();
	// data.put("body", "腾讯充值中心-QQ会员充值");
	// data.put("out_trade_no", "P09283893930040404");
	// data.put("device_info", "");
	// data.put("fee_type", "CNY");
	// data.put("total_fee", "1");
	// data.put("spbill_create_ip", "123.12.12.123");
	// data.put("notify_url", "http://test.letiantian.me/wxpay/notify");
	// data.put("trade_type", "NATIVE");
	// data.put("product_id", "12");
	// // data.put("time_expire", "20170112104120");
	//
	// try {
	// Map<String, String> r = wxpay.unifiedOrder(data);
	// System.out.println(r);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	//
	//
	//
	// @Test
	// public void testWx() {
	// System.out.println("OK");
	// Logger _log=WXPayUtil.getLogger();
	// _log.info("sfsfsdfdsfsdffdssfd");
	// String configParam =
	// "{\"mchId\":\"1490527632\",\"appId\":\"wx9ed8fbe06bde3bad\",\"key\":\"EIOHGdsgihdsiogs20ds1g2sdggsd211\",\"certLocalPath\":\"\",\"certName\":\"apiclient_cert.p12\"}";
	// HaWxConfigImpl config;
	// try {
	// config = HaWxConfigImpl.getInstance(configParam, certRootPath);
	// System.out.println(config.getKey());
	// wxpay = new WXPay(config);
	// HashMap<String, String> data = new HashMap<String, String>();
	// data.put("bill_date", "20171130");
	// data.put("bill_type", "ALL");
	// try {
	// Map<String, String> r = wxpay.downloadBill(data);
	// System.out.println(JSON.toJSON(r));
	// String str=r.get("data");
	// String listStr="";
	// String objStr ="";
	// if(str.indexOf("总交易单数")>=0){
	// listStr = str.substring(0, str.indexOf("总交易单数"));
	// objStr = str.substring(str.indexOf("总交易单数"));
	// }
	// String[] ss = str.split("\r\n");
	// System.out.println(ss[ss.length-1]);
	// String[] dayStr=ss[ss.length-1].split(",");
	// for(int day=0;day<dayStr.length;day++) {
	// System.out.println(dayStr[day].substring(1, dayStr[day].length()));
	// }
	// for(int row=1;row<ss.length-2;row++) {
	// if(ss[row].indexOf("`")!=-1) {
	//
	// }
	// }
	// String newStr = listStr.replaceAll(",", " "); // 去空格
	// String[] tempStr = newStr.split("`"); // 数据分组
	// String[] t = tempStr[0].split(" ");// 分组标题
	// int k = 1; // 纪录数组下标
	// int j = tempStr.length / t.length; // 计算循环次数
	// for (int i = 0; i < j; i++) {
	// System.out.print(j);
	//// for (int l = 0; l < t.length; l++) {
	//// /*********************** 我添加的开始 ***********************/
	//// //如果是最后列且是最后一行数据时，去除数据里的汉字
	//// if((i == j - 1) && (l == t.length -1)){
	//// String reg = "[\u4e00-\u9fa5]";//汉字的正则表达式
	//// Pattern pat = Pattern.compile(reg);
	//// Matcher mat=pat.matcher(tempStr[l + k]);
	//// String repickStr = mat.replaceAll("");
	//// System.out.println(t[l] + "1:" + repickStr);
	//// }else{
	//// System.out.println(t[l] + "2:" + tempStr[l + k]);
	//// }
	//// /*********************** 我添加的结束 ***********************/
	//// }
	//// System.out.println("---------");// 摘取有用数据存入数据库
	//// k = k + t.length;
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	//
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	//
	// }
	// }
}
