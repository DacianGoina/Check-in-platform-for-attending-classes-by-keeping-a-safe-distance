package com.example.springbackend.controller;

import com.example.springbackend.model.User;
import com.example.springbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    // get all users
    // cand se face GET la adresa paginii api/v1/users se va returna (ca obiect json) toate lista de users
    @GetMapping("/users")
    @Transactional
    public List<User> getAll(){
        return userRepo.findAll();
    }


    // cu asta se face get la o pagina de  genul site/api/v1/users/<un anume id>
    // de exemplu genul site/api/v1/users/2    si vom primi obiectul corespunzator: user cu id = 2
    // @PathVariabile se foloseste ca sa 'conecteze' parametrul id din metoda la id din @GetMapping
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable  Long id){
        User a =  userRepo.findById(id).get();
        System.out.println(a.toString());
        return a;
    }
}
