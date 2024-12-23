package com.example.lab12w10day2.Controller;

import com.example.lab12w10day2.Api.ApiResponse;
import com.example.lab12w10day2.Model.MyUser;
import com.example.lab12w10day2.Service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid MyUser myUser) {
        authService.register(myUser);
        return ResponseEntity.status(200).body(new ApiResponse("User registered"));
    }

    @PostMapping("/register-admin")
    public ResponseEntity registerAdmin(@RequestBody @Valid MyUser myUser) {
        authService.registerAdmin(myUser);
        return ResponseEntity.status(200).body(new ApiResponse("Admin registered"));
    }

    @GetMapping("/get")
    public ResponseEntity getAllUsers(@AuthenticationPrincipal MyUser myUser) {
        return ResponseEntity.status(200).body(authService.getAllUsers());
    }
}
