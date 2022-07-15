package com.telecom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Generate Getters and Setters
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    private Long userId;

    @Column(name = "firstname")
    @NotEmpty(message = "The user must have a first name")
    private String firstName;

    @Column(name = "lastname")
    @NotEmpty(message = "The user must have a last name")
    private String lastName;

    @Column
    @NotEmpty(message = "The user must have an email")
    private String email;

    @Column
    @NotEmpty(message = "The user must have a password")
    private String password;
}
