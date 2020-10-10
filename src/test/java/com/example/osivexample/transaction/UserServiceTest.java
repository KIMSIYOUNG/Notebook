package com.example.osivexample.transaction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;

@SpringBootTest
class UserServiceTest {
    @Autowired ApplicationContext applicationContext;
    @Autowired
    private UserService userService;

    @Autowired
    private HelloService helloService;


    @Test
    void transactionTest() {
        User user = helloService.findOrCreate();

        System.out.println(user);
    }

    @Test
    void name() {
        Object bean = applicationContext.getBean(OpenEntityManagerInViewInterceptor.class);
        System.out.println(bean.getClass().getName());
    }
}