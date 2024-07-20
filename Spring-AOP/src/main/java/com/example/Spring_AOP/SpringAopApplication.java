package com.example.Spring_AOP;

import com.example.Spring_AOP.services.AopServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAopApplication {

	public static void main(String[] args) {
		var ac = SpringApplication.run(SpringAopApplication.class, args);
		var aopServices = ac.getBean(AopServices.class);

		aopServices.beforeAdvice();

		aopServices.afterAdvice();

		aopServices.aroundAdvice("AOP", 1);

		aopServices.afterReturning("Spring AOP");

		aopServices.afterThrowing("Spring AOP throwing custom exception");
	}

}
