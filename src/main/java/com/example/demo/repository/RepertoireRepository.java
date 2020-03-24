package com.example.demo.repository;

import com.example.demo.model.Repertoire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface RepertoireRepository extends JpaRepository<Repertoire, Long> {

    List<Repertoire> findRepertoireByDateIsBetween(LocalDate dateFrom, LocalDate dateTo);

    Optional<Repertoire> findRepertoireByIdAndDateAndTime(Long id, LocalDate date, LocalTime time);

    List<Repertoire> findByDateAndTime(LocalDate date, LocalTime time);
}