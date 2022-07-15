package com.telecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.model.PhonePlan;
import com.telecom.model.Response;
import com.telecom.service.implementation.PlanServiceImpl;

//import lombok.RequiredArgsConstructor;
import java.util.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.CREATED;
import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/plan")
// @RequiredArgsConstructor // use this for planService dependency Injection
public class PlanController {

	// private final PlanServiceImpl planService;

	@Autowired
	private PlanServiceImpl planService;

	@GetMapping("/list")
	public ResponseEntity<Response> getPlans() {

		return ResponseEntity.ok(
				Response.builder()
						.timeStamp(now())
						.data(new HashMap<String, List<?>>() {
							{
								put("Plans", planService.list(30));
							}
						})
						// .data(Map.of("plans", planService.list(30)))
						.message("Plans Retrieved")
						.status(OK)
						.statusCode(OK.value())
						.build());

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

	}

	@PostMapping("/save")
	// Use valid to check if the new plan is up to validation standards (from
	// model)
	public ResponseEntity<Response> savePlans(@RequestBody @Valid PhonePlan plan) {

		return ResponseEntity.ok(
				Response.builder()
						.timeStamp(now())
						.data(new HashMap<String, PhonePlan>() {
							{
								put("Plan", planService.create(plan));
							}
						})
						// .data(Map.of("plans", planService.list(30)))
						.message("Plan Created")
						.status(CREATED)
						.statusCode(CREATED.value())
						.build());
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Response> getPlan(@PathVariable("id") Long id) {

		return ResponseEntity.ok(
				Response.builder()
						.timeStamp(now())
						.data(new HashMap<String, PhonePlan>() {
							{
								put("Plan", planService.get(id));
							}
						})
						// .data(Map.of("plans", planService.list(30)))
						.message("Plan Retrieved")
						.status(OK)
						.statusCode(OK.value())
						.build());
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> deletePlan(@PathVariable("id") Long id) {

		return ResponseEntity.ok(
				Response.builder()
						.timeStamp(now())
						.data(new HashMap<String, Boolean>() {
							{
								put("Deleted", planService.delete(id));
							}
						})
						// .data(Map.of("plans", planService.list(30)))
						.message("Plan Deleted")
						.status(OK)
						.statusCode(OK.value())
						.build());
	}

}
