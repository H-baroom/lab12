package com.example.lab12w10day2.Service;

import com.example.lab12w10day2.Model.MyUser;
import com.example.lab12w10day2.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;

    public void register(MyUser myUser) {
        myUser.setRole("USER");
        String hashPassword = new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(hashPassword);
        authRepository.save(myUser);
    }

    public void registerAdmin(MyUser myUser) {
        myUser.setRole("ADMIN");
        String hashPassword = new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(hashPassword);
        authRepository.save(myUser);
    }

    public List<MyUser> getAllUsers() {
        List<MyUser> users = authRepository.findAll();
        return users;
    }

}
