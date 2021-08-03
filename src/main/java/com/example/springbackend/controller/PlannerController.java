package com.example.springbackend.controller;

import com.example.springbackend.dto.ClassDTO;
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
    public Planner updatePlanner(@PathVariable("id") Long id, @RequestBody ClassDTO newPlanner){
        System.out.println("am intrat in PUT");

        //Classroom classroom = clRepo.findById(plannerDetails.getClassroomId()).get();
        Long newClassroomId = clRepo.findByName(newPlanner.getRoomName()).getId();
        Long newClassId = classRepo.findByName(newPlanner.getCourseName()).getId();

        System.out.println(newPlanner.toString());
        Planner obj = plannerRepo.findById(newPlanner.getId()).get();
        obj.setClassId(newClassId);
        obj.setClassroomId(newClassroomId);
        obj.setStartDate(newPlanner.getStartDate());
        obj.setEndDate(newPlanner.getEndDate());
        // acum trebuie gasita cursul coresp si numele salii
        //Planner resObj = plannerRepo.save(obj);
        System.out.println(obj.toString());
        System.out.println("acum urmeaza sa fac return");
        return plannerRepo.save(obj);
    }
}
