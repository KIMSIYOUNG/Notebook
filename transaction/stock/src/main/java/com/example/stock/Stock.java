package com.example.stock;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Stock {

    @Id @GeneratedValue
    private Long id;

    private Long productId;

    private Long amount;

    public void decrease(long amount) {
        this.amount -= amount;
    }
}
