package com.otsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.otsi.model.Employee;
import com.otsi.service.EmployeeByConstructor;
import com.otsi.service.EmployeeByType;

@SpringBootApplication
public class SpringBeanAutowiringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBeanAutowiringApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("application-configuration.xml");
		
		//byName
		Employee emp = context.getBean("employee", Employee.class);
		emp.setId(4289);
		emp.setName("Bhargavi Katakam");
		emp.showEployeeDetails();
		
		//byType
		EmployeeByType serviceByType = context.getBean("employeeServiceByType", EmployeeByType.class);
		System.out.println("Autowiring byType:: EmployeeName= "+serviceByType.getEmployee().getName());
		
		//bvConstructor
		EmployeeByConstructor serviceByConstructor = context.getBean("employeeServiceConstructor", EmployeeByConstructor.class);
		System.out.println("Autowiring by Constructor:: EmployeeName= "+serviceByConstructor.getEmployee().getName());



	}

}
