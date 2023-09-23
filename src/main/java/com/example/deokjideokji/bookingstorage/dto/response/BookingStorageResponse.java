package com.example.deokjideokji.bookingstorage.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookingStorageResponse {
    private Long id;
    private String userId;
    private Long restaurantId;

    @Builder
    public BookingStorageResponse(Long id, String userId, Long restaurantId) {
        this.id = id;
        this.userId = userId;
        this.restaurantId = restaurantId;
    }
}
