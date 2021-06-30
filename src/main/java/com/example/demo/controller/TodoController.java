package com.example.demo;

import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @GetMapping("/")
    public List<Todo> findAll() {
        return TodoStorage.getInstance().findAll();
    }

    @PostMapping("/create")
    public List<Todo> create(@RequestBody Todo todo) {
        TodoStorage storage = TodoStorage.getInstance();
        storage.push(todo);
        return storage.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public List<Todo> delete(@PathVariable("id") String id) {
        TodoStorage storage = TodoStorage.getInstance();
        storage.delete(id);
        return storage.findAll();
    }
    @PostMapping("/checkdone")
    public List<Todo> checkdone(@RequestBody Todo todo){
        TodoStorage storage = TodoStorage.getInstance();
        storage.checkdone(todo.getId());
        return storage.findAll();

    }
}
