package com.telecom.service;

//import java.util.Collection;
import java.util.List;

import com.telecom.model.PhonePlan;

public interface PlanService {
	// define different functionalities/features for the app to have
	PhonePlan create(PhonePlan phonePlan);

	List<PhonePlan> list(int limit);

	PhonePlan get(int id);

	PhonePlan update(PhonePlan phonePlan);

	Boolean delete(int id);

}
