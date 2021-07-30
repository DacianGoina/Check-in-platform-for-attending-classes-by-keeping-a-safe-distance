package com.example.springbackend.repository;


import com.example.springbackend.dto.ClassDTO;
import com.example.springbackend.model.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Repository
public interface ClassEntityRepository extends JpaRepository<ClassEntity, Long> {

    List<ClassEntity> findAll();

    @Query("SELECT new com.example.springbackend.dto.ClassDTO" +
            "(Planner.id, Planner.classroomId, Planner.classId, Planner.startTime, Planner.endTime, Planner.date, " +
            "ClassEntity.name, Classroom.name, User.lastName, Classroom.capacity)" +
            "FROM Planner inner join ClassEntity on Planner.classroomId = ClassEntity.id," +
            "Planner inner join Classroom on Planner.classroomId = Classroom.id," +
            "ClassEntity inner join User on ClassEntity.teacherId = User.id")
    //@Query("SELECT new de.smarterco.example.dto.UserNameDTO(u.id, u.name) FROM User u WHERE u.name = :name")
    List<ClassDTO> retrieveClassAsDTO();


    /*
    select P.id, P.classroom_id, P.class_id, P.starttime, P.endtime, P.data,
    C.NAME AS "COURSE_NAME" ,CL.NAME AS "ROOM_NAME", U.LASTNAME, CL.CAPACITY
    FROM PLANNERS P INNER JOIN CLASSROOMS CL ON CL.ID = P.CLASSROOM_ID
    INNER JOIN CLASSES C ON C.ID = P.CLASS_ID
    INNER JOIN USERS2 U ON C.TEACHER_ID = U.ID
     */

}
