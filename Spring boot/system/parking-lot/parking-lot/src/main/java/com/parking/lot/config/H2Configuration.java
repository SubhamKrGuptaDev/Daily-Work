package com.parking.lot.config;

import jakarta.servlet.ServletRegistration;
import org.apache.catalina.servlets.WebdavServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2Configuration {

//    @Bean
//    public ServletRegistration servletRegistration() {
//        ServletRegistrationBean registration = new ServletRegistrationBean(new WebdavServlet());
//        registration.addUrlMappings("/console/*");
//        return registration;
//    }

}
