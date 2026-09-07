package com.valencia.lab.signin.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity // to let spring know this is a data table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First Name Required")
    private String firstName;

    @NotBlank(message = "Last Name Required")
    private String lastName;

    // this makes sure the @mail.valenciacollege.edu requirement is held up
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@mail\\.valenciacollege\\.edu$",
            message = "Email must end with @mail.valenciacollege.edu")
    private String email;

    private String course;

    //Constructor
    public Student() {}

    //Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
}