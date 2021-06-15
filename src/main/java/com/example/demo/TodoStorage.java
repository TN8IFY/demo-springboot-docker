package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TodoStorage {

    private static TodoStorage instance = null;

    public static TodoStorage getInstance() {
        if (instance == null) {
            instance = new TodoStorage();
        }
        return instance;
    }

    public TodoStorage () {
        this.todos = new ArrayList<>();
    }

    private ArrayList<Todo> todos;

    public void push(Todo todo) {
        todo.setId(UUID.randomUUID().toString());
        todo.setTimestamp(System.currentTimeMillis());
        todo.setDone(false);
        this.todos.add(todo);
    }

    public void delete(String id) {
        todos.removeIf(todo -> todo.getId().equals(id));
    }

    public List<Todo> findAll() {
        return todos;
    }


}
