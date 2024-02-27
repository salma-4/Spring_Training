package com.adminPanel.app.exception.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class ProductErrorResponse {
    private int code;
    private String message;
    private long timeStamp;
}
