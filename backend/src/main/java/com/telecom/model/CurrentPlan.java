package com.telecom.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
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

    @JsonBackReference

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    // not sure if this has to be a long because it is a long in the user model
    // @Column
    // private int userId;

    // // not sure if this has to be a long because it is a long in the plan model
    // @Column
    // private int planId;

}