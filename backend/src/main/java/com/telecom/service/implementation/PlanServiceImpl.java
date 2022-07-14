package com.telecom.service.implementation;

//import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.telecom.model.PhonePlan;
import com.telecom.repository.PlanRepository;
import com.telecom.service.PlanService;

//import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import static java.lang.Boolean.TRUE;

//@RequiredArgsConstructor // use this for planService dependency Injection
@Service
@Transactional
@Slf4j // log to see what is happening
public class PlanServiceImpl implements PlanService {

	// private final PlanRepository planRepository;

	@Autowired
	private PlanRepository planRepository;

	@Override
	public PhonePlan create(PhonePlan phonePlan) {
		log.info("Saving new phone plan: {}", phonePlan.getPlanName());
		return planRepository.save(phonePlan);
	}

	@Override
	public List<PhonePlan> list(int limit) {
		log.info("Getting all Phone Plans");

		// Return a list (instead of a full page)to limit the amount per page
		// have to cast to a list because findAll would return a "page"
		return planRepository.findAll(PageRequest.of(0, limit)).toList();
	}

	@Override
	public PhonePlan get(int id) {
		log.info("Getting Phone Plan Id: {}", id);
		// You have to use .get to actually return the phonePlan it finds by that id
		return planRepository.findById(id).get();
	}

	@Override
	public PhonePlan update(PhonePlan phonePlan) {
		log.info("Updating phone plan: {}", phonePlan.getPlanName());
		// ****if the Id does not exist, it will just create it!!!****
		return planRepository.save(phonePlan);
	}

	@Override
	public Boolean delete(int id) {
		log.info("Deleting phone plan Id: {}", id);
		planRepository.deleteById(id);
		return TRUE;
	}

}
