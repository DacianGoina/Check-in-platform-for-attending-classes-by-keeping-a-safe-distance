package com.example.springbackend.repository;

import com.example.springbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT ID as \"id\", FIRSTNAME as \"firstName\", LASTNAME as \"lastName\" " +
            "FROM USERS2 WHERE ROLE = 'TEACHER';", nativeQuery = true)
    List<TeacherDTO> getAllTeacherDTO();

    @Query(value = "SELECT U.ID, U.ROLE, U.FIRSTNAME, U.LASTNAME, U.YEAR, U.DEPARTMENT " +
            "FROM USERS2 U INNER JOIN REPARTITION R ON U.ID = R.STUDENT_ID " +
            "WHERE U.ROLE = 'STUDENT' AND R.PLANNER_ID = :pid", nativeQuery = true)
    List<User> getStudentsByPlannerId(@Param("pid") Long id);

    public static interface TeacherDTO {
        Long getId();
        String getFirstName();
        String getLastName();

    }
}
