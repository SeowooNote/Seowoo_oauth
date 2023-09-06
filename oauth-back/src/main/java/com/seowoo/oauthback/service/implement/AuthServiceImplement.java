package com.seowoo.oauthback.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.seowoo.oauthback.dto.request.auth.SignUpRequestDto;
import com.seowoo.oauthback.dto.response.ResponseDto;
import com.seowoo.oauthback.dto.response.auth.SignUpResponseDto;
import com.seowoo.oauthback.entity.UserEntity;
import com.seowoo.oauthback.repository.UserRepository;
import com.seowoo.oauthback.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService {

     private final UserRepository userRepository;
     
     @Override
     public ResponseEntity<? super SignUpResponseDto> singUp(SignUpRequestDto dto) {

          String id = dto.getId();

          try {

               boolean hasId = userRepository.existsById(id);
               if(hasId) return SignUpResponseDto.existedId();

               UserEntity userEntity = new UserEntity(dto);
               userRepository.save(userEntity);

          } catch (Exception exception) {
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

          return SignUpResponseDto.success();

     }
     
}
