package com.example.springbackend.dto;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "PLANNERS")
@SecondaryTables({@SecondaryTable(name = "CLASSES", pkJoinColumns = @PrimaryKeyJoinColumn(name = "ID")),
        @SecondaryTable(name = "CLASSROOMS", pkJoinColumns = @PrimaryKeyJoinColumn(name = "ID")),
        @SecondaryTable(name = "USERS2", pkJoinColumns = @PrimaryKeyJoinColumn(name = "ID"))})
public class ClassDetails {

    //private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLASSROOM_ID")
    private Long classroomID;
    @Column(name = "CLASS_ID")
    private Long classID;

    @Column(name = "STARTTIME")
    private Time startTime;
    @Column(name = "ENDTIME")
    private Time endTime;
    @Column(name = "DATA")
    private Date data;


    /*@JoinTable(
            name="CLASSROOMS",
            joinColumns=@JoinColumn(name="NAME", referencedColumnName="CLASSROOM_ID"))*/
    @Column(name = "NAME", table = "CLASSROOMS")
    private String roomName;


    /*@JoinTable(
            name="CLASSES",
            joinColumns=@JoinColumn(name="NAME", referencedColumnName="CLASS_ID"))*/
    @Column(name = "NAME", table = "CLASSES")
    private String courseName;

    @Column(name="CAPACITY",table = "CLASSROOMS")
    private Integer capacity;

    //@Column(name = "LASTNAME", table = "USERS2")
    //private String teacherFirstName;

    @Column(name = "TEACHER_ID", table = "CLASSES", updatable = false, insertable = false)
    private Integer teacherID;

    public ClassDetails(){

    }

    public ClassDetails(Long classroomID, Long classID, Time startTime, Time endTime, Date data, String roomName, String courseName, Integer capacity, Integer teacherID) {
        this.classroomID = classroomID;
        this.classID = classID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.data = data;
        this.roomName = roomName;
        this.courseName = courseName;
        this.capacity = capacity;
        this.teacherID = teacherID;
    }

    public Long getClassroomID() {
        return classroomID;
    }

    public Long getClassID() {
        return classID;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public Date getData() {
        return data;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setClassroomID(Long classroomID) {
        this.classroomID = classroomID;
    }

    public void setClassID(Long classID) {
        this.classID = classID;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Integer teacherID) {
        this.teacherID = teacherID;
    }
}
