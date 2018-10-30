package com.testing.microservices.licesingservice.clients;

import com.testing.microservices.licesingservice.model.Organization;

public interface OrganizationClient {

	public Organization getOrganization(String organizationId);
}
