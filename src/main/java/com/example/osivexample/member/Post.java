package com.example.osivexample.member;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.osivexample.member.Member;
import lombok.Getter;

@Entity
@Getter
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    public void setMember(Member member) {
        this.member = member;
    }
}
