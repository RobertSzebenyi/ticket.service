package com.robert.szebenyi.ticket.service.apimodule.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {

    private T data;

    private boolean success = true;

    public Response(T data) {
        this.data = data;
    }

}