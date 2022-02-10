package com.ketul.loganalyser;

import java.time.Duration;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ketul.loganalyser.service.LogAnalyserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class LogAnalyser implements CommandLineRunner {

	@Autowired
	private LogAnalyserService service;

	public static void main(String... args) {
		SpringApplication app = new SpringApplication(LogAnalyser.class);
		app.run(args);
	}

	@Override
	public void run(String... args) {
		Instant start = Instant.now();
		service.execute(args);
		Instant end = Instant.now();
		log.info("Total time: {}ms", Duration.between(start, end).toMillis());
	}
}
