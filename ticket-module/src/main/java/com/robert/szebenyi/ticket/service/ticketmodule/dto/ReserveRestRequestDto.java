package com.robert.szebenyi.ticket.service.ticketmodule.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReserveRestRequestDto {

    private long eventId;

    private long seatId;

}
