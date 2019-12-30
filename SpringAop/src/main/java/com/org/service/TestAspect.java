package com.org.service;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import com.org.model.Employee;

@Aspect
@Configuration
public class TestAspect {

	public static List<Employee> empDetails = new ArrayList<>();

	@Before("execution(* com.org.service.TestService.getInfo(..))")
	public void getNameAdvice(JoinPoint joinPoint) {

		System.out.println("Executing Advice on getName() " + joinPoint.getArgs());
	}

	@Before("execution(* com.org.service.TestService.saveEmployeeDetails(..))")
	public List<Employee> getEmployeeList(JoinPoint jp) {

		empDetails.add(new Employee(0, "Emp", 101, false, "test"));

		return empDetails;

	}
	
	@After("execution(* com.org.service.TestService.saveEmployeeDetails(..)) && args(Employee employee)")
	public List<Employee> returnEmployeesAfter(JoinPoint jp,Employee employee){
		for (Employee emp: empDetails) {
			System.out.println(emp.getName());
		}
		return getEmployeeList(jp);
		
	}

}
