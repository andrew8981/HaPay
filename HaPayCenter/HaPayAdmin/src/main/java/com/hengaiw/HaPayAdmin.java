package com.hengaiw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;

//@EnableDiscoveryClient
@SpringBootApplication
@PropertySource({ 
		"file:./config/admin_db.properties", // 数据库配置
		"file:./config/freemarker.properties",// 数据库配置
		"file:./config/mchInfo.properties"// 数据库配置
})
public class HaPayAdmin extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(HaPayAdmin.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		application.listeners();
		return application.sources(applicationClass);
	}

	private static Class<HaPayAdmin> applicationClass = HaPayAdmin.class;
}
