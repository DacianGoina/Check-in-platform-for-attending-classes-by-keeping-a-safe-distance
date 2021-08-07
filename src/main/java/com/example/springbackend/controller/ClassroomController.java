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


    @GetMapping("/room-names")
    @Transactional
    public List<String> getRoomNames(){
        return clRepo.getAllRoomNames();
    }


    @GetMapping("/findByCapacity/{capacity}")
    @Transactional
    public List<Classroom> getClassroomByCapacity(@PathVariable("capacity") Integer capacity){
        return clRepo.findAllByCapacity(capacity);
    }


    @GetMapping("/clname/{name}")
    @Transactional
    public Classroom getClassroomByName(@PathVariable("name") String roomName){
        return clRepo.findByName(roomName);
    }

    @GetMapping("/cldetails")
    @Transactional
    public List<ClassroomRepository.ClassroomDetails> getAllDetails(){
        return clRepo.getClassroomsDetails();
    }

    @PostMapping("/createClassroom")
    @Transactional
    public Classroom createClassroom(@RequestBody Classroom newClassroom){
        System.out.println("am intrat in POST");
        // sa creezi efectiv obiectul ca sa nu ramana gol
        Classroom a = new Classroom(0L, newClassroom.getName(), newClassroom.getLocation(), newClassroom.getCapacity());
        System.out.println(a.toString());
        System.out.println("Acum se salveaza");
        return clRepo.save(a);
    }

}
