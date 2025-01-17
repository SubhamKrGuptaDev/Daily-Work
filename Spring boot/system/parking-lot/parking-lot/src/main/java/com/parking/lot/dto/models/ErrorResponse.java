package com.parking.lot.dto.models;

import lombok.Getter;
import lombok.Setter;

/**
 * Error Response object
 */
@Getter
@Setter
public class ErrorResponse {
    private String message;
    private Integer status;

    public ErrorResponse(String message, Integer status) {
        this.message = message;
        this.status = status;
    }
}
