package com.example.security.service.impl;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserDetailsService {

    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //数据库查询用户
        if(!("yunshijyz".equals(username))){
            System.out.println("用户不存在");
            return null;
        }

        String password = passwordEncoder.encode("jiang101");
        System.out.println(password);

        User user = new User(username,password
                , AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal,ROLE_abc"));

        return user;
    }
}
