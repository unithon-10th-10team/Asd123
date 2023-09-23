package com.example.deokjideokji.common.response.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResponseMessage {

    SUCCESS(HttpStatus.OK,"SUCCESS"),

    // 회원 성공 message

    CREATE_SUCCESS_MEMBER(HttpStatus.CREATED, "멤버 회원 가입 성공"),
    SUCCESS_LOAD_MEMBER_INFORMATION(HttpStatus.OK, "회원 정보 조회 성공"),
    SUCCESS_SEARCH_ALL_MEMBER(HttpStatus.OK, "모든 회원 조회 성공"),

    // 카카오 지도 성공 message

    SUCCESS_GET_MAP_LOCATION(HttpStatus.OK, "지도 위치 정보 가져오기 성공"),


    // 식당 성공 message
    SUCCESS_GET_ALL_RESTAURANT(HttpStatus.OK, "모든 식당 조회 성공"),
    ;


    public final static String SUCCESS_MESSAGE = "SUCCESS";
    private final static String NOT_FOUND_MESSAGE = "NOT FOUND";


    private final HttpStatus status;
    private final String message;

    ResponseMessage(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
