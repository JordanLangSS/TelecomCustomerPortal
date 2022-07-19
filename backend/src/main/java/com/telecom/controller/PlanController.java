package com.telecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.model.Plan;
import com.telecom.service.PlanService;

import java.util.*;

@RestController
@RequestMapping("/plan")
@CrossOrigin(origins = "http://localhost:4200")
public class PlanController {

	@Autowired
	private PlanService planService;

	@GetMapping("/all")
	public ResponseEntity<List<Plan>> getAllPlans() {
		List<Plan> plans = planService.findAllPlans();
		return new ResponseEntity<>(plans, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Plan> getPlanById(@PathVariable("id") Long id) {
		Plan plan = planService.findPlanById(id);
		return new ResponseEntity<>(plan, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Plan> addPlan(@RequestBody Plan plan) {
		Plan newPlan = planService.addPlan(plan);
		return new ResponseEntity<>(newPlan, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Plan> updatePlan(@RequestBody Plan plan) {
		Plan updatePlan = planService.updatePlan(plan);
		return new ResponseEntity<>(updatePlan, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePlan(@PathVariable("id") Long id) {
		planService.deletePlan(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
