package com.example.demo.service;


import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public void save(Todo todo) {
        todo.setId(UUID.randomUUID().toString());
        todoRepository.save(todo);
    }

    public void deleteById(String id) {
        todoRepository.deleteById(id);
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public void checkDone(String id){
        todoRepository.updateCheckDoneById(id);
    }

    public void checkUnDone(String id){
        todoRepository.updateCheckUnDoneById(id);
    }
}
