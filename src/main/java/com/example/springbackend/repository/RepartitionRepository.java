package com.example.springbackend.repository;

import com.example.springbackend.model.Repartition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepartitionRepository extends JpaRepository<Repartition, Long> {
    //@Query(value = "DELETE FROM REPARTITION WHERE PLANNER_ID = :id",nativeQuery = true)
    //void deleteRepartitionsByPlannerId(@Param("id") Long id);
    void deleteRepartitionsByPlannerId(Long id);
}
