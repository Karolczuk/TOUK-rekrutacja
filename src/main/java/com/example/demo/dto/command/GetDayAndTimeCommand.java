package com.example.demo.dto.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetDayAndTimeCommand {

    private LocalDate date;
    private LocalTime time;
}
