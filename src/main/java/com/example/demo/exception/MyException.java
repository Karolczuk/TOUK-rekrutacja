package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyException extends RuntimeException {
    private ExceptionInfo exceptionInfo;

    public MyException(String exceptionMessage) {
        super(exceptionMessage);
        this.exceptionInfo = ExceptionInfo.builder()
                .message(exceptionMessage)
                .dateTime(LocalDateTime.now())
                .build();
    }

    public ExceptionInfo getExceptionInfo() {
        return exceptionInfo;
    }
}
