package com.in28minutes.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDao dao;
	
	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All Users -> {}",dao.findAll());
		logger.info("User ID 10001 -> {}",dao.findById(1001));
		logger.info("Number of rows deleted -> {}",dao.deleteById(1002));
		logger.info("Inserting 1004 record -> {}",
				dao.insert(new Person(1004,"Tara", "Berlin",new Date() ) ));
		logger.info("Updating 1003 record -> {}",
				dao.update(new Person(1004,"Saket", "Manipur",new Date() ) ));
	}

}
