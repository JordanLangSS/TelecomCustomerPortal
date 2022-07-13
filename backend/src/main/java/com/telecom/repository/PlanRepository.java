package com.telecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.telecom.model.PhonePlan;

// class name and primary key type

public interface PlanRepository extends JpaRepository<PhonePlan, Integer>{
	
	// tell JPA to use a select with "findBY"
	PhonePlan findByPlanName(String planName);

}
