package com.aem.micro;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aem.micro.controller.ExchangeValue;
import com.aem.micro.controller.ForeignTable1;
import com.aem.micro.controller.ForeignTable2;
import com.aem.micro.repository.ExchangeValueRepository;
import com.aem.micro.repository.ForeignTableOneRepository;
import com.aem.micro.repository.ForeignTableTwoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMicroBusinessRemotingApplicationTests {

	@Autowired
	ExchangeValueRepository repository;

	@Autowired
	ForeignTableOneRepository foreignTableOneRepository;

	@Autowired
	ForeignTableTwoRepository foreignTableTwoRepository;


	@Test
	public void contextLoads() {

		List<ExchangeValue> exchangeValues = repository.findAll();
		System.err.println("findAll:"+exchangeValues);
		System.err.println("test:"+repository.test(102l));

		HashSet<String> xyz = new HashSet<>();
		xyz.add("x");
		xyz.add("y");
		xyz.add("z");
		HashSet<String> pqr = new HashSet<>();
		pqr.add("xx");
		pqr.add("yy");
		pqr.add("zz");
		
		List<ExchangeValue> exchangeValues2 = repository.test2(xyz, pqr);
		System.err.println("exchangeValues2:"+exchangeValues2);

	}

	@Test
	public void contextLoads2() {

		try {
			Optional<ExchangeValue> optional = repository.findById(101l);
			if (optional.isPresent()) {
				System.err.println("-----------------------------------");
				System.err.println(optional.get());

				Optional<ForeignTable1> optional2 = foreignTableOneRepository.findById(11l);
				System.err.println(optional2.isPresent()?optional2.get():null);

				Optional<ForeignTable2> optional3 = foreignTableTwoRepository.findById(22l);
				System.err.println(optional3.isPresent()?optional3.get():null);

				System.err.println("-----------------------------------");
			} else {
				System.err.println("no data");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@Test
	public void joinfetch() {

		try {
			Optional<ExchangeValue> optional = repository.joinFetch(102l);
			if (optional.isPresent()) {
				System.err.println("Join fetch:"+optional.get());
				System.err.println("Join fetch:"+optional.get().getForeignOnes());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
