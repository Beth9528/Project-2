package com.Project2.Project2;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Project2Application {
	private static void extracted(ConfigurableApplicationContext context) throws IOException {

		StudentController studentController = context.getBean(StudentController.class);
		System.out.println(" students "+ studentController.readStudent());
	}

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = SpringApplication.run(Project2Application.class, args);
		extracted(context);
	}

}
