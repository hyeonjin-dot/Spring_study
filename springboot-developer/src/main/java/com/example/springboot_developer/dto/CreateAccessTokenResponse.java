package com.example.springboot_developer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreateAccessTokenResponse {
    private String accessToken;
}
