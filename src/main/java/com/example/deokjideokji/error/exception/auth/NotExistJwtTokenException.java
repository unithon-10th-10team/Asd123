package com.example.deokjideokji.error.exception.auth;

import com.example.deokjideokji.error.dto.ErrorMessage;
import com.example.deokjideokji.error.exception.BusinessException;

public class NotExistJwtTokenException extends BusinessException {
    public NotExistJwtTokenException(ErrorMessage message) {
        super(message);
    }

    public NotExistJwtTokenException(ErrorMessage message, String reason) {
        super(message, reason);
    }
}
