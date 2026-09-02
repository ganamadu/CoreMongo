package com.core.mongo.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class RequestInterceptor implements HandlerInterceptor {

    // Request is intercepted by this method before reaching the Controller
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //* Business logic just when the request is received and intercepted by this interceptor before reaching the controller
        try{
            System.out.println("1 - preHandle(): before sending request to the controller.");
            System.out.println("Method Type: "+request.getMethod());
            System.out.println("Request Url: "+request.getRequestURI());
            //* If the Exception is caught, this method will return false
        }catch (Exception e) {
            e.printStackTrace();;
            return false;
        }
        return true;
    }

    // Response is intercepted by this method before reaching the client
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        //* Business logic just before the response reaches the client and the request is served
        try {
            System.out.println("2 - postHandle(): after the controller serves the request (before returning back response to the client).");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    // This method is called after request & response HTTP communication is done.
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        //* Business logic after request and response is Completed
        try {
            System.out.println("3 - afterCompletion() : After the request and Response is completed");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }



}
