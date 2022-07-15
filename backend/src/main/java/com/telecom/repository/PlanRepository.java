package com.telecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.model.PhonePlan;

// class name and primary key type
@Repository
public interface PlanRepository extends JpaRepository<PhonePlan, Long> {

	// tell JPA to use a select with "findBY"
	PhonePlan findByPlanName(String planName);

}
