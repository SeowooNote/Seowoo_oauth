package com.seowoo.oauthback.service;

import org.springframework.http.ResponseEntity;

import com.seowoo.oauthback.dto.request.auth.SignUpRequestDto;
import com.seowoo.oauthback.dto.response.auth.SignUpResponseDto;

public interface AuthService {
     
     ResponseEntity<? super SignUpResponseDto> singUp(SignUpRequestDto dto);

}
