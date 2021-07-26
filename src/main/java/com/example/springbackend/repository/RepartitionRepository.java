package com.example.springbackend.repository;

import com.example.springbackend.model.Repartition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepartitionRepository extends JpaRepository<Repartition, Long> {
}
