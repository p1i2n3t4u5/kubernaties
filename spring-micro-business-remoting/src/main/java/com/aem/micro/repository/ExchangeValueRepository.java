package com.aem.micro.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aem.micro.entity.ExchangeValue;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

	ExchangeValue findByFromAndTo(String from, String to);

	@Query("Select p From ExchangeValue p where p.id=:id")
	ExchangeValue test(@Param("id") Long id);

	@Query("Select distinct p From ExchangeValue p join p.foreignOnes f1 join p.foreignTwos f2 where f1.name in :xyz  OR f2.name in :pqr ")
	List<ExchangeValue> test2(@Param("xyz") Set<String> xyz, @Param("pqr") Set<String> pqr);

	@Query("Select  p From ExchangeValue p JOIN FETCH p.foreignOnes f1 Where p.id=:id ")
	Optional<ExchangeValue> joinFetch(@Param("id") Long id);

}
