package com.example.demo.service;

import com.example.demo.dto.RepertoireDto;
import com.example.demo.dto.command.GetAllRepertoireCommand;
import com.example.demo.dto.command.GetDayAndTimeCommand;
import com.example.demo.model.Repertoire;
import com.example.demo.repository.RepertoireRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RepertoireService {

    private final RepertoireRepository repertoireRepository;

    private static String apply(Repertoire r) {
        return r.getMovie().getTitle();
    }

    public List<RepertoireDto> findAllRepertoire(GetAllRepertoireCommand command) {
        return repertoireRepository.findRepertoireByDateIsBetween(LocalDate.parse(command.getDateFrom()), LocalDate.parse(command.getDateTo()))
                .stream()
                .sorted(Comparator.comparing(RepertoireService::apply))
                .sorted(Comparator.comparing(Repertoire::getTime))
                .map(Mapper::fromRepertoireToRepertoireDto)
                .collect(Collectors.toList());
    }

    public List<RepertoireDto> findRepertoireByDateAndTime(GetDayAndTimeCommand command) {
        return repertoireRepository.findByDateAndTime(command.getDate(),command.getTime())
                .stream()
                .map(Mapper::fromRepertoireToRepertoireDto)
                .collect(Collectors.toList());
    }

}
