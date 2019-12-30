package com.otsi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.otsi.model.ExecutorServices;

@Service
public class ExecutorServicesImpl {
	private int count1;

	public void generatingUniqueIdsToNames() throws InterruptedException {
		count1 = 0;
		final ExecutorService executorService = (ExecutorService) Executors.newFixedThreadPool(2);
		List<Callable<ExecutorServices>> list = new ArrayList<>();
		List<String> names = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
				"P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
		for (int count = 0; count < names.size(); count++) {
			list.add(() -> task(count1++, names));
			
			
		}
		List<Future<ExecutorServices>> resultList = executorService.invokeAll(list);
		
		while(true) {
			if(resultList.size() == list.size()) {
				break;
			}
		}
		
		resultList.forEach(e -> {
			try {
				System.out.println(e.get().getId()
						+ "--------------" + e.get().getName() + "--------------" + e.get().getThrdnme());
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} catch (ExecutionException e1) {
				e1.printStackTrace();
			}
		});
		executorService.shutdown();
	}

	public ExecutorServices task(int count, List<String> names) {

		ExecutorServices es = new ExecutorServices();
		es.setId(count);
		es.setName(names.get(count));
		es.setThrdnme(Thread.currentThread().getName());
		return es;

	}

}
