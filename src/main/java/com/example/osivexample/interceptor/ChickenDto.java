package com.example.osivexample.interceptor;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ChickenDto {
    private final Long id;
    private final String name;
    private final BigDecimal price;

    public static ChickenDto from(Chicken chicken) {
        return new ChickenDto(chicken.getId(), chicken.getName(), chicken.getPrice());
    }
}
