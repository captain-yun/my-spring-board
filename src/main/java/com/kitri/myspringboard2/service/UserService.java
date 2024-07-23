package com.kitri.myspringboard2.service;

import com.kitri.myspringboard2.domain.User;
import com.kitri.myspringboard2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserMapper userMapper;

    public void signup(User user) {


        if (!user.getPassword().equals(user.getPassword2())) throw new RuntimeException("비밀번호가 일치하지 않습니다");

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userMapper.insert(user);
        userMapper.insertAuthority(user.getId(), "ROLE_USER");
    }
}
