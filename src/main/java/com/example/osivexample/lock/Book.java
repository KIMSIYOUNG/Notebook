package com.example.osivexample.lock;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Version
    private Long version;

    @ManyToOne
    private OptimisticMember optimisticMember;

    public Book(String name, OptimisticMember optimisticMember) {
        this.name = name;
        this.optimisticMember = optimisticMember;
    }
}
