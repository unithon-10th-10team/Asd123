package com.example.deokjideokji.auth.domain;
import com.example.deokjideokji.auth.domain.vo.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Authentication {
    private UserDetail userDetail;

    private RoleType role;
}
