
package com.exercise.demo.model;

import lombok.Data;

@Data
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long managerId;
    private String jobTitle;

    // Constructor
    public Employee(Long id, String firstName, String lastName, String email, Long managerId, String jobTitle) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.managerId = managerId;
        this.jobTitle = jobTitle;
    }

}