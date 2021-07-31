package com.example.springbackend.controller;

import com.example.springbackend.model.Planner;
import com.example.springbackend.model.User;
import com.example.springbackend.repository.PlannerRepository;
import com.example.springbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("")
public class PlannerController {
    @Autowired
    private PlannerRepository plannerRepo;

    @GetMapping("/planners")
    @Transactional
    public List<Planner> getAll(){
        return plannerRepo.findAll();
    }
}
