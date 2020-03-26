package com.example.demo.controller;

import com.example.demo.dto.SeatDto;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.command.GetUserSeatCommand;
import com.example.demo.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/seats")
public class SeatController {

    private final SeatService seatService;

    @PostMapping("/reserve")
    public List<SeatDto> reserveSeat(@RequestBody GetUserSeatCommand command) {
        return seatService.reserve(command);
    }

    @PostMapping("/pay")
    public Double payTicket(@RequestBody UserDto userDto) {
        return seatService.pay(userDto);
    }

    @GetMapping("/findSeats/{repertoireId}")
    public List<SeatDto> findAvailableSeats(@PathVariable Long repertoireId) {
        return seatService.findAvailableSeats(repertoireId);
    }

    @GetMapping("/findReservedSeats/{repertoireId}")
    public List<SeatDto> findReservedSeats(@PathVariable Long repertoireId) {
        return seatService.findReservedSeats(repertoireId);
    }
}
