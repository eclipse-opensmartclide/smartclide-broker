package com.theo.websocket_jwt.service;

import com.theo.websocket_jwt.model.AppUserDetails;
import com.theo.websocket_jwt.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = new User("smartClide","somepass");
        return new AppUserDetails(user);
    }
}
