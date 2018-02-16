package com.rakshitlabs.springbootangulartodo.web.rest;

import com.codahale.metrics.annotation.Timed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/*Rest API to view the todo list */

@RestController
@RequestMapping("/api")
public class TodoResource {

    @GetMapping("/todo")
    @Timed
    public List<Object> getTodoList(){
        return Arrays.asList("task1","task2", "task3");
    }
}
