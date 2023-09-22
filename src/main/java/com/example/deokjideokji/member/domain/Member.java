package com.example.deokjideokji.member.domain;


import com.example.deokjideokji.common.domain.BaseEntity;
import com.example.deokjideokji.member.domain.vo.Email;
import com.example.deokjideokji.member.domain.vo.Name;
import com.example.deokjideokji.member.dto.response.MemberResponse;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Embedded
    private Email email;

    @Column
    @Embedded
    private Name name;

    @Column
    private Long birthday;

    @Builder
    public Member(String email, String name, Long birthday){
        this.email = new Email(email);
        this.name = new Name(name);
        this.birthday = birthday;
    }

    public MemberResponse toResponseDto(){
        return MemberResponse.builder()
                .id(id)
                .email(email.getEmail())
                .name(name.getName())
                .birthday(birthday)
                .build();
    }
}
