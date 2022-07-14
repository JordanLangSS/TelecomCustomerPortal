package com.telecom.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.model.PhonePlan;
import com.telecom.model.Response;
import com.telecom.service.implementation.PlanServiceImpl;

import lombok.RequiredArgsConstructor;
import java.util.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.CREATED;
import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/plan")
@RequiredArgsConstructor // use this for planService dependency Injection
public class PlanResource {

	private final PlanServiceImpl planService;

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
	}

	@PostMapping("/save")
	// Use validation to check if the plan name is not empty on entry
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

}
