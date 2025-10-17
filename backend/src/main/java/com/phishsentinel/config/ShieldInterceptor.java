package com.phishsentinel.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ShieldInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        // ✅ Example logging
        System.out.println("🔒 Incoming request: " + request.getMethod() + " " + request.getRequestURI());
        return true; // allow request to continue
    }
}

