package com.example.springbackend.model;


import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "PLANNERS")
public class Planner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLASSROOM_ID", nullable = false, updatable = false)
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

    public Planner(Long classroomId, Long classId, Time startTime, Time endTime, Date date) {
        this.classroomId = classroomId;
        this.classId = classId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Planner{" +
                "classroomId=" + classroomId +
                ", classId=" + classId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", date=" + date +
                '}';
    }

    public Long getClassroomId() {
        return classroomId;
    }

    public Long getClassId() {
        return classId;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public Date getDate() {
        return date;
    }

    public void setClassroomId(Long classroomId) {
        this.classroomId = classroomId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
