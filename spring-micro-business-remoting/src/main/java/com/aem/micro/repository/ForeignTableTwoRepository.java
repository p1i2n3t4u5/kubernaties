package com.aem.micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aem.micro.entity.ForeignTable2;

@Repository
public interface ForeignTableTwoRepository extends JpaRepository<ForeignTable2, Long> {

}
