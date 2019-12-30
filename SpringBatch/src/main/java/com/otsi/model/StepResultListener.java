package com.otsi.model;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class StepResultListener implements StepExecutionListener{

	@Override
	public void beforeStep(StepExecution stepExecution) {
		System.out.println("called before step...");
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		System.out.println("called after step...");
		return ExitStatus.COMPLETED;
	}

}
