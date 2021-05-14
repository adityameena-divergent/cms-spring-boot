package com.divergentsl.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.divergentsl.cms.entity.Doctor;

public interface DoctorDao extends JpaRepository<Doctor, Integer> {

}
