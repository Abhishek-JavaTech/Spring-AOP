package com.example.Spring_AOP.aspects;

import com.example.Spring_AOP.services.CustomException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class AopAspects {

//    execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern) throws-pattern?)

    @Before("beforeAdvicePointcut()")
    public void callingBeforeAdvice(){
        System.out.println("callingBeforeAdvice is executed!");
    }

    @After("afterAdvicePointcut()")
    public void callingAfterAdvice(){
        System.out.println("callingAfterAdvice is executed! ");
    }

    @Around("aroundAdvicePointcut()")
    public void callingAroundAdvice(ProceedingJoinPoint point) throws Throwable {

        var args = point.getArgs();
        System.out.println("args[0]: " + args[0] + " args[1]: " + args[1]);

        var objArr = new Object[2];
        objArr[0] = "Spring AOP";
        objArr[1] = 2;

        var retur = point.proceed(objArr);
        System.out.println("returned value: "+retur);
        System.out.println("callingAroundAdvice is executed! ");
    }

    @AfterReturning(value = "afterReturningAdvicePointcut()", returning = "value")
    public void afterThrowingPointcut(String value){
        System.out.println("callingAfterAdvice is executed! "+value);
    }

    @AfterThrowing(value = "afterThrowingPointcut()", throwing = "ex")
    public void callingAfterThrowingPointcut(CustomException ex){
        System.out.println("callingAfterThrowingPointcut is executed! ");
    }

    @Pointcut(value = "execution(* before*(..))")
    public void beforeAdvicePointcut(){    }

    @Pointcut(value = "execution(* afterAdvice(..))")
    public void afterAdvicePointcut(){    }

    @Pointcut(value = "execution(* around*(String, int))")
    public void aroundAdvicePointcut(){    }

    @Pointcut(value = "execution(* afterThrowing(String))")
    public void afterThrowingPointcut(){    }


}
