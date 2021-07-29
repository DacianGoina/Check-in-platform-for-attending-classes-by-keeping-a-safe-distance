package com.example.springbackend.dto;

import com.example.springbackend.model.Classroom;

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
    @Column(name = "ID")
    private Long id;

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



    /*
    @JoinTable(
            name="CLASSROOMS",
            joinColumns=@JoinColumn(name="NAME", referencedColumnName="CLASSROOM_ID"))
    @Column(name = "NAME", table = "CLASSROOMS")
    private String roomName;


    @JoinTable(
            name="CLASSES",
            joinColumns=@JoinColumn(name="NAME", referencedColumnName="CLASS_ID"))
    @Column(name = "NAME", table = "CLASSES")
    private String courseName;

    @Column(name="CAPACITY",table = "CLASSROOMS")
    private Integer capacity;


    @Column(name = "TEACHER_ID", table = "CLASSES")
    private Integer teacherID;
    */
    public ClassDetails(){

    }


}
