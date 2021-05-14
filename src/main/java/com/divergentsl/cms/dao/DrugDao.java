package com.divergentsl.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.divergentsl.cms.entity.Drug;

public interface DrugDao extends JpaRepository<Drug, Integer> {

}
