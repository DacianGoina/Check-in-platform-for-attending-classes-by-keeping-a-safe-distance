package com.example.springbackend.dto;



import java.sql.Date;
import java.sql.Time;
public class ClassDTO {
    private Long id;
    private Long classroomId;
    private Long classId;
    private Time startTime;
    private Time endTime;
    private Date date;
    private String courseName;
    private String roomName;
    private String teacherLastName;
    private Integer capacity;

    /*public ClassDTO(){

    }*/

    public ClassDTO(Long id, Long classroomId, Long classId, Time startTime, Time endTime, Date date, String courseName, String roomName, String teacherLastName, Integer capacity) {
        this.id = id;
        this.classroomId = classroomId;
        this.classId = classId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.courseName = courseName;
        this.roomName = roomName;
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


