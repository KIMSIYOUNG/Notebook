package com.example.osivexample.interceptor.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.osivexample.interceptor.Chicken;
import com.example.osivexample.interceptor.ChickenRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ChickenInterceptor implements HandlerInterceptor {
    private final ChickenRepository chickenRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Long id = Long.parseLong(request.getHeader("id"));

        Chicken chicken = chickenRepository.findById(id)
            .orElseThrow(IllegalArgumentException::new);

        request.setAttribute("loginChicken", chicken);

        return true;
    }
}
