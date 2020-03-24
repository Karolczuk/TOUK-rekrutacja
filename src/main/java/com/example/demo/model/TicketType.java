package com.example.demo.model;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
public enum TicketType {

    ADULT(BigDecimal.valueOf(25)), STUDENT(BigDecimal.valueOf(18)), CHILD(BigDecimal.valueOf(12));

    private BigDecimal price;

    TicketType(BigDecimal price) {
        this.price = price;
    }
}
