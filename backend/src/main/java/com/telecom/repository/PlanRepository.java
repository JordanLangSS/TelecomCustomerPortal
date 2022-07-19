package com.telecom.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.model.Plan;

// class name and primary key type
@Repository
@Transactional
public interface PlanRepository extends JpaRepository<Plan, Long> {

	void deletePlanById(Long id);

	Optional<Plan> findPlanById(Long id);

}
