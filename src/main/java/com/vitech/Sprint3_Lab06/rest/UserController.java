package com.vitech.Sprint3_Lab06.rest;

import com.vitech.Sprint3_Lab06.dto.LoginRequest;
import com.vitech.Sprint3_Lab06.dto.SingUpRequest;
import com.vitech.Sprint3_Lab06.service.impl.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationService authenticacionService;

    @PostMapping("/signup")
    public ResponseEntity<?> singup(@RequestBody SingUpRequest request){
        try{
            return ResponseEntity.ok(authenticacionService.signUp(request));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        try{
            return ResponseEntity.ok(authenticacionService.logIn(request));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
}
