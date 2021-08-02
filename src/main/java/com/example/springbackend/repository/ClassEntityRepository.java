package com.example.springbackend.repository;


import com.example.springbackend.dto.ClassDTO;
import com.example.springbackend.model.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
//@Repository
public interface ClassEntityRepository extends JpaRepository<ClassEntity, Long> {

    List<ClassEntity> findAll();




    // AICI E PARTEA CU NATIVE QUERY
    //--------------------------------------------

    @Query(value = "select P.id AS \"id\" , P.classroom_id AS \"classroomId\", P.class_id AS \"classId\", " +
            "P.start_Date AS \"startDate\", P.end_Date AS \"endDate\", " +
            "C.NAME AS \"courseName\" ,CL.NAME AS \"roomName\", U.FIRSTNAME AS \"teacherFirstName\", U.LASTNAME AS \"teacherLastName\", " +
            "CL.CAPACITY AS \"capacity\" FROM PLANNERS P INNER JOIN CLASSROOMS CL ON CL.ID = P.CLASSROOM_ID " +
            "INNER JOIN CLASSES C ON C.ID = P.CLASS_ID " +
            "INNER JOIN USERS2 U ON C.TEACHER_ID = U.ID", nativeQuery = true)
    List<ClassDTO> retrieveClassAsDTO();


    public static interface ClassDTO {
        Long getId();
        Long getClassroomId();
        Long getClassId();
        Timestamp getStartDate();
        Timestamp getEndDate();
        String getCourseName();
        String getRoomName();
        String getTeacherFirstName();
        String getTeacherLastName();
        Integer getCapacity();
    }
















    //-------------------------------------------------------------------

    /*
    @Query(value = "SELECT new com.example.springbackend.dto.ClassDTO" +
            "(Planner.id, Planner.classroomId, Planner.classId, Planner.startTime, Planner.endTime, Planner.date, " +
            "ClassEntity.name, Classroom.name, User.lastName, Classroom.capacity)" +
            "FROM Planner inner join ClassEntity on Planner.classroomId = ClassEntity.id," +
            "Planner inner join Classroom on Planner.classroomId = Classroom.id," +
            "ClassEntity inner join User on ClassEntity.teacherId = User.id", nativeQuery = true)
     */


    /*
    select P.id, P.classroom_id, P.class_id, P.starttime, P.endtime, P.data,
    C.NAME AS "COURSE_NAME" ,CL.NAME AS "ROOM_NAME", U.LASTNAME, CL.CAPACITY
    FROM PLANNERS P INNER JOIN CLASSROOMS CL ON CL.ID = P.CLASSROOM_ID
    INNER JOIN CLASSES C ON C.ID = P.CLASS_ID
    INNER JOIN USERS2 U ON C.TEACHER_ID = U.ID
     */

}
