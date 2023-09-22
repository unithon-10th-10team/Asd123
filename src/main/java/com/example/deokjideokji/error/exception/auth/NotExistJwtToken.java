package com.example.deokjideokji.error.exception.auth;

import com.example.deokjideokji.error.dto.ErrorMessage;
import com.example.deokjideokji.error.exception.BusinessException;

public class NotExistJwtToken extends BusinessException {
    public NotExistJwtToken(ErrorMessage message) {
        super(message);
    }

    public NotExistJwtToken(ErrorMessage message, String reason) {
        super(message, reason);
    }
}
