package com.example.deokjideokji.map.presentation;

import com.example.deokjideokji.auth.domain.UserDetail;
import com.example.deokjideokji.auth.infrastructure.annotation.AuthMember;
import com.example.deokjideokji.common.response.dto.ResponseDto;
import com.example.deokjideokji.common.response.dto.ResponseMessage;
import com.example.deokjideokji.map.application.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/map")
public class MapController {
    private final MapService mapService;

    @GetMapping("/{lon}/{lat}")
    private ResponseEntity<?> getLocation(@AuthMember UserDetail detail, @PathVariable Double lat,
                                          @PathVariable Double lon) {
        var response = mapService.getLocationMap(detail, lat, lon);
        System.out.println(response);

        return ResponseDto.toResponseEntity(ResponseMessage.SUCCESS_GET_MAP_LOCATION, response);
    }
}
