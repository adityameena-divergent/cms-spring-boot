package com.divergentsl.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.divergentsl.cms.entity.Appointment;

public interface AppointmentDao extends JpaRepository<Appointment, Integer> {

}
