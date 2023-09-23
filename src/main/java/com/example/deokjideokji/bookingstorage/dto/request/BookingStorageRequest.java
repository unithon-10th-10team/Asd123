package com.example.deokjideokji.bookingstorage.dto.request;

import com.example.deokjideokji.bookingstorage.domain.BookingStorage;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class BookingStorageRequest {
    @NotNull
    private Long id;

    @NotNull
    private String userId;

    @NotNull
    private Long restaurantId;

    public BookingStorage toEntity() {
        return BookingStorage.builder()
                .id(id)
                .userId(userId)
                .restaurantId(restaurantId)
                .build();
    }

}
