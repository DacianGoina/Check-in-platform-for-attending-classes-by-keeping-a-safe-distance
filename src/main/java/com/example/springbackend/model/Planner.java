package com.example.springbackend.model;


import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

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
    private Time startTime;

    @Column(name = "ENDTIME")
    private Time endTime;

    @Column(name = "DATA")
    private Date date;

    public Planner(){

    }

    public Planner(Long id, Long classroomId, Long classId, Time startTime, Time endTime, Date date) {
        this.id = id;
        this.classroomId = classroomId;
        this.classId = classId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
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

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
