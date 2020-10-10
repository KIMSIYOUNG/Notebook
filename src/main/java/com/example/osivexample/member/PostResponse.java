package com.example.osivexample.member;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private Long id;
    private String content;

    public static List<PostResponse> of(List<Post> posts) {
        return posts.stream()
            .map(post -> new PostResponse(post.getId(), post.getContent()))
            .collect(Collectors.toList());
    }
}
