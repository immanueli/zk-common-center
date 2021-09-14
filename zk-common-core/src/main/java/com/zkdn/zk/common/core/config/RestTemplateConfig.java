package com.zkdn.zk.common.core.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author:Brain M
 * @Date:2019/3/28
 **/
@Configuration
@Slf4j
public class RestTemplateConfig {
	@Bean
	public RestTemplate restTemplate() {
		log.info("--------> init rest template");
		return new RestTemplate();
	}
}
