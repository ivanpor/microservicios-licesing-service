package com.testing.microservices.licesingservice.model;

import java.io.Serializable;

import com.testing.microservices.licesingservice.model.License.LicenseBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@SuppressWarnings(value={"all"})
@Getter
@AllArgsConstructor
@Builder
public class Organization implements Serializable {
	
	private static final long serialVersionUID = -190683117003935681L;
	
	private String organizationId;
	private String description;
}