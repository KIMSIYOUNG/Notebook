package com.example.immutabledto;

import java.beans.ConstructorProperties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor_ = @ConstructorProperties("id, name"))
@Getter
public class HelloDto {
    private final Long id;
    private final HelloName name;
}
