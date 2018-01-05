package com.los.service;

import com.los.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by nuwantha on 11/21/16.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = getUserService().getUserByName(username);
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getEmail(), AuthorityUtils.createAuthorityList(user.getRole()));

    }


    public UserService getUserService() {
        return userService;
    }
}
