package com.marcon.course.resources;

import com.marcon.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User firstUser = new User(1L, "João", "Joao@gmail.com", "4799999999", "12345678");
        return ResponseEntity.ok().body(firstUser);
    }
}
