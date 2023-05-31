package com.example.Greenstitch.controller;

import com.example.Greenstitch.dto.JwtResponse;
import com.example.Greenstitch.dto.LoginDto;
import com.example.Greenstitch.config.UserInfoUserDetailsService;
import com.example.Greenstitch.entity.OfficialUser;
import com.example.Greenstitch.security.JwtProvider;
import com.example.Greenstitch.service.impliment.OfficialUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/")
public class AuthController {
    @Autowired
    private UserInfoUserDetailsService loadUser;
    @Autowired
    private JwtProvider jwt;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private OfficialUserServiceImpl userService;
    @PostMapping("signup")
    public String signup(@RequestBody OfficialUser user){
       userService.addUser(user);
        return "added";
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginDto user){

           Authentication x = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
           String token= jwt.generateToken(user.getUserName());
           JwtResponse response = JwtResponse.builder().message("Login successful").token(token).build();
           return  ResponseEntity.ok().body(response);
    }


}
