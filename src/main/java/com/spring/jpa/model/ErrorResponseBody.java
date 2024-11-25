package com.spring.jpa.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ErrorResponseBody {

    private boolean success;

    private int code;

    private String message;

}
