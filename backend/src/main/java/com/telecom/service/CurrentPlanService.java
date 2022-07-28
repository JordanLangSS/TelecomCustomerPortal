package com.telecom.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.model.CurrentPlan;
import com.telecom.repository.CurrentPlanRepository;

@Service
@Transactional
public class CurrentPlanService {

    @Autowired
    private CurrentPlanRepository currentPlanRepository;

    public CurrentPlan addPlan(CurrentPlan plan) {
        return currentPlanRepository.save(plan);
    }

    public List<CurrentPlan> findAllPlans() {
        return currentPlanRepository.findAll();
    }

    public CurrentPlan updatePlan(CurrentPlan plan) {
        return currentPlanRepository.save(plan);
    }

    public void deletePlan(Long id) {
        currentPlanRepository.deletePlanById(id);
    }

    public CurrentPlan findPlanById(Long id) {
        return currentPlanRepository.findPlanById(id)
                .orElseThrow(() -> new PlanNotFoundException("Plan with id" + id + " was not found"));
    }

    public List<CurrentPlan> findUserCurrentPlansById(Long id) {
        return currentPlanRepository.findUserCurrentPlansById(id);
    }

}
