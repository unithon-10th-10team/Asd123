package com.example.deokjideokji.storage.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StorageResponse {
    private Long id;
    private String userId;
    private Long restaurantId;
    private Integer temp;

    @Builder
    public StorageResponse(Long id, String userId,
                           Long restaurantId, Integer temp) {
        this.id = id;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.temp = temp;
    }
}
