package com.jobpair.G.G.auth.Controller;

import com.jobpair.G.G.auth.Dto.LoginDto;
import com.jobpair.G.G.auth.Dto.ResponseDto;
import com.jobpair.G.G.auth.Dto.SignUpDto;
import com.jobpair.G.G.auth.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired AuthService authService;
    @PostMapping("/signup")
    public ResponseDto<?> signUp(@RequestBody SignUpDto requestBody) {
        ResponseDto<?> result = authService.signUp(requestBody);
        return result;
    }

    @PostMapping("/login")
    public ResponseDto<?> login(@RequestBody LoginDto requestBody) {
        ResponseDto<?> result = authService.login(requestBody);
        return result;
    }
}
