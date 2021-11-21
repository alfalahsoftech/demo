package com.alfalahsoftech.demo;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration
public class UserController {
	
	@GetMapping(path="/userList")
	public java.util.List<String> userList() {
		System.out.println("Demo : User List");
		 System.out.println("this::"+this);
		return Arrays.asList("Asad","Rahmain");
		
	}

	
	@Bean(name="topicBn",initMethod = "init",destroyMethod = "destroy")
//	@Scope(value ="SCOPE_PROTOTYPE" )
	
	public TopicBean TopicBean() {
		return new TopicBean();
	}
}

