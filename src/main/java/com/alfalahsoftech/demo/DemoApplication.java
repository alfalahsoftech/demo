package com.alfalahsoftech.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//public class DemoApplication{
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private ApplicationContext appContext;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@RequestMapping(value = "/")
//	@GetMapping(consumes = Media)
	public String hello() {
		System.out.println("this::"+this);
		return "Default valued";
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println(appContext.getBean("topicBn"));
		String txt = "aaa"; Assert.hasText(txt,"Must not be null");
		Assert.isTrue(isPalandrome("madam"), "Its true ");
		Arrays.asList(appContext.getBeanDefinitionNames()).stream().sorted().forEach(System.out::println);


	}

	public boolean isPalandrome(String str){
		//str  = "madam";
		// char char []= str.chars();
		int l = str.length();
		StringBuilder sb = new StringBuilder();
		for( int i =l-1; i>=0 ; i--){
			sb.append(str.charAt(i));
		}
		return str.equals(sb.toString());

	}

}

//https://mkyong.com/spring-boot/how-to-display-all-beans-loaded-by-spring-boot/
/*
 * 2. CommandLineRunner as Bean
Just different ways to print the loaded beans.

Application.java

package com.mkyong;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner run(ApplicationContext appContext) {
        return args -> {

            String[] beans = appContext.getBeanDefinitionNames();
            Arrays.stream(beans).sorted().forEach(System.out::println);

        };
    }

}

 */

class Bean{


}
