package com.example.springbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "CLASSES")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable = false, updatable = false)
    private Long id;

    @Column(name = "TEACHER_ID")
    private Long teacherId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "SECTION")
    private String section;

    @Column(name = "OCCUPIED_SEATS")
    private Integer occupied_seats;

    public Class(){

    }

    public Class(Long id, Long teacherId, String name, Integer year, String section, Integer occupied_seats) {
        this.id = id;
        this.teacherId = teacherId;
        this.name = name;
        this.year = year;
        this.section = section;
        this.occupied_seats = occupied_seats;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", section='" + section + '\'' +
                ", occupied_seats=" + occupied_seats +
                '}';
    }


    // Getters
    public Long getId() {
        return id;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public String getSection() {
        return section;
    }

    public Integer getOccupied_seats() {
        return occupied_seats;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setOccupied_seats(Integer occupied_seats) {
        this.occupied_seats = occupied_seats;
    }
}
