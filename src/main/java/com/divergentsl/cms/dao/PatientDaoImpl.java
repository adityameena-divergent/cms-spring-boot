package com.divergentsl.cms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.divergentsl.cms.entity.Patient;

@Repository
public class PatientDaoImpl implements BaseDAO<Patient> {

	@PersistenceContext
	EntityManager entityManager;
	
	public void insert(Patient patient) {
		
		entityManager.getTransaction().begin();
		entityManager.persist(patient);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public Patient find(int id) {
		
		Patient patient = entityManager.find(Patient.class, id);
		entityManager.close();
		return patient;
		
	}

	public List<Patient> findAll() {
		
		CriteriaQuery<Patient> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Patient.class);
		Root<Patient> root = criteriaQuery.from(Patient.class);
		
		List<Patient> patients = entityManager.createQuery(criteriaQuery).getResultList();
		entityManager.close();
		return patients;
		
	}

	public void remove(int patientId) {
//		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		entityManager.getTransaction().begin();
		
		Patient patient = entityManager.find(Patient.class, patientId);
		if (patient != null)
			entityManager.remove(patient);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void update(Patient data) {

//		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		entityManager.getTransaction().begin();
		
		Patient patient = entityManager.find(Patient.class, data.getId());
		
		if (patient != null) {
			patient.setName(data.getName());
			patient.setGender(data.getGender());
			patient.setAge(data.getAge());
			patient.setWeight(data.getWeight());
			patient.setContactNumber(data.getContactNumber());
			patient.setAddress(data.getAddress());
		}
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
