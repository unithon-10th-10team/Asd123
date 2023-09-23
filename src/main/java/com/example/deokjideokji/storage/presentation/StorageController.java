package com.example.deokjideokji.storage.presentation;

import com.example.deokjideokji.auth.domain.UserDetail;
import com.example.deokjideokji.auth.infrastructure.annotation.AuthMember;
import com.example.deokjideokji.common.response.dto.ResponseDto;
import com.example.deokjideokji.common.response.dto.ResponseMessage;
import com.example.deokjideokji.storage.application.StorageService;
import com.example.deokjideokji.storage.dto.request.StorageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user/storage")
public class StorageController {
    private final StorageService storageService;

    @GetMapping
    public ResponseEntity<?> getAllStorages(@AuthMember UserDetail detail) {
        var response = storageService.getAllStorages(detail);

        return ResponseDto.toResponseEntity(ResponseMessage.SUCCESS_GET_ALL_STORAGE, response);
    }

    @PostMapping
    public ResponseEntity<?> createStorage(@AuthMember UserDetail detail,
                                           @RequestBody @Valid StorageRequest request) {
        var response = storageService.createStorage(detail, request);

        return ResponseDto.toResponseEntity(ResponseMessage.SUCCESS_CREATE_STORAGE, response);
    }
}
