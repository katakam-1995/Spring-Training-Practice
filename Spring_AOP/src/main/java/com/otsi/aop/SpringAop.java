package com.otsi.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Configuration
public class SpringAop {
	
	 private Logger log = LoggerFactory.getLogger(SpringAop.class);
	
	//@Before("execution(* com.otsi.controller.EmployeeController.getInfo(..))")
	@Around("execution(* com.otsi.controller.EmployeeController.getInfo(..))")
	public String getInfo(ProceedingJoinPoint  name) throws Throwable {
		//System.out.println(jp);
		ObjectMapper obj=new ObjectMapper();
		String className=name.getTarget().toString();
		String methodName=name.getSignature().getName();
		Object[] args=name.getArgs();
		
		log.info(className+"     "+methodName+" "+obj.writeValueAsString(args));
		long start=System.currentTimeMillis();
		Object as=name.proceed();
		long end=System.currentTimeMillis();
		long total=end-start;
		log.info(className+"     "+methodName+" "+obj.writeValueAsString(as)+"   "+total);
		return name.toString();
	}
	
	@After("execution(* com.otsi.controller.EmployeeController.getInfo(..)) && args(name)")
	public String getResult(String name) {
		System.out.println("After Execution:: "+name);
		return name;

	}
	
	@Before("execution(* com.otsi.controller.EmployeeController.saveEmployeeDetails(..))")
	public void saveEmployeeDetails(JoinPoint jp) {
		System.out.println(jp);
	}
	/*
	 * @After("execution(* com.otsi.controller.EmployeeController.saveEmployeeDetails(..)) && args(empVo)"
	 * ) public List<EmployeeVO> getSavedEmployeeDetails(List<EmployeeVO> empVo) {
	 * System.out.println("After Execution:: "+empVo); return empVo;
	 * 
	 * }
	 */
	
	@AfterThrowing(pointcut = "execution(* com.otsi.controller.EmployeeController.saveEmployeeDetails(..))" , throwing ="ex" )
	public void print(Exception ex) {
		System.out.println(ex.getMessage());
	}

}
