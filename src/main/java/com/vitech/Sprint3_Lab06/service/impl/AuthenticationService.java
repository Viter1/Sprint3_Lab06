package com.vitech.Sprint3_Lab06.service.impl;

import com.vitech.Sprint3_Lab06.dto.JwtResponse;
import com.vitech.Sprint3_Lab06.dto.LoginRequest;
import com.vitech.Sprint3_Lab06.dto.SingUpRequest;
import com.vitech.Sprint3_Lab06.entities.UserEntity;
import com.vitech.Sprint3_Lab06.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final UserServiceImpl userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;





    public JwtResponse signUp(SingUpRequest request) throws BadRequestException {
        var user = UserEntity
                .builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role("ROLE_USER").build();

        user = userService.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtResponse.builder().token(jwt).build();
    }

    public Object logIn(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getMail(),request.getPassword()));
        var user = userRepository.findByEmail(request.getMail()).orElseThrow(()-> new IllegalArgumentException("Invalid email or password."));

        var jwt = jwtService.generateToken(user);
        return JwtResponse.builder().token(jwt).build();
    }
}
