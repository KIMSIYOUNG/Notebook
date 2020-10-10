package com.example.osivexample.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    @DirtiesContext
    void member() {
        memberRepository.save(new Member());
    }

    @Test
    @DirtiesContext
    void member2() {
        memberRepository.save(new Member());
    }

    @Test
    @DirtiesContext
    void member3() {
        memberRepository.save(new Member());
    }

    @Test
    @DirtiesContext
    void member4() {
        memberRepository.save(new Member());
    }
}