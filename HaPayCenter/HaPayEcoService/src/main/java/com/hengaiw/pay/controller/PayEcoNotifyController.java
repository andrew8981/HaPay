package com.hengaiw.pay.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hengaiw.model.dao.model.PayChannel;
import com.hengaiw.model.dao.model.PayOrder;
import com.hengaiw.model.service.HaPayOrderService;
import com.hengaiw.model.service.PayChannelService;
import com.hengaiw.pub.constant.PayConstants;
import com.hengaiw.pub.utils.HaLog;
import com.hengaiw.service.channel.payeco.client.TransactionClient;

import java.util.Iterator;
/**
 * @Description: 接收处理微信通知
 
 */
@RestController
public class PayEcoNotifyController extends PayNotifyBase {

	private static final HaLog _log = HaLog.getLog(PayEcoNotifyController.class);

	@Autowired
	private HaPayOrderService payOrderService;
	@Autowired
	private PayChannelService payChannelService;

	@Value("${eco.payeco_rsa_private_key}")
	private String payeco_rsa_private_key;

	@RequestMapping(value = "/pay/eco/payNotifyRes.htm")
	@ResponseBody
	public String ecoPayNotifyRes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return doEcoPayRes(request, response);
	}

	public String doEcoPayRes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String logPrefix = "【易联快捷H5支付回调通知】";
		_log.info("====== 开始接收易联支付回调通知 ======");
		// 结果通知参数，易联异步通知采用GET提交
        String version = request.getParameter("Version");
        String merchantId = request.getParameter("MerchantId");
        String merchOrderId = request.getParameter("MerchOrderId");
        String amount = request.getParameter("Amount");
        String extData = request.getParameter("ExtData");
        String orderId = request.getParameter("OrderId");
        String status = request.getParameter("Status");
        String payTime = request.getParameter("PayTime");
        String settleDate = request.getParameter("SettleDate");
        String sign = request.getParameter("Sign");
        //此处进行参数验证
        Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(name, valueStr);
		}
		_log.info("{}通知请求数据:reqStr={}", logPrefix, params);
		if(params.isEmpty()) {
			_log.error("{}请求参数为空", logPrefix);
			return PayConstants.RETURN_ALIPAY_VALUE_FAIL;
		}
		Map<String, Object> payContext = new HashMap();
		PayOrder payOrder;
		payContext.put("parameters", params);
		if(!verifyEcoPayParams(payContext)) {
			return PayConstants.RETURN_ALIPAY_VALUE_FAIL;
		}
        // 订单结果逻辑处理
        String retMsgJson = "";
        try {
            //Log.setLogFlag(true);
        	_log.info("---交易： 同步通知(H5版本)-------------------------");
            //验证订单结果通知的签名
            boolean b = TransactionClient.bCheckNotifySign(version, merchantId, merchOrderId, 
                    amount, extData, orderId, status, payTime, settleDate, sign, 
                    payeco_rsa_private_key);
            if (!b) {
                retMsgJson = "{\"RetCode\":\"E101\",\"RetMsg\":\"验证签名失败!\"}";
                _log.info("验证签名失败!");
            }else{
                // 签名验证成功后，需要对订单进行后续处理
                if ("02".equals(status)) { // 订单已支付
   				//if ("0000".equals(status)) { // 若是互联金融行业, 订单已支付的状态为【0000】                	
                    // 1、检查Amount和商户系统的订单金额是否一致
                    // 2、订单支付成功的业务逻辑处理请在本处增加（订单通知可能存在多次通知的情况，需要做多次通知的兼容处理）；
                    // 3、返回响应内容
                	int updatePayOrderRows;
        			payOrder = (PayOrder)payContext.get("payOrder");
        			byte payStatus = payOrder.getStatus(); // 0：订单生成，1：支付中，-1：支付失败，2：支付成功，3：业务处理完成，-2：订单过期
        			if (payStatus != PayConstants.PAY_STATUS_SUCCESS && payStatus != PayConstants.PAY_STATUS_COMPLETE) {
        				updatePayOrderRows = payOrderService.updateStatus4Success(payOrder.getPayOrderId());
        				if (updatePayOrderRows != 1) {
        					_log.error("{}更新支付状态失败,将payOrderId={},更新payStatus={}失败", logPrefix, payOrder.getPayOrderId(), PayConstants.PAY_STATUS_SUCCESS);
        					_log.info("{}响应给支付宝结果：{}", logPrefix, PayConstants.RETURN_ALIPAY_VALUE_FAIL);
        					return PayConstants.RETURN_ALIPAY_VALUE_FAIL;
        				}
        				_log.info("{}更新支付状态成功,将payOrderId={},更新payStatus={}成功", logPrefix, payOrder.getPayOrderId(), PayConstants.PAY_STATUS_SUCCESS);
        				payOrder.setStatus(PayConstants.PAY_STATUS_SUCCESS);
        			}
        			doNotify(payOrder);
                    retMsgJson = "{\"RetCode\":\"0000\",\"RetMsg\":\"订单已支付\"}";
                    _log.info("订单已支付!");
                } else {
                    // 1、订单支付失败的业务逻辑处理请在本处增加（订单通知可能存在多次通知的情况，需要做多次通知的兼容处理，避免成功后又修改为失败）；
                    // 2、返回响应内容
                    retMsgJson = "{\"RetCode\":\"E102\",\"RetMsg\":\"订单支付失败+"+status+"\"}";
                    _log.info("订单支付失败!status="+status);
                }
            }
        } catch (Exception e) {
            retMsgJson = "{\"RetCode\":\"E103\",\"RetMsg\":\"处理通知结果异常\"}";
            _log.info("处理通知(H5)结果异常!e="+e.getMessage());
        }
        _log.info("--同步通知(H5)完成----");
       
        //返回数据
        PrintWriter out = response.getWriter();
        out.println(retMsgJson);
        out.close(); // for HTTP1.1
		return null;
	}

	/**
	 * 验证支付宝支付通知参数
	 * 
	 * @return
	 */
	public boolean verifyEcoPayParams(Map<String, Object> payContext) {
		Map<String, String> params = (Map<String, String>) payContext.get("parameters");
		String merchOrderId = params.get("MerchOrderId"); // 商户订单号
		String amount = params.get("Amount"); // 支付金额
		if (StringUtils.isEmpty(merchOrderId)) {
			_log.error("AliPay Notify parameter out_trade_no is empty. MerchOrderId={}", merchOrderId);
			payContext.put("retMsg", "out_trade_no is empty");
			return false;
		}
		if (StringUtils.isEmpty(amount)) {
			_log.error("AliPay Notify parameter total_amount is empty. amount={}", amount);
			payContext.put("retMsg", "total_amount is empty");
			return false;
		}
		String errorMessage;
		// 查询payOrder记录
		String payOrderId = merchOrderId;
		PayOrder payOrder = payOrderService.selectPayOrder(payOrderId);
		if (payOrder == null) {
			_log.error("Can't found payOrder form db. payOrderId={}, ", payOrderId);
			payContext.put("retMsg", "Can't found payOrder");
			return false;
		}
		// 查询payChannel记录
		String mchId = payOrder.getMchId();
		String channelId = payOrder.getChannelId();
		PayChannel payChannel = payChannelService.selectPayChannel(channelId, mchId);
		if (payChannel == null) {
			_log.error("Can't found payChannel form db. mchId={} channelId={}, ", payOrderId, mchId, channelId);
			payContext.put("retMsg", "Can't found payChannel");
			return false;
		}

		// 核对金额
		long ceoPayAmt = new BigDecimal(amount).movePointRight(2).longValue();
		long dbPayAmt = payOrder.getAmount().longValue();
		if (dbPayAmt != ceoPayAmt) {
			_log.error("db payOrder record payPrice not equals amount. amount={},payOrderId={}", amount, payOrderId);
			payContext.put("retMsg", "");
			return false;
		}
		payContext.put("payOrder", payOrder);
		return true;
	}

}
