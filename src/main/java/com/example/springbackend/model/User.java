package com.example.springbackend.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "USERS2")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name="FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "DEPARTMENT")
    private String department;

    public User(){

    }

    public User(Long id, Role role, String firstName, String lastName, Integer year, String department) {
        this.id = id;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.department = department;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role=" + role +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", year=" + year +
                ", department='" + department + '\'' +
                '}';
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getYear() {
        return year;
    }

    public String getDepartment() {
        return department;
    }


    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
