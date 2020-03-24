package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Seat {
    @Id
    @GeneratedValue
    private Long id;

    private Integer columnCount;
    private Integer rowCount;

    @ManyToOne()
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Movie movie;

    @ManyToOne()
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User user;

    @ManyToOne()
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Room room;

    @ManyToOne()
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Repertoire repertoire;

    @Enumerated(EnumType.STRING)
    private TicketType ticketTypes;

    private Boolean isPayed; // czy potrzcbne
}