package com.jobpair.G.G.auth.Service;

import com.jobpair.G.G.auth.Dto.LoginDto;
import com.jobpair.G.G.auth.Dto.LoginResponseDto;
import com.jobpair.G.G.auth.Dto.ResponseDto;
import com.jobpair.G.G.auth.Dto.SignUpDto;
import com.jobpair.G.G.auth.Entity.UserEntity;
import com.jobpair.G.G.auth.Provider.TokenProvider;
import com.jobpair.G.G.auth.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired UserRepository userRepository;
    @Autowired TokenProvider tokenProvider;
    public ResponseDto<?> signUp(SignUpDto dto) {
        String userId = dto.getUserId();
        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();

        try {
            if(userRepository.existsById(userEmail)) {
                return ResponseDto.setFailed("Existed Email!");
            }
        } catch(Exception error) {
            return ResponseDto.setFailed("Database Error");
        }

        UserEntity userEntity = new UserEntity();

        try {
            // UserRepository를 이용해 DB에 저장
            userRepository.save(userEntity);
        } catch (Exception error) {
            return ResponseDto.setFailed("Database Error");
        }

        return ResponseDto.setSuccess("SignUp Success!", null);
    }

    public ResponseDto<?> login(LoginDto dto) {
        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();

        try {
            boolean existed = userRepository.existsByUserEmailAndUserPassword(userEmail, userPassword);

            if(!existed) {
                return ResponseDto.setFailed("Wrong Login Info");
            }
        } catch (Exception error) {
            return ResponseDto.setFailed("Database Error");
        }

        UserEntity userEntity = null;
        try {
            // 값이 존재하면
            userEntity = userRepository.findById(userEmail).get(); // 사용자 이메일을 가져옴
        } catch(Exception e) {
            return ResponseDto.setFailed("Database Error");
        }

        userEntity.setUserPassword("");

        String token = tokenProvider.createJwt(userEmail);
        int exprTime = 3600000; // 한 시간

        LoginResponseDto loginResponseDto = new LoginResponseDto(token, exprTime, userEntity);
        return ResponseDto.setSuccess("Login Success", loginResponseDto);
    }
}
