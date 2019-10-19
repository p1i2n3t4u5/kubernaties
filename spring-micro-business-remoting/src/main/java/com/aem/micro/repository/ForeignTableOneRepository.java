package com.aem.micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aem.micro.entity.ForeignTable1;

@Repository
public interface ForeignTableOneRepository extends JpaRepository<ForeignTable1, Long> {

}
