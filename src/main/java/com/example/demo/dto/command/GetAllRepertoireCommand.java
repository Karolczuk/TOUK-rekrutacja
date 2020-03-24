package com.example.demo.dto.command;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllRepertoireCommand {

    private String dateFrom;
    private String dateTo;
}
