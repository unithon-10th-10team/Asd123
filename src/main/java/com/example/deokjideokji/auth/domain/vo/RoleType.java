package com.example.deokjideokji.auth.domain.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoleType {
    GUEST("GUEST", "게스트"),
    USER("ROLE_USER", "유저");

    private final String role;
    private final String value;

}
