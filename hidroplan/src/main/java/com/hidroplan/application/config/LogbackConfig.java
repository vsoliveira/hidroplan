package com.hidroplan.application.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

import com.hidroplan.application.config.LogbackConfig;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

public class LogbackConfig implements ApplicationContextAware, InitializingBean{
	  private static final Logger LOGGER = LoggerFactory.getLogger(LogbackConfig.class);
	   private Resource location;
	   private ApplicationContext applicationContext;

	   public void setLocation(Resource location) {
	      this.location = location;
	   }

	   @Override
	   public void afterPropertiesSet() throws Exception {
	      configureLogback();
	      String [] activeProfiles = applicationContext.getEnvironment().getActiveProfiles();
	      String profile = "default";
	      if(activeProfiles.length > 0) {
	         profile = activeProfiles[0];
	      }
	      LOGGER.info("logback set up to {}", profile);
	   }

	   public void configureLogback() throws JoranException, IOException {
	      JoranConfigurator configurator = new JoranConfigurator();
	      LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
	      loggerContext.reset();
	      configurator.setContext(loggerContext);
	      configurator.doConfigure(location.getInputStream());
	   }

	   @Override
	   public void setApplicationContext(ApplicationContext applicationContext) {
	      this.applicationContext = applicationContext;
	   }
}
