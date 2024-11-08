package com.vitech.Sprint3_Lab06.service.impl;

import com.vitech.Sprint3_Lab06.entities.UserEntity;
import com.vitech.Sprint3_Lab06.repository.UserRepository;
import com.vitech.Sprint3_Lab06.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public UserEntity save(UserEntity newUser) {
        return userRepository.save(newUser);
    }
}
