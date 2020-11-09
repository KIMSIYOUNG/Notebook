package com.example.osivexample.member;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final EntityManager entityManager;

    @Transactional(readOnly = true)
    public Member findPostsByMemberId(Long id) {
        Member findMember = memberRepository.findById(id)
            .orElseThrow(IllegalArgumentException::new);

        return findMember;
    }

    @Transactional
    public void change(Member member) {
        System.out.println(member.getId());
        member.setName("asdfasdfasdf");
        entityManager.merge(member);
    }
}
