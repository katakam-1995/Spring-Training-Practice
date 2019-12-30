package com.otsi.model;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class SpringActuator implements HealthIndicator {

	SpringActuator() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	 * public boolean getConnection() { boolean flag=false; try { URL url=new
	 * URL("http://localhost:8000"); URLConnection connection=url.openConnection();
	 * connection.getContent(); flag=true; }catch (Exception e) { flag=false; }
	 * 
	 * return flag;
	 * 
	 * }
	 * 
	 * @Override public Health health() { if(getConnection()==true) { return
	 * Health.status(Status.UP).build(); } return
	 * Health.status(Status.DOWN).build(); }
	 */

	@Override
	public Health health() {
		// TODO Auto-generated method stub
		return null;
	}}
