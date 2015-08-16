package com.mycompany.sp4.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;
import java.util.Set;

/**
 * Implementations of this SPI will be detected automatically by {@link
 * org.springframework.web.SpringServletContainerInitializer}
 */
public class WebAppInitializer implements WebApplicationInitializer {
	private static final Logger LOG = LoggerFactory.getLogger(WebAppInitializer.class);


	@Override
	public void onStartup(final ServletContext servletContext) throws ServletException {

		LOG.debug("start");
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(RootConfig.class);
		LOG.debug("root registered");

		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(WebMvcJspConfig.class);
		LOG.debug("web registered");
		FilterRegistration.Dynamic securityFilter = servletContext.addFilter("securityFilter", new DelegatingFilterProxy("springSecurityFilterChain"));
		securityFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

		servletContext.setInitParameter("defaultHtmlEscape", "true");
		servletContext.addListener(new ContextLoaderListener(context));
		LOG.debug("context listener added");


		DispatcherServlet servlet = new DispatcherServlet(webContext);
		LOG.debug("dispatcher servlet created");

		// no explicit configuration reference here: everything is configured in the root container for simplicity
		//servlet.setContextConfigLocation("");

		ServletRegistration.Dynamic appServlet = servletContext.addServlet("appServlet", servlet);
		appServlet.setLoadOnStartup(1);
		appServlet.setAsyncSupported(true);


		Set<String> mappingConflicts = appServlet.addMapping("/");
		if (!mappingConflicts.isEmpty()) {
			throw new IllegalStateException("'appServlet' cannot be mapped to '/' under Tomcat versions <= 7.0.14");
		}
		LOG.debug("dispatcher servlet added");

		FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("characterEncodingFilter", new CharacterEncodingFilter());
		characterEncodingFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
		characterEncodingFilter.setInitParameter("encoding", "UTF-8");
		characterEncodingFilter.setInitParameter("forceEncoding", "true");

		FilterRegistration.Dynamic wro4jFilter = servletContext.addFilter("wro", new DelegatingFilterProxy("configurableWroFilter"));
		wro4jFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/bundle/*");
		wro4jFilter.setInitParameter("targetFilterLifecycle", "true");
		LOG.debug("filters added");

	}
}