package com.example.demo.repository;

import com.example.demo.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;


public interface SeatRepository extends JpaRepository<Seat, Long> {

    Optional<Seat> findByRepertoireDateAndRepertoireTimeAndColumnCountAndRowCountAndRepertoireMovieId(LocalDate date, LocalTime time, Integer column, Integer raw, Long movieId);

    List<Seat> findByUserIdAndIsPayed(Long userId, Boolean isPayed);

    List<Seat> findByUserId(Long userId);
    List<Seat> findByRepertoireId(Long id);
}
