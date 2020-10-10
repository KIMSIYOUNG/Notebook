package com.example.osivexample.member;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponse {
    private Long id;
    private String name;
    private List<PostResponse> posts;

    public static MemberResponse of(Member member) {
        return new MemberResponse(
            member.getId(),
            member.getName(),
            PostResponse.of(member.getPosts())
        );
    }
}
