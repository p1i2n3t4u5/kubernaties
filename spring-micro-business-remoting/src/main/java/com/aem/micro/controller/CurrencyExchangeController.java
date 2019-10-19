package com.aem.micro.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aem.micro.bean.CurrencyConversionBean;
import com.aem.micro.entity.ExchangeValue;
import com.aem.micro.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {

	Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

	@Autowired
	private Environment environment;

	@Autowired
	private ExchangeValueRepository exchangeValueRepository;

	@GetMapping("/")
	public String test() {
		return "spring-micro-business-remoting working";
	}

	@GetMapping("/get")
	public String get() throws UnknownHostException {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Host: ").append(InetAddress.getLocalHost().getHostName()).append("<br/>");
		stringBuilder.append("IP: ").append(InetAddress.getLocalHost().getHostAddress()).append("<br/>");
		stringBuilder.append("Type: ").append("Spring-micro-business-remoting").append("<br/>");
		return stringBuilder.toString();
	}

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	private ResponseEntity<CurrencyConversionBean> retrieveExchangeValue(@PathVariable("from") String from,
			@PathVariable("to") String to) {
		logger.info("from:{} to:{}", from, to);
		ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);

		CurrencyConversionBean conversionBean = new CurrencyConversionBean();
		conversionBean.setConversionMultiple(exchangeValue.getConversionMultiple());
		conversionBean.setFrom(exchangeValue.getFrom());
		conversionBean.setTo(exchangeValue.getTo());
		conversionBean.setId(exchangeValue.getId());
		conversionBean.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		try {
			conversionBean.setHostName(InetAddress.getLocalHost().getHostName());
			conversionBean.setHostAddress(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<CurrencyConversionBean>(conversionBean, HttpStatus.OK);
	}
}
