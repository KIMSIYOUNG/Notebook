package com.example.osivexample.member;

import lombok.Builder;

@Builder(toBuilder = true)
public class BuilderMember {
    private Long id;
    private String name;
    private String email;

    public BuilderMember(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
