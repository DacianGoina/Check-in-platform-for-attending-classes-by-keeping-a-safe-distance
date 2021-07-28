package com.example.springbackend.controller;

import com.example.springbackend.dto.ClassDetails;
import com.example.springbackend.repository.ClassDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("")
public class ClassDetailsController {
    @Autowired
    private ClassDetailsRepository cdRepo;

    @GetMapping("/cd")
    @Transactional
    public List<ClassDetails> getAll(){
        return cdRepo.findAll();
    }

}
