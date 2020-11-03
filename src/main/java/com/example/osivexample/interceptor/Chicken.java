package com.example.osivexample.interceptor;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chicken {
    private static final BigDecimal CHANGED_PRICE = BigDecimal.valueOf(100000L);

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private BigDecimal price;

    public Chicken update() {
        this.name = "CHANGED-NAME";
        this.price = CHANGED_PRICE;

        return this;
    }
}
