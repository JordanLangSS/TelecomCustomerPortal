package com.telecom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.telecom.model.CurrentPlan;
import com.telecom.model.Device;
import com.telecom.model.Plan;
import com.telecom.model.User;
import com.telecom.model.PhoneNumbers;
import com.telecom.repository.CurrentPlanRepository;
import com.telecom.repository.DeviceRepository;
import com.telecom.repository.PhoneNumbersRepository;
import com.telecom.repository.PlanRepository;
import com.telecom.repository.UserRepository;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	// @Autowired
	// PhoneNumbersRepository phoneNumbersRepository;

	// @Autowired
	// DeviceRepository deviceRepository;

	// @Override
	// public void run(String... args) throws Exception {
	// Device device = new Device();
	// device.setMake("samsung");
	// device.setModel("Galaxy");

	// PhoneNumbers phoneNumber = new PhoneNumbers();
	// phoneNumber.setPhoneNumber("2013334444");

	// device.setPhoneNumbers(phoneNumber);
	// phoneNumber.setDevice(device);

	// // phoneNumbersRepository.save(phoneNumber);
	// deviceRepository.save(device);
	// }

	// Use command line runner to execute the queries AFTER Spring Boot has started
	// Drops all the tables and re-creates them each time due to "ddl-auto: create"
	// in the application.yml file
	@Bean
	CommandLineRunner runPlans(PlanRepository planRepo) {
		return args -> {
			planRepo.save(new Plan(null, "Plan number 1", 3, 100.00));
			planRepo.save(new Plan(null, "Plan number 2", 20, 300.00));
			planRepo.save(new Plan(null, "Plan number 3", 15, 150.00));
		};
	}

	// @Bean
	// CommandLineRunner runDevices(DeviceRepository deviceRepo) {
	// return args -> {
	// deviceRepo.save(new Device(null, "make1", "model1", ""));
	// deviceRepo.save(new Device(null, "make2", "model2", ""));
	// deviceRepo.save(new Device(null, "make3", "model3", ""));
	// deviceRepo.save(new Device(null, "make4", "model4", ""));

	// };
	// }

	@Bean
	CommandLineRunner runDevices(DeviceRepository deviceRepository, PhoneNumbersRepository phoneNumbersRepository) {
		return args -> {
			Device device = new Device();
			device.setMake("samsung");
			device.setModel("Galaxy");

			PhoneNumbers phoneNumber = new PhoneNumbers();
			phoneNumber.setPhoneNumber("2013334444");

			device.setPhoneNumbers(phoneNumber);
			phoneNumber.setDevice(device);

			// phoneNumbersRepository.save(phoneNumber);
			deviceRepository.save(device);

		};
	}

	@Bean
	CommandLineRunner runUsers(UserRepository userRepo) {
		return args -> {
			userRepo.save(new User(null, "JordanL", "password1"));
			userRepo.save(new User(null, "KevinO", "password2"));
			userRepo.save(new User(null, "firstName3", "password3"));
			userRepo.save(new User(null, "firstName4", "password4"));
		};
	}

	@Bean
	CommandLineRunner runCurrentPlans(CurrentPlanRepository currPlanRepo) {
		return args -> {
			currPlanRepo.save(new CurrentPlan(null, 1, 1));

		};
	}

	// @Bean
	// CommandLineRunner runPhoneNumber(PhoneNumbersRepository phoneNumberRepo) {
	// return args -> {
	// phoneNumberRepo.save(new PhoneNumbers(null,"1234"));
	// phoneNumberRepo.save(new PhoneNumbers(null, "12345"));
	// phoneNumberRepo.save(new PhoneNumbers(null, "123456"));
	// };
	// }

}
