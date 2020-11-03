package com.example.osivexample.interceptor.front;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.example.osivexample.interceptor.Chicken;
import com.example.osivexample.interceptor.LoginChicken;

@Component
public class MethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(LoginChicken.class);
    }

    @Override
    public Chicken resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
        NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        return (Chicken)webRequest.getAttribute("loginChicken", RequestAttributes.SCOPE_REQUEST);
    }
}
