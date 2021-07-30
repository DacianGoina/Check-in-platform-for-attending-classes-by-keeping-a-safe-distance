package com.example.springbackend.repository;


import com.example.springbackend.dto.ClassDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {

    List<Class> findAll();

    @Query("SELECT new com.example.springbackend.dto.ClassDTO" +
            "(Planner.id, Planner.classroomId, Planner.classId, Planner.startTime, Planner.endTime, Planner.date, " +
            "Class.name, Classroom.name, User.lastName, Classroom.capacity)" +
            "FROM Planner join Class on Planner.classroomId = Class.id," +
            "Planner join Classroom on Planner.classroomId = Classroom.id," +
            "Class join User on Class.teacherId = User.id")
    //@Query("SELECT new de.smarterco.example.dto.UserNameDTO(u.id, u.name) FROM User u WHERE u.name = :name")
    List<ClassDTO> retrieveClassAsDTO();

}
