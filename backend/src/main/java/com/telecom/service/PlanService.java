package com.telecom.service;

//import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.model.Plan;
import com.telecom.repository.PlanRepository;

import lombok.extern.slf4j.Slf4j;
import static java.lang.Boolean.TRUE;

@Slf4j // log to see what is happening
@Service
public class PlanService {
	// private final PlanRepository planRepository;

	@Autowired
	private PlanRepository planRepository;

	public Plan addPlan(Plan plan) {
		log.info("Saving new phone plan: {}", plan.getPlanName());
		return planRepository.save(plan);
	}

	public List<Plan> findAllPlans() {
		log.info("Getting all Phone Plans");

		return planRepository.findAll();
	}

	public Plan updatePlan(Plan plan) {
		log.info("Updating phone plan: {}", plan.getPlanName());
		// ****if the Id does not exist, it will just create it!!!****
		return planRepository.save(plan);
	}

	public void deletePlan(Long id) {
		log.info("Deleting phone plan Id: {}", id);
		planRepository.deletePlanById(id);
	}

	public Plan findPlanById(Long id) {
		log.info("Getting Phone Plan Id: {}", id);
		// You have to use .get to actually return the phonePlan it finds by that id
		return planRepository.findPlanById(id)
				.orElseThrow(() -> new PlanNotFoundException("Plan with id" + id + " was not found"));
	}

}
