package com.hengaiw.pay.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengaiw.model.dao.model.MchInfo;
import com.hengaiw.model.dao.model.PayChannel;
import com.hengaiw.model.dao.model.PayOrder;
import com.hengaiw.model.service.MchInfoService;
import com.hengaiw.model.service.PayChannelService;
import com.hengaiw.model.service.HaPayOrderService;
import com.hengaiw.pub.constant.PayConstants;
import com.hengaiw.pub.constant.PayEnum;
import com.hengaiw.pub.utils.AmountUtil;
import com.hengaiw.pub.utils.HaBase64;
import com.hengaiw.pub.utils.HaLog;
import com.hengaiw.pub.utils.HaPayUtil;
import com.hengaiw.pub.utils.IPUtility;
import com.hengaiw.service.channel.payeco.client.TransactionClientH5;
import com.hengaiw.service.channel.payeco.config.EcoPayConfig;
import com.hengaiw.service.channel.payeco.tools.PayEcoTools;
import com.hengaiw.service.channel.payeco.tools.Xml;

/**
 * 微信支付相关接口
 * 
 * @author jianhuizhang
 *
 */
@RestController
@RequestMapping(value = "/pay/eco")
public class PayEcoServiceController {

	private final HaLog _log = HaLog.getLog(PayEcoServiceController.class);
	
	@Autowired
	private HaPayOrderService payOrderService;
	@Autowired
	private PayChannelService payChannelService;
	@Autowired
	private MchInfoService mchInfoService;
	@Autowired
    private EcoPayConfig ecopayConfig;
	

	@RequestMapping(value = "/h5")
	public String doEcoH5Req(@RequestParam String jsonParam) {
		String logPrefix = "【易联H5快捷支付下单】";
		JSONObject paramObj = JSON.parseObject(new String(HaBase64.decode(jsonParam)));
		PayOrder payOrder = paramObj.getObject("payOrder", PayOrder.class);
		String payOrderId = payOrder.getPayOrderId();
		String mchId = payOrder.getMchId();
		String channelId = payOrder.getChannelId();
		MchInfo mchInfo = mchInfoService.selectByMchId(mchId);
		String resKey = mchInfo == null ? "" : mchInfo.getResKey();
		if ("".equals(resKey))
			return HaPayUtil.makeRetFail(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_FAIL, "",
					PayConstants.RETURN_VALUE_FAIL, PayEnum.ERR_0001));
		PayChannel payChannel = payChannelService.selectPayChannel(channelId, mchId);
		ecopayConfig.init(payChannel.getParam());
		//String ChannelParam=payChannel.getParam();
		String amount = AmountUtil.convertCent2Dollar(payOrder.getAmount().toString());
		String orderDesc = payOrder.getSubject();
		String extData = payOrder.getExtra(); //
		// 以下扩展参数是按互联网金融行业填写的；其他行业请参考接口文件说明进行填写
		String miscData = payOrder.getParam1();//"13922897656|0||张三|440121197511140912|62220040001154868428||PAYECO201510285445||2|"; // 互联网金融
		String merchOrderId = payOrderId; // 订单号
		String merchantId = ecopayConfig.getEco_merchant_id();//Constants.MERCHANT_ID;
		String notifyUrl = ecopayConfig.getEco_notify_url();//Constants.MERCHANT_NOTIFY_URL; // 封装的API会自动做URLEncode
		String returnUrl = ecopayConfig.getEco_return_url();//Constants.MERCHANT_RETURN_URL; // 封装的API会自动做URLEncode
		String tradeTime = PayEcoTools.getSysTime();
		String expTime = ""; // 采用系统默认的订单有效时间
		String notifyFlag = "0";
		String clientIp = IPUtility.getLocalIP(); // 客户端IP地址
		String payUrl = "";
		_log.error("易联H5商户ID：{}", merchantId);
		_log.error("易联H5异步地址：{}", notifyUrl);
		_log.error("易联H5同步地址：{}", returnUrl);
		_log.error("易联H5商户私钥：{}", ecopayConfig.getEco_rsa_private_key());
		_log.error("易联H5私钥：{}", ecopayConfig.getEco_payeco_rsa_private_key());
		try {
			
			Xml retXml = new Xml();
			// 接口参数请参考TransactionClient的参数说明
			String ret = TransactionClientH5.MerchantOrderH5(merchantId, merchOrderId, amount, orderDesc, tradeTime,
					expTime, notifyUrl, returnUrl, extData, miscData, notifyFlag, clientIp,
					ecopayConfig.getEco_rsa_private_key(), ecopayConfig.getEco_payeco_rsa_private_key(), ecopayConfig.getEco_payceo_url(), retXml);
			
			if (!"0000".equals(ret)) {
				// _log.error("{}objParams参数格式错误！", logPrefix);
				_log.error("易联H5快捷商户下单接口(H5版本)失败！：retCode={}; msg={}", ret, retXml.getRetMsg());
				// System.out.println("商户下单接口(H5版本)测试失败！：retCode="+ret+";
				// msg="+retXml.getRetMsg());
				// return;
			}
			_log.error("易联H5快捷下单时间戳：{}", retXml.getVerifyTime());
			payUrl = TransactionClientH5.getPayInitRedirectUrl(ecopayConfig.getEco_payceo_url(), retXml);
			// System.out.println("组合跳转地址:"+TransactionClientH5.getPayInitRedirectUrl(Constants.PAYECO_URL,
			// retXml));
		} catch (Exception e) {
			// System.out.println("商户下单接口(H5版本)测试失败！：");
			_log.error("易联H5快捷商户下单接口(H5版本)失败：{}", e.getMessage());
		}
		// String payUrl="http://www.hengaiw.com";
		_log.info("{}生成跳转路径：payUrl={}", logPrefix, payUrl);
		payOrderService.updateStatus4Ing(payOrderId, null);
		_log.info("{}生成请求数据,req={}", logPrefix, "");
		_log.info("###### 商户统一下单处理完成 ######");
		Map<String, Object> map = HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_SUCCESS, "",
				PayConstants.RETURN_VALUE_SUCCESS, null);
		map.put("payOrderId", payOrderId);
		map.put("payUrl", payUrl);
		return HaPayUtil.makeRetData(map, resKey);
	}

}
