package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    @Pattern(regexp = "[A-ZŚĆŃŁŻĄ][a-z-A-ZśćóńłżźąĄ]{2,}", message = "Name should contains at least 3 letters")
    private String name;

    @Pattern(regexp = "[A-ZŚĆŁŃŻĄ][a-z-A-ZśćńółżźąĄ]+(_[A-ZŻĄ][a-z-A-ZśćńółżźąĄ]+){0,1}", message = "Surname should contains at least 3 letters")
    private String surname;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
    private Set<Seat> seats;
}
