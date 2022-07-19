package com.telecom;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.telecom.model.Device;
import com.telecom.model.Plan;
import com.telecom.model.User;
import com.telecom.repository.DeviceRepository;
import com.telecom.repository.PlanRepository;
import com.telecom.repository.UserRepository;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	CommandLineRunner runPlans(PlanRepository planRepo) {
		return args -> {
			planRepo.save(new Plan(null, "Plan number 1", 3, 100.00));
			planRepo.save(new Plan(null, "Plan number 2", 20, 300.00));
			planRepo.save(new Plan(null, "Plan number 3", 15, 150.00));
			planRepo.save(new Plan(null, "Plan number 4", 5, 500.00));
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

	@Bean
	CommandLineRunner runUsers(UserRepository userRepo) {
		return args -> {
			userRepo.save(new User(null, "Jordan", "Lang", "jordanlang@comcast.net", "password1"));
			userRepo.save(new User(null, "Kevin", "Opoku-Agyemang", "Kevin@gmail.com", "password2"));
			userRepo.save(new User(null, "firstName3", "LastName3", "someEmail@gmail.com", "password3"));
			userRepo.save(new User(null, "firstName4", "LastName4", "someOtherEmail@gmail.com", "password4"));

		};
	}

}
