package com.example.demo.dto;

import com.example.demo.model.TicketType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeatDto {

    private Long id;
    private RepertoireDto repertoireDto;
    private TicketType ticketTypes;
    private Integer columnCount;
    private Integer rowCount;

}
