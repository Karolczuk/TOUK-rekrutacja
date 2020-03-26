package com.example.demo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Integer rowMax;
    private Integer columnMax;

    @OneToMany(mappedBy = "room")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Seat> seats;

}
