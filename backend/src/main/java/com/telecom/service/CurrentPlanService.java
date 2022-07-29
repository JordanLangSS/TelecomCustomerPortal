package com.telecom.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.telecom.model.CurrentPlan;
import com.telecom.repository.CurrentPlanRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j // log to see what is happening
@Service
@Transactional
public class CurrentPlanService {

    @Autowired
    private CurrentPlanRepository currentPlanRepository;

    public CurrentPlan addPlan(CurrentPlan plan) {
        log.info("Saving new current plan: {}", plan.getPlanName());
        return currentPlanRepository.save(plan);
    }

    public List<CurrentPlan> findAllPlans() {
        log.info("Getting all current plans");
        return currentPlanRepository.findAll();
    }

    public CurrentPlan updatePlan(CurrentPlan plan) {
        log.info("Updating current plan: {}", plan.getPlanName());
        return currentPlanRepository.save(plan);
    }

    public void deletePlan(Long id) {
        log.info("Deleting current plan Id: {}", id);
        currentPlanRepository.deletePlanById(id);
    }

    public CurrentPlan findPlanById(Long id) {
        log.info("Getting current plan Id: {}", id);
        return currentPlanRepository.findPlanById(id)
                .orElseThrow(() -> new PlanNotFoundException("Plan with id" + id + " was not found"));
    }

    public List<CurrentPlan> findUserCurrentPlansById(Long id) {
        log.info("Getting current plans for user Id: {}", id);
        return currentPlanRepository.findUserCurrentPlansById(id);
    }

}
