package com.telecom.model;

import java.io.Serializable;

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
public class CurrentPlan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(unique = true)
    @NotEmpty(message = "The Phone Plan must have a name")
    private String planName;

    @Column
    private int deviceLimit;

    @Column
    @NotNull(message = "The Phone Plan must have a price")
    private Double price;

    // not sure if this has to be a long because it is a long in the user model
    // @Column
    // private int userId;

    // // not sure if this has to be a long because it is a long in the plan model
    // @Column
    // private int planId;

}