package com.example.deokjideokji.auth.domain;

import com.example.deokjideokji.auth.domain.vo.RoleType;
import com.example.deokjideokji.member.domain.Member;
import lombok.Getter;

@Getter
public class UserDetail {
    private Long id;
    private String userEmail;
    private String name;

    private RoleType role;

    public UserDetail(Member member) {
        this.id = member.getId();
        this.userEmail = member.getEmail();
        this.name = member.getName();
        this.role = RoleType.USER;
    }

    public UserDetail() {
        this.role = RoleType.GUEST;
    }
}
