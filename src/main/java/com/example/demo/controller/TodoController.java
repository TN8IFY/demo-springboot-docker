package com.example.demo.controller;

import com.example.demo.entity.Todo;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TodoController {

    @Autowired
    public TodoService todoService;

    @GetMapping("/")
    public List<Todo> findAll(){ return todoService.findAll();}

    @PostMapping("/create")
    public List<Todo> create(@RequestBody Todo todo){
        todoService.save(todo);
        return todoService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public List<Todo> deleteById(@PathVariable("id") String id){
        todoService.deleteById(id);
        return todoService.findAll();
    }

    @PostMapping("/checkdone/{id}")
    public List<Todo> checkDone(@PathVariable("id") String id){
        todoService.checkDone(id);
        return todoService.findAll();
    }
    @PostMapping("/checkUnDone/{id}")
    public List<Todo> checkUnDone(@PathVariable("id") String id){
        todoService.checkUnDone(id);
        return todoService.findAll();
    }

}
