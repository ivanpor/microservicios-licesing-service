package com.testing.microservices.licesingservice.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@SuppressWarnings(value={"all"})
@Getter
@AllArgsConstructor
@Builder
public class License implements Serializable {
	
	private static final long serialVersionUID = 57721214664855608L;
	
	private String id;
	private String organizationId;
	private String productName;
	private String licenseType;

}
