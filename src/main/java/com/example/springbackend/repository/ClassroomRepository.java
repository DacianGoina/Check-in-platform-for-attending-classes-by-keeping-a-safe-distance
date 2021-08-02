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

    public List<Classroom> findAllByCapacity(Integer capacity);

    @Query(value="SELECT NAME AS \"name\", CAPACITY AS \"capacity\" FROM CLASSROOMS", nativeQuery = true)
    public List<ClassroomDetails> getClassroomsDetails();

    public Classroom findByName(String roomName);

    // folosita pentru a trimite pereche name | capacity care reprezinta
    // numele unei sali de clasa si numarul de locuri de acolo
    // cand se doreste modificarea unei programari si se seleteaza o alta sala e bine sa se stie
    // cate locuri sunt in acea sala
    public static interface ClassroomDetails{
        String getName();
        Integer getCapacity();
    }

}
