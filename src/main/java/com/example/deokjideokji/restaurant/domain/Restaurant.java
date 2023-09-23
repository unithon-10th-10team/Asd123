package com.example.deokjideokji.restaurant.domain;

import com.example.deokjideokji.common.domain.BaseEntity;
import com.example.deokjideokji.member.dto.response.MemberResponse;
import com.example.deokjideokji.restaurant.domain.vo.Type;
import com.example.deokjideokji.restaurant.dto.response.RestaurantResponse;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Restaurant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated
    private Type type;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    @Column
    private String name;

    @Column
    private String location;

    @Column
    private Long artistId;

    @Builder
    public Restaurant(Type type, Double latitude, Double longitude,
                      String name, String location, Long artistId){
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.location = location;
        this.artistId = artistId;
    }

    public RestaurantResponse toResponseDto(){
        return RestaurantResponse.builder()
                .id(id)
                .type(type)
                .latitude(latitude)
                .longitude(longitude)
                .name(name)
                .location(location)
                .artistId(artistId)
                .build();
    }
}
