package com.example.Greenstitch.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Builder
@Getter
public class JwtResponse {
    private String message;
    private String token;


}
