
package com.ad.backend.CarSystemApi.utils.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Response {
    private int status;
    private boolean error;
    private Object data;

    public Response(int status, Object data) {
        this.status = status;
        this.error = false;
        this.data = data;
    }
}

