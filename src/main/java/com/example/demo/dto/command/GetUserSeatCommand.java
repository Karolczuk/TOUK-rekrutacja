package com.example.demo.dto.command;

import com.example.demo.dto.SeatDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetUserSeatCommand {

    private String username;
    private String name;
    private String surname;
    private List<SeatDto> seatDto;
}
