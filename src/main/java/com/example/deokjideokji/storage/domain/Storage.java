package com.example.deokjideokji.storage.domain;

import com.example.deokjideokji.storage.dto.response.StorageResponse;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @Column
    private Long restaurantId;

    @Column
    private Integer temp;

    @Builder
    public Storage(Long id, Long userId,
                   Long restaurantId, Integer temp) {
        this.id = id;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.temp = temp;
    }

    public StorageResponse toResponseDto() {
        return StorageResponse.builder()
                .id(id)
                .userId(userId)
                .restaurantId(restaurantId)
                .temp(temp)
                .build();
    }
}
