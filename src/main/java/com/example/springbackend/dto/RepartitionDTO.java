package com.example.springbackend.dto;

// obiect DTO care il folosesc pentru a primi (din angular spre java) o pereche de 2 numere
// reprezentand  planner_id si student_id  - pentru a repartiza un anumit student intr-un anumit planner
public class RepartitionDTO {
    private Long studentId;
    private Long plannerId;


    public RepartitionDTO(Long studentId, Long plannerId) {
        this.studentId = studentId;
        this.plannerId = plannerId;
    }

    @Override
    public String toString() {
        return "RepartitionDTO{" +
                "studentId=" + studentId +
                ", plannerId=" + plannerId +
                '}';
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getPlannerId() {
        return plannerId;
    }

    public void setPlannerId(Long plannerId) {
        this.plannerId = plannerId;
    }
}
