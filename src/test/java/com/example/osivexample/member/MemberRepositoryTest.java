package com.example.osivexample.member;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PostRepsoitory postRepsoitory;

    @Autowired
    EntityManager em;

    @Test
    void member() {
        memberRepository.save(new Member());
    }

    @Transactional
    @Test
    void member2() {
        Member save = memberRepository.save(new Member());
        Post post = new Post();
        post.setMember(save);
        Post saved = postRepsoitory.save(post);

        em.flush();
        em.clear();

        Post findPost = postRepsoitory.findById(saved.getId()).get();
        Member findMember = memberRepository.findById(save.getId()).get();

        System.out.println("hello");
    }

    @Test
    void member3() {
        memberRepository.save(new Member());
    }

    @Test
    void member4() {
        memberRepository.save(new Member());
    }
}