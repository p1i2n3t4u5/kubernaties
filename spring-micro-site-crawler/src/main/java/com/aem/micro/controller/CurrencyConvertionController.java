package com.aem.micro.controller;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConvertionController {
	Logger logger = LoggerFactory.getLogger(CurrencyConvertionController.class);

	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@Autowired
	private DiscoveryClient discoveryClient;

	// below approach is a hardcoded way of accessing microservices

	@GetMapping("/")
	public String test() {
		logger.info("discoveryClient.getServices():"+discoveryClient.getServices());
	
		return "spring-micro-site-crawler working"+discoveryClient.getServices();
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
	

	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("quantity") BigDecimal quantity) {

		CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);

		logger.info("{}", response);

		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}

}
