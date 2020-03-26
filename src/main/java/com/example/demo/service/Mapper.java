package com.example.demo.service;

import com.example.demo.dto.MovieDto;
import com.example.demo.dto.RepertoireDto;
import com.example.demo.dto.SeatDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.Movie;
import com.example.demo.model.Repertoire;
import com.example.demo.model.Seat;
import com.example.demo.model.User;

import java.time.format.DateTimeFormatter;

public interface Mapper {

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");

    static MovieDto fromMovieToMovieDto(Movie movie) {
        return movie == null ? null : MovieDto.builder()
                .id(movie.getId())
                .description(movie.getDescription())
                .title(movie.getTitle())
                .duration(movie.getDuration())
                .build();
    }

    static Movie fromMovieDtoToMovie(MovieDto movieDto) {
        return movieDto == null ? null : Movie.builder()
                .id(movieDto.getId())
                .description(movieDto.getDescription())
                .title(movieDto.getTitle())
                .build();
    }


    static UserDto fromUserToUserDto(User user) {
        return user == null ? null : UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .username(user.getUsername())
                .build();
    }

    static User fromUserDtoToUser(UserDto userDto) {
        return userDto == null ? null : User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .username(userDto.getUsername())
                .build();
    }

    static SeatDto fromSeatToSeatDto(Seat seat) {
        return seat == null ? null : SeatDto.builder()
                .id(seat.getId())
                .columnCount(seat.getColumnCount())
                .rowCount(seat.getRowCount())
                .ticketTypes(seat.getTicketTypes())
                .repertoireDto(seat.getRepertoire() == null ? null : fromRepertoireToRepertoireDto(seat.getRepertoire()))
                .build();
    }


    static Seat fromSeatDtoToSeat(SeatDto seatDto) {
        return seatDto == null ? null : Seat.builder()
                .id(seatDto.getId())
                .columnCount(seatDto.getColumnCount())
                .rowCount(seatDto.getRowCount())
                .build();
    }


    static RepertoireDto fromRepertoireToRepertoireDto(Repertoire repertoire) {
        return repertoire == null ? null : RepertoireDto.builder()
                .id(repertoire.getId())
                .time(repertoire.getTime())
                .date(repertoire.getDate())
                .movieId(repertoire.getMovie().getId())
                .roomId(repertoire.getRoom().getId())
                .build();
    }

    static Repertoire fromRepertoireDtoToRepertoire(RepertoireDto repertoireDto) {
        return repertoireDto == null ? null : Repertoire.builder()
                .id(repertoireDto.getId())
                .time(repertoireDto.getTime())
                .date(repertoireDto.getDate() != null ? repertoireDto.getDate() : null)
                .build();
    }
}