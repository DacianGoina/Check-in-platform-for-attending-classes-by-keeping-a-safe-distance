package com.example.springbackend.controller;

import com.example.springbackend.model.ClassEntity;
import com.example.springbackend.model.Classroom;
import com.example.springbackend.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("")
public class ClassroomController {
    @Autowired
    private ClassroomRepository clRepo;

    @GetMapping("/classrooms")
    @Transactional
    public List<Classroom> getAll(){
        return clRepo.findAll();
    }

    @GetMapping("/classroom/{id}")
    @Transactional
    public Classroom getClassById(@PathVariable("id") Long id){
        return clRepo.findById(id).get();
    }

}
