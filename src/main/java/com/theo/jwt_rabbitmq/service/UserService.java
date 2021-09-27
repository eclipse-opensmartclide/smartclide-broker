package com.theo.jwt_rabbitmq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {
    //@Value("${jwt.user}")
    //private  String username;

    //@Value("${jwt.pass}")
    //private String pass;

    @Autowired
    private Environment env;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // Logic to load user from database

        // For now just create a dummy object and return it
        // Convert our user to User model of Spring Security
        //return new User(userName,pass,new ArrayList<>());
        return new User(env.getProperty("SMARTCLIDE_USER"),env.getProperty("SMARTCLIDE_PASS"),new ArrayList<>());
    }
}
