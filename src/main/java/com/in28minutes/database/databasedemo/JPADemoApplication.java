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
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;

@SpringBootApplication
public class JPADemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(JPADemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		logger.info("All Users -> {}",dao.findAll());
		logger.info("User ID 10001 -> {}",repository.findById(1001));
		logger.info("Inserting 1004 record -> {}",
				repository.insert(new Person(1004,"Tara", "Berlin",new Date() ) ));
		logger.info("Updating 1003 record -> {}",
				repository.update(new Person(1002,"Monika", "Sagar",new Date() ) ));
		repository.deleteById(1002);
		
	}

}
