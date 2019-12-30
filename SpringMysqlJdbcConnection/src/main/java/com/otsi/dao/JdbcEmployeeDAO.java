package com.otsi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Primary;

import com.otsi.model.Employee;

public class JdbcEmployeeDAO implements EmployeeDao {

	
	  private DataSource dataSource1;
	  
	  private DataSource dataSource2;

	  
	/*
	 * public void setDataSource(DataSource dataSource) { this.dataSource =
	 * dataSource; }
	 */
	@Primary
	public DataSource dataSource1(){
	    return DataSourceBuilder.create().build();
	}

	public DataSource dataSource2(){
	    return DataSourceBuilder.create().build();
	}

	String sqlQuery = "SELECT * FROM employee WHERE id = ?";
	String sql = "INSERT INTO employee " + "(id, name) VALUES (?, ?)";

	@Override
	public void insert(Employee employee) {
		Connection conn = null;
		try {
			conn = dataSource1.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setFloat(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public Employee findById(int id) {
		Connection conn = null;
		try {
			conn = dataSource1.getConnection();
			PreparedStatement ps = conn.prepareStatement(sqlQuery);
			ps.setInt(1, id);
			Employee employee = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				employee = new Employee(rs.getInt("id"), rs.getString("name"));
			}
			rs.close();
			ps.close();
			return employee;

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public void insertPostgreSql(Employee employee) {
		Connection conn = null;
		try {
			conn = dataSource2.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setFloat(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

}
