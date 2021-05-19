package com.robert.szebenyi.ticket.service.apimodule.config;

import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiJerseyServletConfig {

    @Bean
    public ServletRegistrationBean partnerJersey(ApiRestServiceConfig serviceConfig) {
        ServletRegistrationBean apiJersey
                = new ServletRegistrationBean(new ServletContainer(serviceConfig));
        apiJersey.addUrlMappings("/api/*");
        apiJersey.setName("ApiJersey");
        apiJersey.setLoadOnStartup(0);
        return apiJersey;
    }
}
