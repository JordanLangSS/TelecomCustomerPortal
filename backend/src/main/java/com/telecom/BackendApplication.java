package com.telecom;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.telecom.model.CurrentDevice;
import com.telecom.model.CurrentPlan;
import com.telecom.model.Device;
import com.telecom.model.Plan;
import com.telecom.model.User;
import com.telecom.model.PhoneNumbers;
import com.telecom.repository.CurrentDeviceRepository;
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

	// Use command line runner to execute the queries AFTER Spring Boot has started
	// Drops all the tables and re-creates them each time due to "ddl-auto: create"
	// in the application.yml file
	@Bean
	CommandLineRunner runPlans(PlanRepository planRepo) {
		return args -> {
			planRepo.save(new Plan(null, "Silver Plan", 2, 100.00));
			planRepo.save(new Plan(null, "Gold Plan", 4, 150.00));
			planRepo.save(new Plan(null, "Platinum Plan", 6, 200.00));
		};
	}

	@Bean
	CommandLineRunner runDevices(DeviceRepository deviceRepo) {
		return args -> {
			deviceRepo.save(new Device(null, "Iphone", "13"));
			deviceRepo.save(new Device(null, "Samsung", "Galaxy"));
			deviceRepo.save(new Device(null, "Pixel", "6"));
			deviceRepo.save(new Device(null, "Samsung", "ZFlip"));
			deviceRepo.save(new Device(null, "Pixel", "5"));
			deviceRepo.save(new Device(null, "Iphone", "12"));

		};
	}

	@Bean
	CommandLineRunner runUser(UserRepository userRepo, PlanRepository planRepo,
			PhoneNumbersRepository phoneNumberRepo, CurrentPlanRepository currPlanRepo) {
		return args -> {
			User userJordan = new User(null, "JordanL",
					"0b14d501a594442a01c6859541bcb3e8164d183d32937b851835442f69d5c94e",
					null, null, null);
			User userKevin = new User(null, "KevinO",
					"6cf615d5bcaac778352a8f1f3360d23f02f34ec182e259897fd6ce485d7870d4",
					null, null, null);
			User user3 = new User(null, "firstName3",
					"5906ac361a137e2d286465cd6588ebb5ac3f5ae955001100bc41577c3d751764", null, null, null);
			User user4 = new User(null, "firstName4",
					"b97873a40f73abedd8d685a7cd5e5f85e4a9cfb83eac26886640a0813850122b", null, null, null);

			userRepo.save(userJordan);
			userRepo.save(userKevin);
			userRepo.save(user3);
			userRepo.save(user4);

			phoneNumberRepo.save(new PhoneNumbers(null, "(220) 675-8890", userJordan));
			phoneNumberRepo.save(new PhoneNumbers(null, "(123) 456-4534", userJordan));
			phoneNumberRepo.save(new PhoneNumbers(null, "(555) 267-9800", userJordan));
			phoneNumberRepo.save(new PhoneNumbers(null, "(213) 567-4432", userJordan));
			phoneNumberRepo.save(new PhoneNumbers(null, "(098) 761-4988", userJordan));

			phoneNumberRepo.save(new PhoneNumbers(null, "(222) 222-2222", userKevin));
			phoneNumberRepo.save(new PhoneNumbers(null, "(165) 301-0076", userKevin));
			phoneNumberRepo.save(new PhoneNumbers(null, "(456) 765-987", userKevin));
			phoneNumberRepo.save(new PhoneNumbers(null, "(776) 967-1121", userKevin));
			phoneNumberRepo.save(new PhoneNumbers(null, "(489) 501-7322", userKevin));

		};
	}

}
