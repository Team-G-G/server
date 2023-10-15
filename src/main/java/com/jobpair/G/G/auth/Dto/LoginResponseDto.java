package com.jobpair.G.G.auth.Dto;

import com.jobpair.G.G.auth.Entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {
    private String token;
    private int expiredTime;
    private UserEntity user;
}
