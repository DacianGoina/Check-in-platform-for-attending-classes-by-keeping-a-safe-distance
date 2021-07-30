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

}
