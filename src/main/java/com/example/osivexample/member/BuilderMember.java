package com.example.osivexample.member;

import lombok.Builder;

@Builder(toBuilder = true)
public class BuilderMember {
    private final Long id;
    private final String name;
    private final String email;
}
