package com.telecom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class PhonePlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long planId;
	
	@Column(unique = true)
	@NotEmpty(message = "The Phone Plan must have a name")
	private String planName;
	
	private int deviceLimit;
	
	//@NotEmpty(message = "The Phone Plan must have a price")
	private double price;

}
