package com.alucard;

import com.alucard.domain.Journal;
import com.alucard.repository.JournalRepository;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JournalApplication {

	@Bean // InitializingBean is always executed when the app runs
  InitializingBean saveData(JournalRepository journalRepository) {
	  return () -> {
      journalRepository.save(new Journal("Learn about the Spring Framework",
              "01/04/2017",
              "I will learn info on the Spring Framework to create Java Web Applications"));
      journalRepository.save(new Journal("Learn iOS dev",
              "20/5/2017",
              "Learn the basics of iOS app development using Swift"));
      journalRepository.save(new Journal("Learn TDD for Android",
              "05/10/2017",
              "Learn to do test driven development in Android"));
    };
  }


	public static void main(String[] args) {
		SpringApplication.run(JournalApplication.class, args);
	}
}
