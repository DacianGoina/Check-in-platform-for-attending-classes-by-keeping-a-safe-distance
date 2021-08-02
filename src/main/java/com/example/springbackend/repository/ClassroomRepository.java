package com.example.springbackend.repository;

import com.example.springbackend.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

    @Query(value = "SELECT NAME AS \"roomName\" FROM CLASSROOMS", nativeQuery = true)
    public List<String> getAllRoomNames();
}
