package com.example.osivexample.transaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.orm.hibernate5.support.OpenSessionInViewInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@Order(value = Ordered.LOWEST_PRECEDENCE)
public class HelloInterceptor implements HandlerInterceptor {
    private final UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  {
        // String id = request.getHeader(HttpHeaders.AUTHORIZATION);
        // User user = userService.findById(Long.parseLong(id));
        // request.setAttribute("user", user);
        return true;
    }
}
