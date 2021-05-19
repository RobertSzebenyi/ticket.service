package com.robert.szebenyi.ticket.service.ticketmodule.service;

import com.robert.szebenyi.ticket.service.ticketmodule.dto.EventRestResponseDto;
import com.robert.szebenyi.ticket.service.ticketmodule.dto.ReserveRestRequestDto;
import com.robert.szebenyi.ticket.service.ticketmodule.dto.ReserveRestResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PartnerWebService {

    private RestTemplate restTemplate = restTemplate();


    public List<EventRestResponseDto> getEvents() {
        ResponseEntity<List<EventRestResponseDto>> response = restTemplate.exchange("http://localhost:8085/partner/getEvents", GET, new HttpEntity<>(createValidAuthHeader()), new ParameterizedTypeReference<>() {
        });

//        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8085/partner/getEvents", GET, new HttpEntity<>(createValidAuthHeader()), new ParameterizedTypeReference<>() {
//        });
        System.out.println(response.toString()); // TODO

//        return null;
        return response.getBody();
    }

    public EventRestResponseDto getEvent(int eventId) {
        ResponseEntity<EventRestResponseDto> response = restTemplate.exchange("http://localhost:8085/partner/getEvent?id=" + eventId, GET, new HttpEntity<>(createValidAuthHeader()), new ParameterizedTypeReference<>() {
        });
        System.out.println(response.toString());

        return response.getBody();
    }

    public boolean reserve(long eventId, long seatId) {

        HttpEntity requestEntity = new HttpEntity<>(ReserveRestRequestDto.builder()
                .eventId(eventId)
                .seatId(seatId)
                .build());

        ResponseEntity<ReserveRestResponseDto> response = restTemplate.exchange("http://localhost:8085/partner/reserve" + eventId, POST, setValidAuthHeader(requestEntity), new ParameterizedTypeReference<>() {
        });
        System.out.println(response.toString());
        return true;
    }

    private HttpHeaders createValidAuthHeader() {
        return createAuthHeader("partner", "partner");
    }

    private HttpEntity setValidAuthHeader(HttpEntity requestEntity) {
        return new HttpEntity<>(requestEntity.getBody(), createValidAuthHeader());
    }

    private HttpHeaders createAuthHeader(String username, String password) {
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")));
            String authHeader = "Basic " + new String(encodedAuth);
            set("Authorization", authHeader);
        }};
    }

    @Bean
    public RestTemplate restTemplate() {
        final RestTemplate restTemplate = new RestTemplate();

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);

        return restTemplate;
    }
}
