package com.example.Spring_AOP.services;

import org.springframework.stereotype.Component;

@Component
public class AopServices {


    public String beforeAdvice(){
        return "Before Advice!";
    }

    public String afterAdvice(){
        return "After Advice!";
    }

    public String aroundAdvice(String name, int age){
        return "Around Advice with name: " + name + " and age: " + age;
    }

    public String afterReturning(String name){
        return "After returning name: " + name;
    }

    public String afterThrowing(String name){
        throw new CustomException("custom exception thrown");
    }
}
