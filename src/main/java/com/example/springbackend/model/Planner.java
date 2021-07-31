package com.example.springbackend.model;


import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "PLANNERS")
public class Planner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "CLASSROOM_ID")
    private Long classroomId;

    @Column(name = "CLASS_ID", nullable = false, updatable = false)
    private Long classId;

    @Column(name = "STARTTIME")
    private Timestamp startDate;

    @Column(name = "ENDTIME")
    private Timestamp endDate;


    public Planner(){

    }

    public Planner(Long id, Long classroomId, Long classId, Timestamp startTime, Timestamp endTime) {
        this.id = id;
        this.classroomId = classroomId;
        this.classId = classId;
        this.startDate = startTime;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Long classroomId) {
        this.classroomId = classroomId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }


}
