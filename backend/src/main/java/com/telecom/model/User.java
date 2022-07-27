package com.telecom.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @Column
    private Long id;

    @Column(unique = true)
    private String userName;

    @Column
    @NotEmpty(message = "The user must have a password")
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<PhoneNumbers> phoneNumbers;

    // @Column(name = "firstname")
    // @NotEmpty(message = "The user must have a first name")
    // private String firstName;

    // @Column(name = "lastname")
    // @NotEmpty(message = "The user must have a last name")
    // private String lastName;

    // @Column
    // @NotEmpty(message = "The user must have an email")
    // private String email;

}
