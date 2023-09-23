package com.example.deokjideokji.storage.dto.request;

import com.example.deokjideokji.storage.domain.Storage;
import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
public class StorageRequest {
    @NotNull
    private Long id;

    @NotNull
    private String userId;

    @NotNull
    private Long restaurantId;

    @NotNull
    @Min(0)
    @Max(100)
    private Integer temp;

    public Storage toEntity() {
        return Storage.builder()
                .id(id)
                .userId(userId)
                .restaurantId(restaurantId)
                .temp(temp)
                .build();
    }
}
