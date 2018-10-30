package com.testing.microservices.licesingservice.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.testing.microservices.licesingservice.model.Organization;

@FeignClient(value="organizationservice",/*fallback=OrganizationClientFallBack.class*/fallbackFactory=OrganizationClientFallbackFactory.class)
public interface OrganizationFeignClient extends OrganizationClient {
	
	@Override
	@HystrixCommand(
		threadPoolKey="getOrganizationThreadPool",
		threadPoolProperties= {
			@HystrixProperty(name="coreSize",value="30"),
			@HystrixProperty(name="maxQueueSize",value="10")
		
		},
		commandProperties= {
			@HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),
			@HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="75"),
			@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="7000"),
			@HystrixProperty(name="metrics.rollingStats.TimeInMilliseconds",value="15000"),
			@HystrixProperty(name="metrics.rollingStats.numBuckets",value="5")
		}
	)
	@RequestMapping(value="/v1/organizations/{organizationId}", method=RequestMethod.GET, consumes="application/json")
	public Organization getOrganization(@PathVariable("organizationId") String organizationId);

}
