package com.ketul.loganalyser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ketul.loganalyser.manager.LogAnalyserManager;
import com.ketul.loganalyser.model.Context;
import com.ketul.loganalyser.validator.LogAnalyserValidator;

@Service
public class LogAnalyserService {

	@Autowired
	private LogAnalyserValidator validator;

	@Autowired
	private LogAnalyserManager manager;

	public void execute(String... args) {
		Context context = Context.getInstance();
		validator.validateInput(context, args);
		manager.parseAndPersistEvents(context);
	}

}
