package com.jobpair.G.G.auth.Controller;

import com.jobpair.G.G.auth.Dto.LoginDto;
import com.jobpair.G.G.auth.Dto.ResponseDto;
import com.jobpair.G.G.auth.Dto.SignUpDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {
    @PostMapping("/signup")
    public ResponseDto<?> signUp(@RequestBody SignUpDto requestBody) {
        return null;
    }

    @PostMapping("/login")
    public ResponseDto<?> login(@RequestBody LoginDto requestBody) {
        return null;
    }
}
