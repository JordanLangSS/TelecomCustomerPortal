package com.telecom.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
public class User {

    public User(Long id, String userName, String password) {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(unique = true)
    private String userName;

    @Column
    @NotEmpty(message = "The user must have a password")
    private String password;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = { CascadeType.ALL })
    private Set<PhoneNumbers> phoneNumbers;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = { CascadeType.ALL })
    private Set<CurrentPlan> currentPlans;

}
