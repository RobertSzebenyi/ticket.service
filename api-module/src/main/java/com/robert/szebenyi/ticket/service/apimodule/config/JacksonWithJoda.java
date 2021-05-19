package com.robert.szebenyi.ticket.service.apimodule.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.ext.Provider;

@Provider
public class JacksonWithJoda extends JacksonJsonProvider {

    public JacksonWithJoda() {

        ObjectMapper mapper = new ObjectMapper().registerModule(new JodaModule());
        mapper = mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        setMapper(mapper);

    }

}

