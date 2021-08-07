package com.example.springbackend.repository;

import com.example.springbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT ID as \"id\", FIRSTNAME as \"firstName\", LASTNAME as \"lastName\" " +
            "FROM USERS2 WHERE ROLE = 'TEACHER';", nativeQuery = true)
    List<TeacherDTO> getAllTeacherDTO();

    public static interface TeacherDTO {
        Long getId();
        String getFirstName();
        String getLastName();

    }
}
