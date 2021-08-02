package com.example.springbackend.controller;

import com.example.springbackend.model.Classroom;
import com.example.springbackend.model.Planner;
import com.example.springbackend.model.User;
import com.example.springbackend.repository.ClassEntityRepository;
import com.example.springbackend.repository.ClassroomRepository;
import com.example.springbackend.repository.PlannerRepository;
import com.example.springbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:4200")
public class PlannerController {
    @Autowired
    private PlannerRepository plannerRepo;
    @Autowired
    private ClassEntityRepository classRepo;
    @Autowired
    private ClassroomRepository clRepo;

    @GetMapping("/planners")
    @Transactional
    public List<Planner> getAll(){
        return plannerRepo.findAll();
    }


    //plannerDetails o sa vina cu un nume nou pentru sala si un nume nou pentru curs
    // folosesc aceste nume pentru a gasi ClassEntity si Classroom corespunzatoare (cu findByName)
    // dupa ce am gasit aceste doua entitati le iau ID-urile si le setez in obiectul Planner (linia de tabel)
    //   care va fi actualizata
    @PutMapping("/class/{id}")
    public Planner updatePlanner(@PathVariable("id") Long id, @RequestBody ClassEntityRepository.ClassDTO plannerDetails){
        //Classroom classroom = clRepo.findById(plannerDetails.getClassroomId()).get();
        Long newClassroomId = clRepo.findByName(plannerDetails.getRoomName()).getId();
        Long newClassId = classRepo.findByName(plannerDetails.getCourseName()).getId();

        Planner obj = plannerRepo.findById(id).get();
        obj.setClassId(newClassId);
        obj.setClassroomId(newClassroomId);
        obj.setStartDate(plannerDetails.getStartDate());
        obj.setEndDate(plannerDetails.getEndDate());
        // acum trebuie gasita cursul coresp si numele salii
        //Planner resObj = plannerRepo.save(obj);
        return plannerRepo.save(obj);
    }
}
