package com.example.Greenstitch.config;

import com.example.Greenstitch.entity.OfficialUser;
import com.example.Greenstitch.service.impliment.OfficialUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
    @Autowired
    private OfficialUserServiceImpl userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        OfficialUser x = userService.getUserByUsername(username);
        ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        return new User(x.getUserName(),x.getPassword(),authorities);
    }
}
