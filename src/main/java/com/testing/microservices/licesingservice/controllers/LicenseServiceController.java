package com.testing.microservices.licesingservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.testing.microservices.licesingservice.clients.OrganizationFeignClient;
import com.testing.microservices.licesingservice.config.ConfigComponent;
import com.testing.microservices.licesingservice.model.License;
import com.testing.microservices.licesingservice.model.Organization;

@RequestMapping(value="v1/organizations/{organizationId}/licenses")
@RestController
public class LicenseServiceController {
	
	@Autowired
	private OrganizationFeignClient organizationFeignClient;
	
	@Autowired
	private ConfigComponent configComponent;
	
	@RequestMapping(value="/{licenseId}", method=RequestMethod.GET)
	public License getLicense(@PathVariable("organizationId") String organizationId, @PathVariable("licenseId") String licenseId) {
		
		Organization organization = organizationFeignClient.getOrganization(organizationId);
		
		return License.builder()
				.id(licenseId)
				.organizationId(organization.getOrganizationId())
				.productName(configComponent.getProductName())
				.licenseType(organization.getDescription()).build();

	}
}
