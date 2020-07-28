package com.zy.more.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zy.more.Result;
import com.zy.more.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangyao
 * @create:2020-07-23 17:30
 **/
public class UserDetailServiceImpl implements ReactiveUserDetailsService {

    @Autowired
    UserFeignClient userFeignClient;

    @Override
    public Mono<UserDetails> findByUsername(String s) {
        Result result = userFeignClient.getUserByName(s);
        ObjectMapper o = new ObjectMapper();
        more.entity.User user1 = o.convertValue(((List<more.entity.User>) result.getData()).get(0), more.entity.User.class);
        if (user1==null) {
            return null;
        }
        List list = new ArrayList();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("user");
        list.add(grantedAuthority);
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return Mono.just(new User(user1.getUserName(), encoder.encode(user1.getPassword()), list));
    }
}
