package com.ketul.loganalyser.validator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.ketul.loganalyser.model.Context;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LogAnalyserValidator {

	public void validateInput(Context context, String... args) {
		log.info("Validating the input...");

		validateArguments(args);
		validateFilePath(context, args[1]);
	}

	private void validateFilePath(Context context, String logFilePath) {
		log.info("Log file specified for LogAnalyserService: {}", logFilePath);
		context.setLogFilePath(logFilePath);

		try {
			File file = new ClassPathResource("samples/" + logFilePath).getFile();
			if (!file.exists()) {
				file = new ClassPathResource(logFilePath).getFile();
				if (!file.exists()) {
					file = new File(logFilePath);
				}
			}

			if (!file.exists())
				throw new FileNotFoundException("Unable to open the file " + logFilePath);
		} catch (IOException e) {
			log.error("!!! Unable to find the specified file '{}'", logFilePath);
		}
	}

	private void validateArguments(String[] args) {
		log.debug("Validating the program arguments...");
		if (args.length < 1) {
			throw new IllegalArgumentException("!!! Please specify the filepath to analyse.");
		}
	}
}
