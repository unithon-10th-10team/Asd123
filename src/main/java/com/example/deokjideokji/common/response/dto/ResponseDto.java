package com.example.deokjideokji.common.response.dto;

import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class ResponseDto<T> {

    private final String message;
    private final String serverDateTime;
    private final T data;

    public ResponseDto(ResponseMessage message, T data) {
        this.message = message.name();
        this.serverDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        this.data = data;
    }

    public static  <T> ResponseEntity<ResponseDto<T>> toResponseEntity(ResponseMessage message, T data) {
        return ResponseEntity
            .status(message.getStatus())
            .body(new ResponseDto<>(message, data));
    }
}
