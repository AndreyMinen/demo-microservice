package ru.example.demo.user.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.demo.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity
                .ok(service.findAll());
    }

    @GetMapping("/{login}")
    public ResponseEntity findAllByLogin(@PathVariable("login") String login){
        return ResponseEntity
                .ok(service.findAllByLogin(login));
    }

}
