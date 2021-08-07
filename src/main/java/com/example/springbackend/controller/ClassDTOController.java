package com.example.springbackend.controller;

import com.example.springbackend.dto.ClassDTO;
import com.example.springbackend.model.ClassEntity;
import com.example.springbackend.model.Classroom;
import com.example.springbackend.model.Planner;
import com.example.springbackend.repository.ClassEntityRepository;
import com.example.springbackend.repository.ClassroomRepository;
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
        return classRepo.getAllClassDTO();
    }

    @GetMapping("/classdto/{id}")
    @Transactional
    public ClassEntityRepository.ClassDTO getClassDTOById(@PathVariable("id") Long id){
        return classRepo.getClassDTOById(id);
    }


    @GetMapping("/course-names")
    @Transactional
    public List<String> getCourseNames(){
        return classRepo.getAllCourseNames();
    }

    @GetMapping("/cname/{name}")
    @Transactional
    public ClassEntity getClassEntityByName(@PathVariable("name") String courseName){
        return classRepo.findByName(courseName);
    }

    @PostMapping("/createClass")
    @Transactional
    public ClassEntity createClasEntity(@RequestBody ClassEntity newClassEntity){
        System.out.println("am intrat in POST");
        // sa creezi efectiv obiectul ca sa nu ramana gol
        ClassEntity a = new ClassEntity(0L, newClassEntity.getTeacherId(), newClassEntity.getName(), newClassEntity.getYear(), newClassEntity.getSection());
        System.out.println(a.toString());
        System.out.println("Acum se salveaza");
        return classRepo.save(a);
    }


}
