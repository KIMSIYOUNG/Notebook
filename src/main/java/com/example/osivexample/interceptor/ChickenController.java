package com.example.osivexample.interceptor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ChickenController {
    private final ChickenService chickenService;

    @PutMapping("/chicken")
    public ResponseEntity<ChickenDto> update(@LoginChicken Chicken chicken) {
        return ResponseEntity.ok(ChickenDto.from(chickenService.update(chicken)));
    }

    @GetMapping("/chicken")
    public ResponseEntity<ChickenDto> get() {
        return ResponseEntity.ok(ChickenDto.from(chickenService.get()));
    }
}
