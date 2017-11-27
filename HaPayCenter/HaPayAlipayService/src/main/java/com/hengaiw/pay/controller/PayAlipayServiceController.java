package com.hengaiw.pay.controller;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.hengaiw.model.dao.model.MchInfo;
import com.hengaiw.model.dao.model.PayChannel;
import com.hengaiw.model.dao.model.PayOrder;
import com.hengaiw.model.service.MchInfoService;
import com.hengaiw.model.service.PayChannelService;
import com.hengaiw.pay.config.AlipayConfig;
import com.hengaiw.model.service.HaPayOrderService;
import com.hengaiw.pub.constant.PayConstants;
import com.hengaiw.pub.constant.PayEnum;
import com.hengaiw.pub.utils.AmountUtil;
import com.hengaiw.pub.utils.HaBase64;
import com.hengaiw.pub.utils.HaLog;
import com.hengaiw.pub.utils.HaPayUtil;

/**
 * 微信支付相关接口
 * 
 * @author jianhuizhang
 *
 */
@RestController
@RequestMapping(value = "/pay/alipay")
public class PayAlipayServiceController {

	private final HaLog _log = HaLog.getLog(PayAlipayServiceController.class);

	

	@Autowired
	private AlipayConfig alipayConfig;

	@Autowired
	private MchInfoService mchInfoService;
	@Autowired
	private PayChannelService payChannelService;

	@Autowired
	private HaPayOrderService payOrderService;

	/**
	 * 微信的统一下单
	 * 
	 * @param jsonParam
	 * @return
	 */
	@RequestMapping(value = "/wap")
	public String payWxUnifiedOrder(@RequestParam String jsonParam) {
		String logPrefix = "【支付宝WAP支付下单】";
        JSONObject paramObj = JSON.parseObject(new String(HaBase64.decode(jsonParam)));
        PayOrder payOrder = paramObj.getObject("payOrder", PayOrder.class);
        String payOrderId = payOrder.getPayOrderId();
        String mchId = payOrder.getMchId();
        String channelId = payOrder.getChannelId();
        MchInfo mchInfo = mchInfoService.selectByMchId(mchId);
        String resKey = mchInfo == null ? "" : mchInfo.getResKey();
        if("".equals(resKey)) return HaPayUtil.makeRetFail(HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_FAIL, "", PayConstants.RETURN_VALUE_FAIL, PayEnum.ERR_0001));
        PayChannel payChannel = payChannelService.selectPayChannel(channelId, mchId);
		alipayConfig.init(payChannel.getParam());
        AlipayClient client = new DefaultAlipayClient(alipayConfig.getUrl(), alipayConfig.getApp_id(), alipayConfig.getRsa_private_key(), AlipayConfig.FORMAT, AlipayConfig.CHARSET, alipayConfig.getAlipay_public_key(), AlipayConfig.SIGNTYPE);
        AlipayTradeWapPayRequest alipay_request = new AlipayTradeWapPayRequest();
        // 封装请求支付信息
        AlipayTradeWapPayModel model=new AlipayTradeWapPayModel();
        model.setOutTradeNo(payOrderId);
        model.setSubject(payOrder.getSubject());
        model.setTotalAmount(AmountUtil.convertCent2Dollar(payOrder.getAmount().toString()));
        model.setBody(payOrder.getBody());
        model.setProductCode("QUICK_WAP_PAY");
        // 获取objParams参数
        String objParams = payOrder.getExtra();
        if (StringUtils.isNotEmpty(objParams)) {
            try {
                JSONObject objParamsJson = JSON.parseObject(objParams);
                if(StringUtils.isNotBlank(objParamsJson.getString("quit_url"))) {
                    model.setQuitUrl(objParamsJson.getString("quit_url"));
                }
            } catch (Exception e) {
                _log.error("{}objParams参数格式错误！", logPrefix);
            }
        }
        alipay_request.setBizModel(model);
        // 设置异步通知地址
        alipay_request.setNotifyUrl(alipayConfig.getNotify_url());
        // 设置同步地址
        alipay_request.setReturnUrl(alipayConfig.getReturn_url());
        String payUrl = null;
        try {
            payUrl = client.pageExecute(alipay_request).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        _log.info("{}生成跳转路径：payUrl={}", logPrefix, payUrl);
        payOrderService.updateStatus4Ing(payOrderId, null);
        _log.info("{}生成请求支付宝数据,req={}", logPrefix, alipay_request.getBizModel());
        _log.info("###### 商户统一下单处理完成 ######");
        Map<String, Object> map = HaPayUtil.makeRetMap(PayConstants.RETURN_VALUE_SUCCESS, "", PayConstants.RETURN_VALUE_SUCCESS, null);
        map.put("payOrderId", payOrderId);
        map.put("payUrl", payUrl);
        return HaPayUtil.makeRetData(map, resKey);
	}

	/**
	 * 构建微信统一下单请求数据
	 * 
	 * @param payOrder
	 * @param wxPayConfig
	 * @return
	 */

}
