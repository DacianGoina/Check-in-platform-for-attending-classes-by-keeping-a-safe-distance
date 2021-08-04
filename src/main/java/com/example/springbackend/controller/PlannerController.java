package com.example.springbackend.controller;

import com.example.springbackend.dto.ClassDTO;
import com.example.springbackend.model.Classroom;
import com.example.springbackend.model.Planner;
import com.example.springbackend.model.User;
import com.example.springbackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private RepartitionRepository repRepo;

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


    @DeleteMapping("/class/{id}")
    @Transactional
    public ResponseEntity<Map<String,Boolean>> deletePlanner(@PathVariable("id") Long id){
        // vezi ca trebuie sters in REPARTITION toate liniile care au acest id
        repRepo.deleteRepartitionsByPlannerId(id);

        plannerRepo.deleteById(id);
        HashMap<String,Boolean> responsde = new HashMap<>();
        responsde.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(responsde);
    }

    @PostMapping("/addSchedule")
    @Transactional
    public Planner createPlanner(@RequestBody ClassDTO newPlanner){
        System.out.println("am intrat in POST");
        // sa creezi efectiv obiectul ca sa nu ramana gol
        Long newClassroomId = clRepo.findByName(newPlanner.getRoomName()).getId();
        Long newClassId = classRepo.findByName(newPlanner.getCourseName()).getId();
        Planner a = new Planner(0L,newClassroomId,newClassId,newPlanner.getStartDate(),newPlanner.getEndDate());
        System.out.println(a.toString());
        System.out.println("Acum se salveaza");
        return plannerRepo.save(a);
    }
}
