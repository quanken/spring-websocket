package com.quanken

import com.quanken.config.MVCConfig
import org.springframework.web.WebApplicationInitializer
import org.springframework.web.context.ContextLoaderListener
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.filter.CharacterEncodingFilter
import org.springframework.web.servlet.DispatcherServlet

import javax.servlet.FilterRegistration
import javax.servlet.ServletContext
import javax.servlet.ServletException
import javax.servlet.ServletRegistration

/**
 * Author : @com.quanken
 * Date: 2014-09-29
 */

public class CustomizeWebInitializer implements WebApplicationInitializer{
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(MVCConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));
        // Spring Dispatcher
        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        // Encoding Filter Settings
        FilterRegistration.Dynamic filter =
                servletContext.addFilter("EncodingFilter", new CharacterEncodingFilter());
        filter.setInitParameter("encoding", "utf-8");
        filter.setInitParameter("forceEncoding", "true");
        filter.addMappingForUrlPatterns(null, true, "/*");
    }
}
