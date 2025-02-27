package com.mikeshaggy.tripsplit.api.rest.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
public class ErrorDetails {

    private String type;
    private String title;
    private int status;
    private String detail;
    private String instance;
    private Map<String, String> errors;
}
