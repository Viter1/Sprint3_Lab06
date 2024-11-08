package com.vitech.Sprint3_Lab06.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    @PostMapping("/signup")
    public ResponseEntity<?> singup(){

        return null;

    }

    @PostMapping("/signup")
    public ResponseEntity<?> login(){

        return null;

    }
}
