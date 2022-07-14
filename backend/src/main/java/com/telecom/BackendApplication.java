package com.telecom;

//just a test
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.telecom.model.PhonePlan;
import com.telecom.repository.PlanRepository;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	CommandLineRunner run(PlanRepository planRepo) {
		return args -> {
			planRepo.save(new PhonePlan(null, "Plan number 1", 3, 100.00));
			planRepo.save(new PhonePlan(null, "Plan number 2", 20, 300.00));
			planRepo.save(new PhonePlan(null, "Plan number 3", 15, 150.00));
			planRepo.save(new PhonePlan(null, "Plan number 4", 5, 500.00));
		};
	}

}
