package com.example.deokjideokji.bookingstorage.application;

import com.example.deokjideokji.auth.domain.UserDetail;
import com.example.deokjideokji.bookingstorage.domain.BookingStorage;
import com.example.deokjideokji.bookingstorage.dto.request.BookingStorageRequest;
import com.example.deokjideokji.bookingstorage.dto.response.BookingStorageResponse;
import com.example.deokjideokji.bookingstorage.infrastructure.BookingStorageRepository;
import com.example.deokjideokji.member.application.MemberService;
import com.example.deokjideokji.storage.dto.request.StorageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingStorageService {
    private final BookingStorageRepository bookingStorageRepository;
    private final MemberService memberService;

    @Transactional(readOnly = true)
    public List<BookingStorageResponse> getAllBookingStorage(UserDetail detail) {
        memberService.validateUserDetail(detail);

        return bookingStorageRepository.findAllByUserId(detail.getId()).stream()
                .map(BookingStorage::toResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public BookingStorageResponse createBookingStorage(UserDetail detail, BookingStorageRequest bookingStorageRequest) {
        memberService.validateUserDetail(detail);

        var bookingStorageResponse = bookingStorageRepository.save(bookingStorageRequest.toEntity());
        return bookingStorageResponse.toResponseDto();
    }

    @Transactional
    public void deleteBookingStorage(StorageRequest request) {
        var bookingStorage = bookingStorageRepository.findByRestaurantId(request.getRestaurantId());
        bookingStorage.ifPresent(bookingStorageRepository::delete);
    }
}
