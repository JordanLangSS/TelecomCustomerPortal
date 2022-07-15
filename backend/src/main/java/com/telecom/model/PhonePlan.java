package com.telecom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Generate Getters and Setters
@NoArgsConstructor
@AllArgsConstructor
public class PhonePlan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long planId;

	@Column(unique = true)
	@NotEmpty(message = "The Phone Plan must have a name")
	private String planName;

	@Column
	private int deviceLimit;

	@Column
	@NotNull(message = "The Phone Plan must have a price")
	private Double price;

}
