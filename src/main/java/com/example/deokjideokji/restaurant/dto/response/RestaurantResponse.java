package com.example.deokjideokji.restaurant.dto.response;

import com.example.deokjideokji.restaurant.domain.vo.Type;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RestaurantResponse {
    private Long id;

    private Type type;

    private Double latitude;

    private Double longitude;

    private String name;

    private String location;

    private Long artistId;

    @Builder
    public RestaurantResponse(Long id, Type type, Double latitude, Double longitude,
                                            String name, String location, Long artistId) {
        this.id = id;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.location = location;
        this.artistId = artistId;
    }
}
