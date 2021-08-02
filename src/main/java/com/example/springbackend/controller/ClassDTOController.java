package com.example.springbackend.controller;

import com.example.springbackend.dto.ClassDTO;
import com.example.springbackend.model.ClassEntity;
import com.example.springbackend.repository.ClassEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("")
public class ClassDTOController {
    @Autowired
    private ClassEntityRepository classRepo;

    @GetMapping("/classes")
    @Transactional
    public List<ClassEntity> getAllClasses(){
        return classRepo.findAll();
    }

    @GetMapping("/class/{id}")
    @Transactional
    public ClassEntity getClassById(@PathVariable("id") Long id){
        return classRepo.findById(id).get();
    }

    @GetMapping("/classdto")
    @Transactional
    public List<ClassEntityRepository.ClassDTO> getAllClassDTO(){
        return classRepo.retrieveClassAsDTO();
    }

    @GetMapping("/classdto/{id}")
    @Transactional
    public ClassEntityRepository.ClassDTO getClassDTOById(@PathVariable("id") Long id){
        return classRepo.getClassDTOById(id);
    }

    /*
    @GetMapping("/classdto")
    @Transactional
    public List<ClassEntityRepository.ClassDTO> getAllClassDTO(){
        List<ClassEntityRepository.ClassDTO> rez = classRepo.retrieveClassAsDTO();
        for(ClassEntityRepository.ClassDTO i : rez)
            System.out.println(i.toString());
        return classRepo.retrieveClassAsDTO();
    }
     */
}
