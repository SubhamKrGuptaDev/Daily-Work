package com.parking.lot.dto;

import lombok.Getter;
import lombok.Setter;

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
