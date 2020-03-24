package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String title;
    private Integer duration;

    @Lob
    private String description;

    @OneToMany(mappedBy = "movie")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Repertoire> repertoires;

    @OneToMany(mappedBy = "movie")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Seat> seats;
}
