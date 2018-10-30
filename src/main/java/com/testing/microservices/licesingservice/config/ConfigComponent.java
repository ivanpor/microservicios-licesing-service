package com.testing.microservices.licesingservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class ConfigComponent {
	
	@Value("${example.property}")
	private String productName;
	
	public String getProductName() {
		return productName;
	}

}
