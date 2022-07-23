package com.telecom.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Generate Getters and Setters
@NoArgsConstructor
@AllArgsConstructor
public class CurrentDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    @NotNull(message = "The current device must have a make")
    private String make;

    @Column
    @NotNull(message = "The current device must have a model")
    private String model;

    // @Column(name = "phone_number")
    // private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pn_id")
    private PhoneNumbers phoneNumbers;
}
