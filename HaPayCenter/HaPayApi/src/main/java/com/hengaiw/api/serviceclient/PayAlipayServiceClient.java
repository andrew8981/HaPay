package com.hengaiw.api.serviceclient;

import com.hengaiw.pub.utils.HaBase64;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class PayAlipayServiceClient {

    @Autowired
    RestTemplate restTemplate;
    /**
     * 处理支付宝的wap支付
     * @param jsonParam
     * @return
     */
    @HystrixCommand(fallbackMethod = "doAlipayWapReqFallback")
    public String doAlipayWapReq(String jsonParam) {
        return restTemplate.getForEntity("http://HAPAYALIPAYSERVICE/pay/alipay/wap?jsonParam=" + HaBase64.encode(jsonParam.getBytes()), String.class).getBody();
    }

    public String doAlipayWapReqFallback(String jsonParam) {
        return "error";
    }
    /**
     * 处理支付宝的mobile支付
     * @param jsonParam
     * @return
     */
    @HystrixCommand(fallbackMethod = "doAlipayMobileReqFallback")
    public String doAlipayMobileReq(String jsonParam) {
        return restTemplate.getForEntity("http://HAPAYALIPAYSERVICE/pay/alipay/mobile?jsonParam=" + HaBase64.encode(jsonParam.getBytes()), String.class).getBody();
    }

    public String doAlipayMobileReqFallback(String jsonParam) {
        return "error";
    }
    /**
     * 处理支付宝的pc支付
     * @param jsonParam
     * @return
     */
    @HystrixCommand(fallbackMethod = "doAlipayPcReqFallback")
    public String doAlipayPcReq(String jsonParam) {
        return restTemplate.getForEntity("http://HAPAYALIPAYSERVICE/pay/alipay/pc?jsonParam=" + HaBase64.encode(jsonParam.getBytes()), String.class).getBody();
    }

    public String doAlipayPcReqFallback(String jsonParam) {
        return "error";
    }
    
    /**
     * 处理支付宝的qr支付
     * @param jsonParam
     * @return
     */
    @HystrixCommand(fallbackMethod = "doAlipayQrReqFallback")
    public String doAlipayQrReq(String jsonParam) {
        return restTemplate.getForEntity("http://HAPAYALIPAYSERVICE/pay/alipay/qr?jsonParam=" + HaBase64.encode(jsonParam.getBytes()), String.class).getBody();
    }

    public String doAlipayQrReqFallback(String jsonParam) {
        return "error";
    }
}