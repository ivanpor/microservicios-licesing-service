package com.testing.microservices.licesingservice.clients;

import org.springframework.stereotype.Component;

import com.testing.microservices.licesingservice.model.Organization;

@Component
public class OrganizationClientFallBack implements OrganizationFeignClient {
	
	public Organization getOrganization(String organizationId) {
		return Organization.builder()
				.organizationId(organizationId)
				.description("Se ha producido un error al recuperar la info")
				.build();
	}

}
