package com.example.osivexample.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.osivexample.member.MemberService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class HelloService {
    private final UserService userService;

    public User findOrCreate() {
        try {
            return userService.findById(1L);
        } catch (IllegalArgumentException e) {
            User user = userService.create(new User(1L, "asdasdasd"));
            return user;
        }
    }
}
