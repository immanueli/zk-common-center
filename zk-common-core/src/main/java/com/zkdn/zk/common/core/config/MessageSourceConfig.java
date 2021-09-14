package com.zkdn.zk.common.core.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * @Description: 国际化配置
 * @Author:Brain M
 * @Date:2019/3/28
 **/
@Configuration
@Slf4j
public class MessageSourceConfig {

	@Bean
	public MessageSource messageSource() {
		log.info("--------> init message source");
		ReloadableResourceBundleMessageSource messageSource
			= new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:i18n/messages");
		return messageSource;
	}
}
