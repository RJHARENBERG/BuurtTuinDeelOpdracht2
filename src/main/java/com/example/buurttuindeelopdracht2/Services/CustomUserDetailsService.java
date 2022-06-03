package com.example.buurttuindeelopdracht2.Services;

import com.example.buurttuindeelopdracht2.Dtos.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.*;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    //    @Autowired
//    private AuthorityService authorityService;
    @Override
    public UserDetails loadUserByUsername(String username) {
        UserDto userDto = userService.getUser(username);
        String password = userDto.getPassword();
        Set<Authority> authorities = userDto.getAuthorities();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority: authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }
        return new org.springframework.security.core.userdetails.User(username, password, grantedAuthorities);
    }
}