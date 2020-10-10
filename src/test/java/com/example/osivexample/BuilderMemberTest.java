package com.example.osivexample;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.osivexample.member.BuilderMember;

class BuilderMemberTest {

    @Test
    void toBuilderTest() {
        BuilderMember origin = BuilderMember.builder()
            .id(1L)
            .email("aaaa")
            .name("bbbb")
            .build();

        BuilderMember changed = origin.toBuilder()
            .email("bbbb")
            .build();

        assertThat(origin == changed).isFalse();
    }
}