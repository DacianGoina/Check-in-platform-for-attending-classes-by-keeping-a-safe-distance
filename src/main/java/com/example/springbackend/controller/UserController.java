package com.example.springbackend.controller;

import com.example.springbackend.exception.ResourceNotFoundException;
import com.example.springbackend.model.Role;
import com.example.springbackend.model.User;
import com.example.springbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    // get all users
    // cand se face GET la adresa paginii api/v1/users se va returna (ca obiect json) toate lista de users
    @GetMapping("/users")
    @Transactional
    public List<User> getAll(){
        List<User> res = userRepo.findAll();
        System.out.println(res.stream().filter(p ->p.getRole().equals(Role.ADMIN)).collect(Collectors.toList()));
        return res;
    }


    // cu asta se face get la o pagina de  genul site/api/v1/users/<un anume id>
    // de exemplu genul site/api/v1/users/2    si vom primi obiectul corespunzator: user cu id = 2
    // @PathVariabile se foloseste ca sa 'conecteze' parametrul id din metoda la id din @GetMapping
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        Optional<User> a = userRepo.findById(id);
        User res = a.orElseThrow(ResourceNotFoundException.RESOURCE_NOT_FOUND_SUPPLIER);
        return res;
    }





}
