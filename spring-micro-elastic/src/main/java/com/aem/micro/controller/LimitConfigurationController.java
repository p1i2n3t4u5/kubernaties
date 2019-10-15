package com.aem.micro.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aem.micro.bean.LimitConfiguration;
import com.aem.micro.config.Configuration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitConfigurationController {

	@Autowired
	private Configuration configuration;
	
	@GetMapping("/")
	public String test() {
      return "spring-micro-elastic working";
	}
	
	@GetMapping("/get")
	public String get() throws UnknownHostException {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Host: ")
            .append(InetAddress.getLocalHost()
                .getHostName())
            .append("<br/>");
        stringBuilder.append("IP: ")
            .append(InetAddress.getLocalHost()
                .getHostAddress())
            .append("<br/>");
        stringBuilder.append("Type: ")
            .append("Travel Agency")
            .append("<br/>");
        return stringBuilder.toString();
    }

	@GetMapping("/limits")
	public LimitConfiguration retriveLimitsFromConfiguration() {
		return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
	}
	
	@GetMapping("/fault-taulorent-limits")
	@HystrixCommand(fallbackMethod="fallbackRetriveConfiguration")
	public LimitConfiguration retriveConfiguration() {
		throw new RuntimeException();
	}
	
	public LimitConfiguration fallbackRetriveConfiguration() {
		return new LimitConfiguration(4444, 44);
	}

}
