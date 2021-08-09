package com.example.springbackend.controller;

import com.example.springbackend.dto.ClassDTO;
import com.example.springbackend.dto.RepartitionDTO;
import com.example.springbackend.model.Planner;
import com.example.springbackend.model.Repartition;
import com.example.springbackend.repository.PlannerRepository;
import com.example.springbackend.repository.RepartitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:4200")
public class RepartitionController {
    @Autowired
    private RepartitionRepository repartitionRepo;

    @GetMapping("/repartition")
    @Transactional
    public List<Repartition> getAll(){
        return repartitionRepo.findAll();
    }

    // GET id-urile studentilor inrolati intr-un anumit planner
    @GetMapping("enrolled/{plannerId}")
    @Transactional
    public List<Long> getEnrolledStudentsIDs(@PathVariable("plannerId") Long id){
        return repartitionRepo.getEnrolledStudentsIDs(id);
    }

    // Repartizeaza un student intr-un anumit planner
    @PostMapping("/class/{id}/enroll")
    @Transactional
    public Repartition createRepartition(@RequestBody RepartitionDTO newRepartition){
        System.out.println("am intrat in POST");
        Repartition a = new Repartition(0L,newRepartition.getStudentId(),newRepartition.getPlannerId());

        System.out.println("Acum se salveaza");
        return repartitionRepo.save(a);
    }



    /*
    @DeleteMapping(value = "/class/{id}/enroll")
    @Transactional
    public ResponseEntity<Map<String,Boolean>> deleteRepartition(@PathVariable("id") Long id, Long studentId){

        System.out.println("Planner id: " + id + " Student id: " + studentId);
        repartitionRepo.deleteRepartitionByPlannerIdAndStudentId(id,studentId);
        HashMap<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

     */

    @DeleteMapping(value = "/class/{id}/enroll/{studentId}")
    @Transactional
    public ResponseEntity<Map<String,Boolean>> deleteRepartition(@PathVariable("id") Long id, @PathVariable("studentId") Long studentId){

        System.out.println("Planner id: " + id + " Student id: " + studentId);
        repartitionRepo.deleteRepartitionByPlannerIdAndStudentId(id,studentId);
        HashMap<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
