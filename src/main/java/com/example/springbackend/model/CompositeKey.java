package com.example.springbackend.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Access(AccessType.FIELD)
@Table(name = "REPARTITION")
public class CompositeKey implements Serializable {
    @Column(name = "STUDENT_ID")
    private Long studentId;
    @Column(name = "CLASS_ID")
    private Long classId;

    public CompositeKey(){

    }

    public CompositeKey(Long studentId, Long classId) {
        this.studentId = studentId;
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "CompositeKey{" +
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
}
