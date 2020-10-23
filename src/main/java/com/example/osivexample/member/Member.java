package com.example.osivexample.member;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "member_id")
    private List<Post> posts = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }
}
