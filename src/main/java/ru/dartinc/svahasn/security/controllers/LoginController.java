package ru.dartinc.svahasn.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dartinc.svahasn.security.dto.AuthDto;
import ru.dartinc.svahasn.security.model.User;
import ru.dartinc.svahasn.security.security.JwtAuthenticationException;
import ru.dartinc.svahasn.security.security.JwtTokenProvider;
import ru.dartinc.svahasn.security.services.UserService;


import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/login")
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @Autowired
    public LoginController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity login(@RequestBody AuthDto requestDto){
        try{
            String username = requestDto.getUserName();
            UsernamePasswordAuthenticationToken usernamePasswordAuthentication = new UsernamePasswordAuthenticationToken(username,requestDto.getPassword());
            authenticationManager.authenticate(usernamePasswordAuthentication);
            User user = userService.getByUserName(username);
            if(user == null){
                throw new UsernameNotFoundException("Username not found!!!");
            }

            String token = jwtTokenProvider.createToken(username,user.getRoles());
            Map<Object,Object> result = new HashMap<>();
            result.put("username",username);
            result.put("token", token);
            return ResponseEntity.ok(result);
        }catch (JwtAuthenticationException e){
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        } catch (AuthenticationException e){
            throw new BadCredentialsException("Invalid credentional!!!");
        }
    }
}
