package com.example.lab12w10day2.Service;

import com.example.lab12w10day2.Api.ApiException;
import com.example.lab12w10day2.Model.MyUser;
import com.example.lab12w10day2.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final AuthRepository authRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user = authRepository.findMyUserByUsername(username);
        if (user == null) {
            throw new ApiException("User not found");
        }
        return user;
    }
}
