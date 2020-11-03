package com.example.osivexample.interceptor;

import java.math.BigDecimal;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TestChicken {

    private final Long id;
    private final ChickenName name;
    private final BigDecimal price;
}
