package com.example.deokjideokji.bookingstorage.domain;

import com.example.deokjideokji.bookingstorage.dto.response.BookingStorageResponse;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BookingStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userId;

    @Column
    private Long restaurantId;

    @Builder
    public BookingStorage(Long id, String userId, Long restaurantId) {
        this.id = id;
        this.userId = userId;
        this.restaurantId = restaurantId;
    }

    public BookingStorageResponse toResponseDto() {
        return BookingStorageResponse.builder()
                .id(id)
                .userId(userId)
                .restaurantId(restaurantId)
                .build();
    }

}
