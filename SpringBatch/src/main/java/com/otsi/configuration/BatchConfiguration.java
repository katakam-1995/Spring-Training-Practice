package com.otsi.configuration;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import com.otsi.dao.Employee;
import com.otsi.model.DBLogProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory steps;

	@Autowired
	private DataSource dataSource;

	@Bean
	public Job readCSVFilesJob() {
		return (Job) jobs.get("readCSVFilesJob")
				.incrementer(new RunIdIncrementer())
				.start(step2())
				.build();
	}

	@Bean
	public Step step2() {
		return  steps.get("step2")
				.<Employee, Employee>chunk(5)
				.reader(reader())
				.processor(processorForJDBC())
				.writer(writerForJDBC(dataSource))
			.taskExecutor(taskExecutor())
				.build();
	}

	private TaskExecutor taskExecutor() {
		SimpleAsyncTaskExecutor asyncTaskExecutor=new SimpleAsyncTaskExecutor();
	    asyncTaskExecutor.setConcurrencyLimit(20);
	    return asyncTaskExecutor;
	}

	@Bean
	public ItemProcessor<Employee,Employee> processorForJDBC() {
		return new DBLogProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<Employee> writerForJDBC(DataSource dataSource) {
		JdbcBatchItemWriter<Employee> itemWriter = new JdbcBatchItemWriter<Employee>();
		itemWriter.setDataSource((javax.sql.DataSource) dataSource);
		itemWriter.setSql("INSERT INTO employee (id, name) VALUES (:id, :name)");
		itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Employee>());
		System.out.println(System.currentTimeMillis());
		return itemWriter;
	}

	@Bean
	public Step step1() {
		return steps.get("step1").<Employee, Employee>chunk(4)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}

	@Bean
	public ItemProcessor<Employee, Employee> processor() {
		return new EmployeeValidationProcessor();
	}

	@Bean
	public FlatFileItemReader<Employee> reader() {
		System.out.println(System.currentTimeMillis());
		FlatFileItemReader<Employee> itemReader = new FlatFileItemReader<Employee>();
		itemReader.setLineMapper(lineMapper());
		itemReader.setLinesToSkip(1);
		itemReader.setResource(
				new FileSystemResource("D:/Spring_Training_Practice/SpringBatch/src/main/resources/input/emp.csv"));
		return itemReader;
	}

	@Bean
	public LineMapper<Employee> lineMapper() {
		DefaultLineMapper<Employee> lineMapper = new DefaultLineMapper<Employee>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames(new String[] { "id", "name" });
		lineTokenizer.setIncludedFields(new int[] { 0, 1 });
		BeanWrapperFieldSetMapper<Employee> fieldSetMapper = new BeanWrapperFieldSetMapper<Employee>();
		fieldSetMapper.setTargetType(Employee.class);
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		return lineMapper;
	}

	@Bean
	public ConsoleItemWriter<Employee> writer() {
		return new ConsoleItemWriter<Employee>();
	}

	/*
	 * @Bean public Step stepOne() { return steps.get("stepOne").tasklet(new
	 * MyTaskOne()).listener(new StepSkipListener()).build(); }
	 * 
	 * @Bean public Step stepTwo() { return steps.get("stepTwo").tasklet(new
	 * MyTaskTwo()).listener(new StepSkipListener()).build(); }
	 * 
	 * @Bean public Job demoJob() { return jobs.get("demoJob").incrementer(new
	 * RunIdIncrementer()).listener(new JobResultListener())
	 * .start(stepOne()).next(stepTwo()).build(); }
	 */

}
