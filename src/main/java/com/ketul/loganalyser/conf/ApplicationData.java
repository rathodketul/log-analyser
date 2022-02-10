package com.ketul.loganalyser.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties("app.log-analyser")
public class ApplicationData {
	private int alertThresholdMs;
	private int tableRowsWriteoffCount;
}
