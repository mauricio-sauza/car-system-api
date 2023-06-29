
package com.ad.backend.CarSystemApi.Exceptions;

import lombok.Data;

@Data
public class ErrorResponse {
    private int status;
    private Object message;

    public ErrorResponse(int status, Object message) {
        this.status = status;
        this.message = message;
    }
}

