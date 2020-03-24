package com.example.demo.controller;

import com.example.demo.dto.RepertoireDto;
import com.example.demo.dto.command.GetAllRepertoireCommand;
import com.example.demo.dto.command.GetDayAndTimeCommand;
import com.example.demo.service.RepertoireService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/repertoire")
public class RepertoireController {

    private final RepertoireService repertoireService;

    @PostMapping("/findAll")
    public List<RepertoireDto> findAllRepertoire(@RequestBody GetAllRepertoireCommand command) {
        return repertoireService.findAllRepertoire(command);
    }

    @PostMapping()
    public List<RepertoireDto> findAllRepertoireByDayAndTime(@RequestBody GetDayAndTimeCommand command) {
        return repertoireService.findRepertoireByDateAndTime(command);
    }
}
