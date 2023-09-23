package com.example.deokjideokji.storage.application;

import com.example.deokjideokji.auth.domain.UserDetail;
import com.example.deokjideokji.bookingstorage.application.BookingStorageService;
import com.example.deokjideokji.member.application.MemberService;
import com.example.deokjideokji.storage.domain.Storage;
import com.example.deokjideokji.storage.dto.request.StorageRequest;
import com.example.deokjideokji.storage.dto.response.StorageResponse;
import com.example.deokjideokji.storage.infrastructure.StorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StorageService {
    private final StorageRepository storageRepository;
    private final BookingStorageService bookingStorageService;
    private final MemberService memberService;

    @Transactional(readOnly = true)
    public List<StorageResponse> getAllStorages(UserDetail detail) {
        memberService.validateUserDetail(detail);

        var StorageResponses = storageRepository.findAllByUserId(detail.getId()).stream()
                .map(Storage::toResponseDto)
                .collect(Collectors.toList());

        return StorageResponses;
    }

    @Transactional
    public StorageResponse createStorage(UserDetail detail, StorageRequest request) {
        memberService.validateUserDetail(detail);
        bookingStorageService.deleteBookingStorage(request);

        return storageRepository.save(request.toEntity()).toResponseDto();
    }
}

