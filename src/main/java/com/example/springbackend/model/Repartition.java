package com.example.springbackend.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@IdClass(CompositeKey.class)
@Table(name = "REPARTITION")
public class Repartition implements Serializable{

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID", nullable = false, updatable = false)
    private Long studentId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLASS_ID", nullable = false, updatable = false)
    private Long classId;
    */

    @EmbeddedId
    private CompositeKey key;

    public Repartition(){

    }

    public CompositeKey getKey() {
        return this.key;
    }

    public void setKey(CompositeKey newKey){
        this.key = newKey;
    }

    /*
    public Repartition(Long studentId, Long classId) {
        this.studentId = studentId;
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Repartition{" +
                "studentId=" + studentId +
                ", classId=" + classId +
                '}';
    }

    public Long getStudentId() {
        return studentId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

     */
}
