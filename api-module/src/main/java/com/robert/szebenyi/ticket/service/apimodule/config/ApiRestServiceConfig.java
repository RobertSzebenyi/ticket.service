package com.robert.szebenyi.ticket.service.apimodule.config;


import org.glassfish.jersey.jackson.internal.jackson.jaxrs.base.JsonMappingExceptionMapper;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.base.JsonParseExceptionMapper;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
@Primary
public class ApiRestServiceConfig extends ResourceConfig {

    @Autowired
    public ApiRestServiceConfig(List<ApiRestService> restServices,
                                Environment environment) {

        restServices.forEach(this::register);

        LoggingFeature component = new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME),
                Level.INFO, LoggingFeature.Verbosity.PAYLOAD_TEXT, 10000);
        register(component);
        register(JsonParseExceptionMapper.class);
        register(JsonMappingExceptionMapper.class);
        register(JacksonWithJoda.class, MessageBodyReader.class, MessageBodyWriter.class);
        register(MultiPartFeature.class);


    }

}
