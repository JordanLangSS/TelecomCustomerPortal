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

//import lombok.RequiredArgsConstructor;
import java.util.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.CREATED;
import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/plan")
@CrossOrigin(origins = "http://localhost:4200")
// @RequiredArgsConstructor // use this for planService dependency Injection
public class PlanController {

	// private final PlanServiceImpl planService;
	@Autowired
	private PlanService planService;

	@GetMapping("/all")
	public ResponseEntity<List<Plan>> getAllPlans() {
		List<Plan> plans = planService.findAllPlans();
		return new ResponseEntity<>(plans, HttpStatus.OK);

	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Plan> getEmployeeById(@PathVariable("id") Long id) {
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

	// @PostMapping("/save")
	// // Use valid to check if the new plan is up to validation standards (from
	// // model)
	// public ResponseEntity<Response> savePlans(@RequestBody @Valid PhonePlan plan)
	// {

	// return ResponseEntity.ok(
	// Response.builder()
	// .timeStamp(now())
	// .data(new HashMap<String, PhonePlan>() {
	// {
	// put("Plan", planService.create(plan));
	// }
	// })
	// // .data(Map.of("plans", planService.list(30)))
	// .message("Plan Created")
	// .status(CREATED)
	// .statusCode(CREATED.value())
	// .build());
	// }

	// @GetMapping("/get/{id}")
	// public ResponseEntity<Response> getPlan(@PathVariable("id") Long id) {

	// return ResponseEntity.ok(
	// Response.builder()
	// .timeStamp(now())
	// .data(new HashMap<String, PhonePlan>() {
	// {
	// put("Plan", planService.get(id));
	// }
	// })
	// // .data(Map.of("plans", planService.list(30)))
	// .message("Plan Retrieved")
	// .status(OK)
	// .statusCode(OK.value())
	// .build());
	// }

	// @DeleteMapping("/delete/{id}")
	// public ResponseEntity<Response> deletePlan(@PathVariable("id") Long id) {

	// return ResponseEntity.ok(
	// Response.builder()
	// .timeStamp(now())
	// .data(new HashMap<String, Boolean>() {
	// {
	// put("Deleted", planService.delete(id));
	// }
	// })
	// // .data(Map.of("plans", planService.list(30)))
	// .message("Plan Deleted")
	// .status(OK)
	// .statusCode(OK.value())
	// .build());
	// }

}

// ***INSTEAD OF DOING THE BELOW, CUT DOWN ON CODE USING THE .BUILDER() METHOD
// FROM LOMBOK!!!!***

// Response resp = new Response();

// resp.setTimeStamp(now());
// resp.setData(new HashMap<String, List<?>>() {
// {
// put("Plans", planService.list(30));
// }
// });

// resp.setMessage("Plans Retrieved");
// resp.setStatus(OK);
// resp.setStatusCode(OK.value());

// return resp;