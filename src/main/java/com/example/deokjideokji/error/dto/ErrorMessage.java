package com.example.deokjideokji.error.dto;

import org.springframework.http.HttpStatus;

public enum ErrorMessage {

    /**
     * 서버 내부 오류
     */
    INTERNAL_SERVER_ERROR(HttpStatus.BAD_REQUEST, "내부 서버 오류"),
    INVALID_REQUEST_PARAMETER(HttpStatus.BAD_REQUEST, "잘못된 요청 입니다."),

    /**
     * 유저 정보 오류
     */
    NOT_EXIST_MEMBER_EXCEPTION(HttpStatus.NOT_FOUND, "해당 유저가 존재하지 않습니다"),
    NOT_LOGIN_USER_EXCEPTION(HttpStatus.BAD_REQUEST, "로그인 정보가 없습니다"),
    NOT_EXIST_JWT_TOKEN(HttpStatus.BAD_REQUEST, "요청에 토큰 정보가 없습니다"),
    ;

    private final HttpStatus status;
    private final String message;

    ErrorMessage(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
