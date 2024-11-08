package com.vitech.Sprint3_Lab06.service;

import com.vitech.Sprint3_Lab06.entities.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

    public UserEntity save (UserEntity newUser);

    public UserDetailsService userDetailsService();
}
