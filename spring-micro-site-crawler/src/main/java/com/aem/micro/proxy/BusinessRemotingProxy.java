package com.aem.micro.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.aem.micro.RibbonConfiguration;
import com.aem.micro.bean.CurrencyConversionBean;

@FeignClient(name = "business-remoting-service",fallback = BusinessRemotingProxy.BusinessRemotingProxyFallback.class)
@RibbonClient(name = "business-remoting-service", configuration = RibbonConfiguration.class)
public interface BusinessRemotingProxy {

	public class BusinessRemotingProxyFallback implements BusinessRemotingProxy{

		@Override
		public ResponseEntity<CurrencyConversionBean> retrieveExchangeValue(String from, String to) {
			CurrencyConversionBean conversionBean= new CurrencyConversionBean();
			conversionBean.setMessage("Response From Fallback method");
			return new ResponseEntity<CurrencyConversionBean>(conversionBean, HttpStatus.OK);
		}

	}

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ResponseEntity<CurrencyConversionBean> retrieveExchangeValue(@PathVariable("from") String from,
			@PathVariable("to") String to);
}
