package com.example.springbackend.dto;



import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class ClassDTO {
    private Long id;
    private Long classroomId;
    private Long classId;
    private Timestamp startDate;
    private Timestamp endDate;
    private String courseName;
    private String roomName;
    private String teacherFirstName;
    private String teacherLastName;
    private Integer capacity;

    /*public ClassDTO(){

    }*/

    public ClassDTO(Long id, Long classroomId, Long classId, Timestamp startDate, Timestamp endDate,  String courseName, String roomName, String teacherFirstName, String teacherLastName, Integer capacity) {
        this.id = id;
        this.classroomId = classroomId;
        this.classId = classId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.courseName = courseName;
        this.roomName = roomName;
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
        this.capacity = capacity;
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public void setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}


