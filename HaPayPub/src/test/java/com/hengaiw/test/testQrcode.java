package com.hengaiw.test;

import org.junit.Test;

import com.hengaiw.pub.utils.QRCodeUtil;

public class testQrcode {

	 @Test
	 public void testqr() {
		 try {
			QRCodeUtil.encode("test","./qr/logo_small.png","./qr");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
//	 @Test
//	 public void testDecode() {
//		 try {
//			String result=QRCodeUtil.decode("/Users/jianhuizhang/Documents/HTML5/testCount/images/34043588.jpg");
//			System.out.println(result);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	 }
}
