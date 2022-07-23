package com.telecom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.model.CurrentPlan;

@Repository
public interface CurrentPlanRepository extends JpaRepository<CurrentPlan, Long> {

    void deletePlanById(Long id);

    Optional<CurrentPlan> findPlanById(Long id);

    // List<CurrentPlan> findPlanByUserId(Long userId);

}
