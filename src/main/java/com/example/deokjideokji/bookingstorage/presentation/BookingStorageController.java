package com.example.deokjideokji.bookingstorage.presentation;

import com.example.deokjideokji.auth.domain.UserDetail;
import com.example.deokjideokji.auth.infrastructure.annotation.AuthMember;
import com.example.deokjideokji.bookingstorage.application.BookingStorageService;
import com.example.deokjideokji.bookingstorage.dto.request.BookingStorageRequest;
import com.example.deokjideokji.common.response.dto.ResponseDto;
import com.example.deokjideokji.common.response.dto.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user/booking-storage")
public class BookingStorageController {
    private final BookingStorageService bookingStorageService;

    @GetMapping
    public ResponseEntity<?> getAllBookingStorage(@AuthMember UserDetail detail) {
        var response = bookingStorageService.getAllBookingStorage(detail);

        return ResponseDto.toResponseEntity(ResponseMessage.SUCCESS_GET_ALL_BOOKING_STORAGE, response);
    }

    @PostMapping
    public ResponseEntity<?> createBookingStorage(@AuthMember UserDetail detail,
                                                  @RequestBody @Valid BookingStorageRequest request) {
        var response = bookingStorageService.createBookingStorage(detail, request);

        return ResponseDto.toResponseEntity(ResponseMessage.SUCCESS_GET_ALL_BOOKING_STORAGE, response);
    }

}
