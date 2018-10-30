package com.testing.microservices.licesingservice.clients;

import org.springframework.stereotype.Component;

import com.testing.microservices.licesingservice.model.Organization;

import feign.hystrix.FallbackFactory;

@Component
public class OrganizationClientFallbackFactory implements FallbackFactory<OrganizationFeignClient> {

	@Override
	public OrganizationFeignClient create(final Throwable arg0) {
		return new OrganizationFeignClient() {
			
			@Override
			public Organization getOrganization(String organizationId) {
				return Organization.builder()
					.organizationId(organizationId)
					.description(arg0.getMessage())
					.build();
			}
		};
	}
}
