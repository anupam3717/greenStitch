package com.example.Greenstitch.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ApiError {

    private String serviceName;

    private String serviceVersion;

    private String code;

    private String message;


}
