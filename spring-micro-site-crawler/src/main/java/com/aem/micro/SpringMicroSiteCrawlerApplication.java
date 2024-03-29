package com.aem.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import brave.sampler.Sampler;

@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients("com.aem.micro.controller")
@EnableCircuitBreaker
@EnableScheduling
@SpringBootApplication
public class SpringMicroSiteCrawlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroSiteCrawlerApplication.class, args);
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
