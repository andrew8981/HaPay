package com.hengaiw.service.channel.payeco.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
@RefreshScope
@Service
public class EcoPayConfig {
	//商户编号，由易联产生，邮件发送给商户
	private String eco_merchant_id;
	//商户接收订单通知接口地址（异步通知）；
	@Value("${eco.notify_url}")
	private String eco_notify_url;
	//商户接收订单通知接口地址(同步通知),H5版本对接需要该参数；
	private String eco_return_url;
	//商户RSA私钥，商户自己产生（可采用易联提供RSA工具产生）
	private String eco_rsa_private_key;
	//易联服务器地址_测试环境
	@Value("${eco.payeco_url}")
	private String eco_payceo_url;
	//订单RSA公钥（易联提供）_测试环境
	@Value("${eco.payeco_rsa_private_key}")
	private String eco_payeco_rsa_private_key;
	
	public EcoPayConfig init(String configParam){
		 Assert.notNull(configParam, "init payeco config error");
	     JSONObject paramObj = JSON.parseObject(configParam);
	     this.setEco_merchant_id(paramObj.getString("merchant_id"));
	     //this.setEco_notify_url(paramObj.getString("notify_url"));
	     this.setEco_return_url(paramObj.getString("return_url"));
	     this.setEco_rsa_private_key(paramObj.getString("rsa_private_key"));
	     return this;
	}
	
	public String getEco_payceo_url(){
		return eco_payceo_url;
	}
	
	public void setEco_payceo_url(String eco_payceo_url){
		this.eco_payceo_url=eco_payceo_url;
	}
	
	public String getEco_payeco_rsa_private_key(){
		return eco_payeco_rsa_private_key;
	}
	
	public void setEco_payeco_rsa_private_key(String eco_payeco_rsa_private_key){
		this.eco_payeco_rsa_private_key=eco_payeco_rsa_private_key;
	}
	
	public String getEco_merchant_id() {
		return eco_merchant_id;
	}

	public void setEco_merchant_id(String eco_merchant_id) {
		this.eco_merchant_id = eco_merchant_id;
	}

	public String getEco_notify_url() {
		return eco_notify_url;
	}

	public void setEco_notify_url(String eco_notify_url) {
		this.eco_notify_url = eco_notify_url;
	}

	public String getEco_return_url() {
		return eco_return_url;
	}

	public void setEco_return_url(String eco_return_url) {
		this.eco_return_url = eco_return_url;
	}

	public String getEco_rsa_private_key() {
		return eco_rsa_private_key;
	}

	public void setEco_rsa_private_key(String eco_rsa_private_key) {
		this.eco_rsa_private_key = eco_rsa_private_key;
	}
}
