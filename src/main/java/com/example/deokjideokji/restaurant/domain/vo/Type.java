package com.example.deokjideokji.restaurant.domain.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Type {
    BIRTHDAY_EVENT("BIRTHDAY_EVENT", "생일이벤트"),
    RESTAURANT("RESTAURANT", "식당"),
    CAFE("CAFE", "카페");

    private final String key;
    private final String value;
}
