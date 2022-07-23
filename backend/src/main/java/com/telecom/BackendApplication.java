package com.telecom;

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
			planRepo.save(new Plan(null, "Plan number 1", 3, 100.00));
			planRepo.save(new Plan(null, "Plan number 2", 20, 300.00));
			planRepo.save(new Plan(null, "Plan number 3", 15, 150.00));
		};
	}

	@Bean
	CommandLineRunner runCurrentPlans(CurrentPlanRepository currPlanRepo) {
		return args -> {
			currPlanRepo.save(new CurrentPlan(null, "Current Plan number 1", 6, 150.00));

		};
	}

	@Bean
	CommandLineRunner runDevices(DeviceRepository deviceRepo) {
		return args -> {
			deviceRepo.save(new Device(null, "Iphone", "13"));
			deviceRepo.save(new Device(null, "Samsung", "Galaxy"));
			deviceRepo.save(new Device(null, "Pixel", "6"));
			deviceRepo.save(new Device(null, "Samsung", "Phantom"));
			deviceRepo.save(new Device(null, "Iphone", "12"));
			deviceRepo.save(new Device(null, "Pixel", "5"));

		};
	}

	@Bean
	CommandLineRunner runCurrentDevices(CurrentDeviceRepository currentDeviceRepository,
			PhoneNumbersRepository phoneNumbersRepository) {
		return args -> {
			CurrentDevice currentDevice1 = new CurrentDevice();
			currentDevice1.setMake("samsung");
			currentDevice1.setModel("Galaxy");

			PhoneNumbers phoneNumber1 = new PhoneNumbers();
			phoneNumber1.setPhoneNumber("2015464434");
			phoneNumber1.setDevice(currentDevice1);
			currentDevice1.setPhoneNumbers(phoneNumber1);

			// Phone number 2 *******
			CurrentDevice currentDevice2 = new CurrentDevice();
			currentDevice2.setMake("Iphone");
			currentDevice2.setModel("13");

			PhoneNumbers phoneNumber2 = new PhoneNumbers();
			phoneNumber2.setPhoneNumber("2407809754");
			phoneNumber2.setDevice(currentDevice2);
			currentDevice2.setPhoneNumbers(phoneNumber2);

			currentDeviceRepository.save(currentDevice1);
			currentDeviceRepository.save(currentDevice2);

		};
	}

	// @Bean
	// CommandLineRunner runDevices(DeviceRepository deviceRepository,
	// PhoneNumbersRepository phoneNumbersRepository) {
	// return args -> {
	// Device device1 = new Device();
	// device1.setMake("samsung");
	// device1.setModel("Galaxy");

	// PhoneNumbers phoneNumber1 = new PhoneNumbers();
	// phoneNumber1.setPhoneNumber("2015464434");
	// phoneNumber1.setDevice(device1);
	// device1.setPhoneNumbers(phoneNumber1);

	// // Phone number 2 *******
	// Device device2 = new Device();
	// device2.setMake("Iphone");
	// device2.setModel("13");

	// PhoneNumbers phoneNumber2 = new PhoneNumbers();
	// phoneNumber2.setPhoneNumber("2407809754");
	// phoneNumber2.setDevice(device2);
	// device2.setPhoneNumbers(phoneNumber2);

	// deviceRepository.save(device1);
	// deviceRepository.save(device2);

	// };
	// }

	@Bean
	CommandLineRunner runUsers(UserRepository userRepo) {
		return args -> {
			userRepo.save(new User(null, "JordanL", "password1"));
			userRepo.save(new User(null, "KevinO", "password2"));
			userRepo.save(new User(null, "firstName3", "password3"));
			userRepo.save(new User(null, "firstName4", "password4"));
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
