package com.hidroplan.application.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.Resource;

import com.hidroplan.application.config.AppConfig;
import com.hidroplan.application.config.LogbackConfig;



@Configuration
@ImportResource({ "classpath:environment.xml" })
@ComponentScan(basePackages = { "com.hidroplan" })
@Import({WebserviceConfig.class, WebAppConfig.class })
public class AppConfig {
	@Value("classpath:logback.xml")
	private Resource logbackConfig;

	private static final Logger LOG = LoggerFactory.getLogger(AppConfig.class);

	public AppConfig() {
		LOG.info("Hello, Mr. AppConfig!");
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("messages");
		return source;
	}

	@Bean
	public LogbackConfig logbackConfigurer() {
		LogbackConfig retval = new LogbackConfig();
		retval.setLocation(logbackConfig);
		return retval;
	}
}
