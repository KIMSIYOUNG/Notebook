package com.example.osivexample.member;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/api/hi")
    public ResponseEntity view() {
        return ResponseEntity.ok(new Member());
    }

    @GetMapping("/api/hello")
    public String view2() {
        return "member";
    }

    @GetMapping("/api/hello2")
    public Member view3() {
        return new Member();
    }
}
