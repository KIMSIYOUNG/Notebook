package com.example.osivexample.transaction;

import java.net.URI;

import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.hibernate5.support.OpenSessionInViewInterceptor;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    private final ApplicationContext applicationContext;

    @PostMapping("/api/users")
    public ResponseEntity<Void> create(@RequestBody User user) {

        User savedUser = userService.create(user);

        return ResponseEntity.created(URI.create("/api/users/" + savedUser.getId())).build();
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> find(@PathVariable Long id) throws Exception {
        User findUser = userService.findOrCreate(id);

        return ResponseEntity.ok(findUser);
    }

    @PutMapping("/api/users")
    public ResponseEntity<User> update(@LoginMember User user) throws Exception {
        User findUser = userService.update(user);
        OpenEntityManagerInViewInterceptor bean = applicationContext.getBean(OpenEntityManagerInViewInterceptor.class);
        System.out.println(bean);
        return ResponseEntity.ok(findUser);
    }
}
