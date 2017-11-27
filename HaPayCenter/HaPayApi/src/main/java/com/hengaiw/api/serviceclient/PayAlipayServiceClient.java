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
     * 处理微信支付
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
}