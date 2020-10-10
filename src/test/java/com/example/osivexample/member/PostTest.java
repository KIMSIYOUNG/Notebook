package com.example.osivexample.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
class PostTest {
    @Autowired
    private PostRepsoitory postRepsoitory;

    @Autowired
    private MemberRepository memberRepository;

    @Rollback(false)
    @Test
    void name() {
        Member member = new Member();
        Member savedMember = memberRepository.save(member);
        Post post = new Post();
        post.setMember(savedMember);
        Post save = postRepsoitory.save(post);

        postRepsoitory.findById(save.getId());

    }
}