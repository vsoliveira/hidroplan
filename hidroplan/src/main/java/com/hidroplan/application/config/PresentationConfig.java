package com.hidroplan.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ImportResource({"classpath:environment.xml"})
public class PresentationConfig extends WebMvcConfigurerAdapter{
	 @Override
	   public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/img/**").addResourceLocations("/img/");
			registry.addResourceHandler("/css/**").addResourceLocations("/css/");
			registry.addResourceHandler("/../../js/**").addResourceLocations("/../../js/");
			registry.addResourceHandler("/fonts/**").addResourceLocations("/fonts/");
	   }

	   @Bean
	   public ResourceBundleMessageSource messageSource() {
	      ResourceBundleMessageSource source = new ResourceBundleMessageSource();
	      source.setBasename("/i18n/messages");
	      return source;
	   }

	   @Override
	   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	      configurer.enable();
	   }
}
