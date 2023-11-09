package com.karthigaspringboottodo.springboottodo.controller;


import com.karthigaspringboottodo.springboottodo.Request.TodoRequest;
import com.karthigaspringboottodo.springboottodo.model.AppUser;
import com.karthigaspringboottodo.springboottodo.model.Todo;
import com.karthigaspringboottodo.springboottodo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@CrossOrigin
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/all/{userId}")
    public List<Todo> getAllTodos(@PathVariable int userId)
    {
        return todoService.getAllTodos(userId);
    }

    @PostMapping("/add")
    public List<Todo> insertTodo(@RequestBody TodoRequest todoRequest)
    {
        return todoService.insertTodo(todoRequest);
    }

    @PutMapping("/update")
    public List<Todo> updateTodo(@RequestBody TodoRequest todoRequest)
    {
        return todoService.updateTodo(todoRequest);
    }

    @DeleteMapping("/delete/{id}")
    public List<Todo> deleteTodo(@PathVariable int id)
    {
        return todoService.deleteTodo(id);
    }

    @GetMapping("/find/{id}")
    public Todo getTodo(@PathVariable int id)
    {
        return todoService.getTodo(id);
    }
}
