package com.example.deokjideokji.bookingstorage.infrastructure;

import com.example.deokjideokji.bookingstorage.domain.BookingStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingStorageRepository extends JpaRepository<BookingStorage, Long> {
    List<BookingStorage> findAllByUserId(String userId);

    Optional<BookingStorage> findByRestaurantId(Long restaurantId);
}
