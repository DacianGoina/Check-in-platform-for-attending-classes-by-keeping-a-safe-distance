package com.example.springbackend.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@IdClass(CompositeKey.class)
@Table(name = "REPARTITION")
public class Repartition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long Id;

    @Column(name = "STUDENT_ID", nullable = false, updatable = false)
    private Long studentId;

    @Column(name = "PLANNER_ID", nullable = false, updatable = false)
    private Long plannerId;

    public Repartition() {

    }

    public Repartition(Long Id, Long studentId, Long plannerId) {
        this.Id = Id;
        this.studentId = studentId;
        this.plannerId = plannerId;
    }


    @Override
    public String toString() {
        return "Repartition{" +
                "Id" + Id +
                "studentId=" + studentId +
                ", classId=" + plannerId +
                '}';
    }

    public Long getStudentId() {
        return studentId;
    }

    public Long getId() {
        return Id;
    }

    public Long getPlannerId() {
        return plannerId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setPlannerId(Long plannerId) {
        this.plannerId = plannerId;
    }
}
