package com.example.deokjideokji.member.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberResponse {
    private Long id;
    private String email;
    private String name;
    private String birthday;

    @Builder
    public MemberResponse(Long id, String email,
                           String name, String birthday){
        this.id = id;
        this.email = email;
        this.name = name;
        this.birthday = birthday;
    }
}
