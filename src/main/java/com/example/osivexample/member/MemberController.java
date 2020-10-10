package com.example.osivexample.member;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/api/query/members-post/{id}")
    public ResponseEntity<MemberResponse> getMemberWithPosts(@PathVariable Long id) {
        Member member = memberService.findPostsByMemberId(id);
        member.setName("dsfadsfasdfasdf");

        memberService.change(member);
        return null;
    }

    @GetMapping("/api/view")
    public String member() {
        return "member";
    }

    @GetMapping("/api/rest")
    public ResponseEntity<Member> member2() {
        return ResponseEntity.ok(new Member());
    }
}
