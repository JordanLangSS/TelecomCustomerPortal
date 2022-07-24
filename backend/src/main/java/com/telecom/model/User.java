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
@Data // Generate Getters and Setters
@Table(name = "loginUsers")
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

    public String getuserName() {
        return userName;
    }



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
