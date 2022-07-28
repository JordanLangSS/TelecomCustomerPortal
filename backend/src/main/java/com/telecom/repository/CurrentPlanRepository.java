package com.telecom.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telecom.model.CurrentPlan;

@Repository
public interface CurrentPlanRepository extends JpaRepository<CurrentPlan, Long> {

    void deletePlanById(Long id);

    Optional<CurrentPlan> findPlanById(Long id);

    @Query(value = "select * from current_plan where user_id = :id", nativeQuery = true)
    List<CurrentPlan> findUserCurrentPlansById(Long id);

    // List<CurrentPlan> findPlanByUserId(Long userId);

}
