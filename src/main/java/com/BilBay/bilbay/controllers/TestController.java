package com.BilBay.bilbay.controllers;


import com.BilBay.bilbay.models.User;
import com.BilBay.bilbay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    UserRepository userRepository;

//    @Autowired
//    TodoRepository todoRepository;

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/private")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public String userAccess() {
        return "Private Content.";
    }

    @GetMapping("/company")
    @PreAuthorize("hasRole('COMPANY')")
    public String companyAccess() {
        return "Company Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

//    @PostMapping("/todo")
//    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
//        try {
//            Todo _todo = todoRepository.save(new Todo(todo.getTitle(), todo.getDescription()));
//            return new ResponseEntity<>(_todo, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/todo")
//    public List<Todo> getAllTodos() {
//        return todoRepository.findAll();
}