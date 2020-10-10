package com.example.osivexample.transaction;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import net.bytebuddy.asm.Advice;

@DataJpaTest
class HelloServiceTest {
    @Autowired
    UserRepository userRepository;

    @Rollback(false)
    @Test
    void name() {
        User user = new User(10L, "asdsad");
        User savedUser = userRepository.save(user);
        assertThat(savedUser.getId()).isEqualTo(10);
    }
}