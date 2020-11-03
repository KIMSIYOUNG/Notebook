package com.example.immutabledto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @PostMapping("/hello")
    public ResponseEntity<HelloDto> post(@RequestBody HelloDto helloDto) {
        return ResponseEntity.ok(helloDto);
    }
}
