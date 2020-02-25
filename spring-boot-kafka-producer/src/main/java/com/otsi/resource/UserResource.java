package com.otsi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.otsi.model.User;

@RestController
@RequestMapping("/kafka")
public class UserResource {
	
	private static final String TOPIC = "kafkaexample";
	
	/*
	 * @Autowired
	 * private KafkaTemplate<String, String> kafkaTemplate;
	 */
	
	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;
	
	/*
	 * @GetMapping("publish/{message}") public String post(@PathVariable("message")
	 * final String message) { kafkaTemplate.send(TOPIC,message); return
	 * "Published Successfully";
	 * 
	 * }
	 */
	
	@GetMapping("publish/{name}")
	public String post(@PathVariable("name") final String name) {
		kafkaTemplate.send(TOPIC,new User(name,"Technology",12000L));
		return "Published Successfully";
		
	}

	/*
	 * ListenableFuture<SendResult<String, User>> send =
	 * kafkaTemplate.send(TOPIC,new User(name,"Technology",12000L));
	 * if(send.isDone()) return "Published Successfully"; return "Not done!";
	 */
}
