package com.example.deokjideokji.member.dto.request;

import com.example.deokjideokji.member.domain.Member;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class CreateMemberRequest {
    @NotNull
    private String email;

    @NotNull
    private String name;

    @NotNull
    private Long birthday;

    public Member toEntity(){
        return Member.builder()
                .email(email)
                .name(name)
                .birthday(birthday)
                .build();
    }
}