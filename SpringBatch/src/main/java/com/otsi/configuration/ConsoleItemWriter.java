package com.otsi.configuration;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class ConsoleItemWriter<Employee> implements ItemWriter<Employee>{

    private static final Logger LOG = LoggerFactory.getLogger(ConsoleItemWriter.class);
    

	@SuppressWarnings("static-access")
	@Override
	public void write(List<? extends Employee> emp) throws Exception {
		 LOG.trace("Console employee writer starts");
		   for (Employee empl : emp) {	 
			 LOG.info(ReflectionToStringBuilder.reflectionToString(empl));
		 }
	     LOG.trace("Console employee writer ends");
		
	}

	

	

}
