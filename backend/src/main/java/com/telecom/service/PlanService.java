package com.telecom.service;

import java.util.Collection;

import com.telecom.model.PhonePlan;

public interface PlanService {
	//define different functionalities/features for the app to have
	PhonePlan create(PhonePlan phonePlan);
	Collection<PhonePlan> list(int limit);
	PhonePlan get(int id);
	PhonePlan update(PhonePlan phonePlan);
	Boolean delete(int id);

}
