package com.example.springbackend.controller;

import com.example.springbackend.dto.ClassDTO;
import com.example.springbackend.repository.ClassRepository;
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
public class ClassDTOController {
    @Autowired
    private ClassRepository classRepo;

    @GetMapping("/classdto")
    @Transactional
    public List<ClassDTO> getAllClassDTO(){
        return classRepo.retrieveClassAsDTO();
    }
}
