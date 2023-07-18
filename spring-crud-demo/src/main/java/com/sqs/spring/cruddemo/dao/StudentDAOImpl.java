package com.sqs.spring.cruddemo.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sqs.spring.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    public StudentDAOImpl(EntityManager entityManager) {
	this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
	entityManager.persist(theStudent);
    }

}
