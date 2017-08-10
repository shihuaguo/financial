package com.cunjin.gate;


import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ApplicationContext;

import com.cunjin.gate.utils.DBLog;

/**
 * Created by Ace on 2017/6/2.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableZuulProxy
//@EnableRedisHttpSession(redisFlushMode = RedisFlushMode.IMMEDIATE)
public class GateBootstrap {
	private static Logger logger = LoggerFactory.getLogger(GateBootstrap.class);
	
    public static void main(String[] args) {
        DBLog.getInstance().start();
//        SpringApplication.run(GateBootstrap.class, args);
        SpringApplication app = new SpringApplicationBuilder().application();
		Set<Object> set = new HashSet<Object>();
		set.add(GateBootstrap.class);
		app.setSources(set);
		app.addListeners(new ApplicationEventListener());
		ApplicationContext ctx = app.run(args);
//		ApplicationContext ctx = SpringApplication.run(Bootstrap.class, args);
		logger.info("GateBootstrap项目启动成功");
		
		String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();
		if(activeProfiles == null || activeProfiles.length == 0){
			activeProfiles = ctx.getEnvironment().getDefaultProfiles();
		}
		for(String profile : activeProfiles){
			logger.info("Spring Boot 使用Profile: {}", profile);
		}
    }
}
