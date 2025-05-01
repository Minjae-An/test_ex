package com.example.test_ex.user.service;

import com.example.test_ex.user.domain.User;
import com.example.test_ex.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findById(long userId) {

        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("user not found"));
    }
}
