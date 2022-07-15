package com.telecom;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.telecom.model.Device;
import com.telecom.model.PhonePlan;
import com.telecom.repository.DeviceRepository;
import com.telecom.repository.PlanRepository;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	CommandLineRunner runPlans(PlanRepository planRepo) {
		return args -> {
			planRepo.save(new PhonePlan(null, "Plan number 1", 3, 100.00));
			planRepo.save(new PhonePlan(null, "Plan number 2", 20, 300.00));
			planRepo.save(new PhonePlan(null, "Plan number 3", 15, 150.00));
			planRepo.save(new PhonePlan(null, "Plan number 4", 5, 500.00));
		};
	}

	@Bean
	CommandLineRunner runDevices(DeviceRepository deviceRepo) {
		return args -> {
			deviceRepo.save(new Device(null, "make1", "model1"));
			deviceRepo.save(new Device(null, "make2", "model2"));
			deviceRepo.save(new Device(null, "make3", "model3"));
			deviceRepo.save(new Device(null, "make4", "model4"));

		};
	}

}
