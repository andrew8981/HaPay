package com.hengaiw.pay.scheduling;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.hengaiw.pay.controller.PayWxBackServiceController;
import com.hengaiw.pub.utils.HaLog;

@Configuration
@EnableScheduling // 启用定时任务
public class PayWxScheduling {
	private final HaLog _log = HaLog.getLog(PayWxBackServiceController.class);
	
	
	@Scheduled(cron = "0 0 1 * * ?") // 每20秒执行一次
    public void scheduler() {
		
        _log.info(">>>>>>>>>>>>> scheduled ... ");
    }
}
