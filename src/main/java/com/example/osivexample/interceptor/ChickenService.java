package com.example.osivexample.interceptor;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class ChickenService {
    private final ChickenRepository chickenRepository;

    @PostConstruct
    public void create() {
        Chicken chicken = new Chicken(null, "not changed", BigDecimal.valueOf(1000));

        chickenRepository.save(chicken);
    }

    public Chicken update(Chicken chicken) {
        return chicken.update();
    }

    public Chicken get() {
        return chickenRepository.findById(1L)
            .orElseThrow(IllegalArgumentException::new);
    }
}
