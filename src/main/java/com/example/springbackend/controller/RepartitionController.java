package com.example.springbackend.controller;

import com.example.springbackend.model.Planner;
import com.example.springbackend.model.Repartition;
import com.example.springbackend.repository.PlannerRepository;
import com.example.springbackend.repository.RepartitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("")
public class RepartitionController {
    @Autowired
    private RepartitionRepository repartitionRepo;

    @GetMapping("/repartition")
    @Transactional
    public List<Repartition> getAll(){
        return repartitionRepo.findAll();
    }
}
