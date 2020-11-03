package com.example.immutabledto;

import java.beans.ConstructorProperties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor_ = @ConstructorProperties("name"))
@Getter
public class HelloName {
    private final String name;
}
