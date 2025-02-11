package com.example.springboot_developer.service;

import com.example.springboot_developer.domain.User;
import com.example.springboot_developer.dto.AddUserRequest;
import com.example.springboot_developer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto){
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getId();
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Unexpected User"));
    }
}
