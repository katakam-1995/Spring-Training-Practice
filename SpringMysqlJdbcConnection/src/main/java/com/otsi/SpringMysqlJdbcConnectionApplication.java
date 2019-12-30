package com.otsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.otsi.dao.EmployeeDao;
import com.otsi.dao.JdbcEmployeeDAO;
import com.otsi.model.Employee;

@SpringBootApplication
public class SpringMysqlJdbcConnectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMysqlJdbcConnectionApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

		System.out.println("Connected Successfully....");
		JdbcEmployeeDAO jdbcEmployeeDAO = (JdbcEmployeeDAO) context.getBean("employeeDAO");

		Employee employee = new Employee(2, "Bhargavi");
		jdbcEmployeeDAO.insert(employee);
		jdbcEmployeeDAO.insertPostgreSql(employee);

		

		/*
		 * Employee emp = jdbcEmployeeDAO.findById(5); if (emp == null) {
		 * System.out.println("No Record Found"); } else {
		 * System.out.println("Employee Id:: " + emp.getId() + "\nEmployee Name:: " +
		 * emp.getName()); }
		 */

	}

}
