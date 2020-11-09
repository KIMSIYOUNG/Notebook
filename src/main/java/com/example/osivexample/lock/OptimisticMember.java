package com.example.osivexample.lock;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class OptimisticMember {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Version
    private Long version;

    public OptimisticMember(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
