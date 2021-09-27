package com.theo.jwt_rabbitmq.controller;

import com.theo.jwt_rabbitmq.model.JwtRequest;
import com.theo.jwt_rabbitmq.model.JwtResponse;
import com.theo.jwt_rabbitmq.service.UserService;
import com.theo.jwt_rabbitmq.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return "Welcome to JWT Demo Project!!";
    }

    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{
        // Authenticate username and password with the authentication manager from spring security
        // If valid create the jwt token and return it

        // Get username and password from jwtRequest and check them inside the authentication manager
        // Authentication part
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            e.printStackTrace();
            throw  new Exception("Invalid credentials",e);
        }

        //Authentication passed, now create token
        final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());
        final String token = jwtUtility.generateToken(userDetails);

        return  new JwtResponse(token);
    }
}
