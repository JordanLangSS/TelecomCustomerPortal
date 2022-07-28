package com.telecom.controller;

import java.util.List;

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

import com.telecom.model.CurrentPlan;
import com.telecom.service.CurrentPlanService;

@RestController
@RequestMapping("/currentplan")
@CrossOrigin(origins = "http://localhost:4200")
public class CurrentPlanController {

    @Autowired
    private CurrentPlanService currentPlanService;

    @GetMapping("/all")
    public ResponseEntity<List<CurrentPlan>> getAllPlans() {
        List<CurrentPlan> plans = currentPlanService.findAllPlans();
        return new ResponseEntity<>(plans, HttpStatus.OK);
    }

    // get user account phoneNumbers
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CurrentPlan>> findAllUserCurrentPlans(@PathVariable Long userId) {
        List<CurrentPlan> currentPlans = currentPlanService.findUserCurrentPlansById(userId);
        return new ResponseEntity<>(currentPlans, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CurrentPlan> getPlanById(@PathVariable("id") Long id) {
        CurrentPlan plan = currentPlanService.findPlanById(id);
        return new ResponseEntity<>(plan, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CurrentPlan> addPlan(@RequestBody CurrentPlan plan) {
        CurrentPlan newPlan = currentPlanService.addPlan(plan);
        return new ResponseEntity<>(newPlan, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CurrentPlan> updatePlan(@RequestBody CurrentPlan plan) {
        CurrentPlan updatePlan = currentPlanService.updatePlan(plan);
        return new ResponseEntity<>(updatePlan, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePlan(@PathVariable("id") Long id) {
        currentPlanService.deletePlan(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
