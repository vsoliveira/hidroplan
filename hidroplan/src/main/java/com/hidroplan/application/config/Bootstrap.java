package com.hidroplan.application.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

import com.hidroplan.application.config.AppConfig;
import com.hidroplan.utils.Constants;

public class Bootstrap implements WebApplicationInitializer{
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(AppConfig.class);
		servletContext.addListener(new ContextLoaderListener(rootContext));
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/*");

		MessageDispatcherServlet mds = new MessageDispatcherServlet();
		mds.setTransformWsdlLocations(true);
		mds.setApplicationContext(rootContext);
		mds.setTransformWsdlLocations(true);

		ServletRegistration.Dynamic mdsServlet = servletContext.addServlet("mdsServlet", mds);
		mdsServlet.addMapping(Constants.SERVICES.concat("/*"));
		mdsServlet.setLoadOnStartup(2);
		mdsServlet.setAsyncSupported(true);
	}
}
