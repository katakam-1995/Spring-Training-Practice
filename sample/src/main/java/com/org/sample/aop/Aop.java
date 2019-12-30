package com.org.sample.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class Aop {

	@Before("execution(* com.org.sample.controller.TestController.getInfo(..))")
	public void getInfo(JoinPoint jp) {
		System.out.println(jp);
	}
}
