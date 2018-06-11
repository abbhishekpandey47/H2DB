package com.demo.H2;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.H2.DB.StudentDB;
import com.demo.H2.format.Student;

@SpringBootApplication
public class H2DbApp  implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentDB repository;
	
	public static void main(String[] args) {
		SpringApplication.run(H2DbApp.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		logger.info("Student id 10001 -> {}", repository.findOne(10001L));
		
		logger.info("Student Count -> {}", repository.count());
		
		logger.info("Student Get One -> {}", repository.getOne(10003L));
		
		logger.info("All users -> {}", repository.findAll());

		logger.info("Inserting -> {}", repository.save(new Student("John", "J1234657")));

		logger.info("Update 10001 -> {}", repository.save(new Student(10001L, "Name-Updated", "New-Passport")));

		repository.delete(10002L);

		logger.info("All users -> {}", repository.findAll());
	}
}

