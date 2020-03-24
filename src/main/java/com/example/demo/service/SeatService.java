package com.example.demo.service;

import com.example.demo.dto.SeatDto;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.command.GetUserSeatCommand;
import com.example.demo.exception.MyException;
import com.example.demo.model.Repertoire;
import com.example.demo.model.Seat;
import com.example.demo.model.User;
import com.example.demo.repository.RepertoireRepository;
import com.example.demo.repository.SeatRepository;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SeatService {

    private final SeatRepository seatRepository;
    private final RepertoireRepository repertoireRepository;
    private final UserRepository userRepository;

    public List<SeatDto> reserve(GetUserSeatCommand command) {

        if (command == null) {
            throw new MyException("add seat exception - seat object is null");
        }
        return command.getSeatDto().stream().map(seats -> {
            Repertoire repertoire = validateReservation(seats);
            checkSeat(seats.getColumnNumber(), seats.getRowNumber(), repertoire.getRoom().getColumnCount(), repertoire.getRoom().getRowCount());

            Seat seat = Seat.builder().columnCount(seats.getColumnNumber())
                    .rowCount(seats.getRowNumber())
                    .build();
            User user = userRepository.findByNameAndSurname(command.getName(), command.getSurname())
                    .orElseThrow(() -> new EntityNotFoundException());
            seat.setTicketTypes(seats.getTicketTypes());
            seat.setUser(user);
            seat.setIsPayed(false);
            seat.setRepertoire(repertoire);
            seat.setMovie(repertoire.getMovie());
            seat.setRoom(repertoire.getRoom());
            Seat saveSeat = seatRepository.save(seat);
            return Mapper.fromSeatToSeatDto(saveSeat);
        })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private void checkSeat(Integer columnNumber, Integer rowNumber, Integer maxColumn, Integer maxRow) {
        if (columnNumber > maxColumn || rowNumber > maxRow) {
            throw new MyException("Column or row doesn't exist in room ");
        }
        boolean present = seatRepository.findAll().stream().map(Mapper::fromSeatToSeatDto)
                .filter(s -> s.getColumnNumber() == columnNumber + 2)
                .findAny()
                .isPresent();
        if (present) {
            throw new MyException("You don't reserve seat. There cannot be a single place left over in a row between two already reserved places.");
        }
    }

    private Repertoire validateReservation(SeatDto seats) {
        Optional<Repertoire> byId = repertoireRepository.findById(seats.getRepertoireDto().getId());
        if (!byId.isPresent()) {
            return null;
        }
        Repertoire repertoire = byId.get();

        if (LocalDate.now().isAfter(repertoire.getDate()) || (!repertoire.getTime().isAfter(LocalTime.now().minusMinutes(15)))) {
            throw new MyException("You don't reserve seat. You must booked seat at latest 15 minutes before the screening begins ");
        }
        Optional<Seat> optionalSeat = seatRepository.findByRepertoireDateAndRepertoireTimeAndColumnCountAndRowCountAndRepertoireMovieId(
                repertoire.getDate(), repertoire.getTime(), seats.getColumnNumber(), seats.getRowNumber(), repertoire.getMovie().getId());
        if (optionalSeat.isPresent()) {
            throw new MyException("Someone reserved this seat");
        }
        return repertoire;
    }

    public Double pay(UserDto userDto) {

        User user = Mapper.fromUserDtoToUser(userDto);

        List<Seat> seats = seatRepository.findByUserIdAndIsPayed(user.getId(), false);
        seats.stream().peek(t -> t.setIsPayed(true)).forEach(t -> seatRepository.save(t));

        List<SeatDto> seatDtos = validReservationTime(seats);
        if (!seatDtos.isEmpty()) {
            return seatDtos.stream()
                    .mapToDouble(t -> t.getTicketTypes().getPrice().doubleValue())
                    .sum();
        }
        return 0.0;
    }

    public List<SeatDto> validReservationTime(List<Seat> seats) {
        return seats.stream().map(s -> {
                    if (LocalDate.now().isAfter(s.getRepertoire().getDate()) || (!s.getRepertoire().getTime().isAfter(LocalTime.now().minusMinutes(15))))
                        return null;
                    return Mapper.fromSeatToSeatDto(s);
                }
        ).filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

}