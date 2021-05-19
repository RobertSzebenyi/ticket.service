package com.robert.szebenyi.ticket.service.apimodule.web;


import com.robert.szebenyi.ticket.service.apimodule.config.ApiRestService;
import com.robert.szebenyi.ticket.service.apimodule.web.dto.Response;
import com.robert.szebenyi.ticket.service.ticketmodule.dto.EventRestResponseDto;
import com.robert.szebenyi.ticket.service.ticketmodule.service.PartnerWebService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@RequiredArgsConstructor
@Path("/")
public class ApiWebRestService implements ApiRestService {

    private final PartnerWebService partnerWebService;

    @GET
    @Path("/getEvents")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response<List<EventRestResponseDto>> getEvents() {

        return new Response<>(partnerWebService.getEvents());
    }

}