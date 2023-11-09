package com.karthigaspringboottodo.springboottodo.service;


import com.karthigaspringboottodo.springboottodo.Request.TodoRequest;
import com.karthigaspringboottodo.springboottodo.model.AppUser;
import com.karthigaspringboottodo.springboottodo.model.Todo;
import com.karthigaspringboottodo.springboottodo.repository.AppUserRepository;
import com.karthigaspringboottodo.springboottodo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    public List<Todo> getAllTodos(int userId) {

        return todoRepository.findAll().stream().filter(todo -> todo.getAppUser().getId() == userId).collect(Collectors.toList());
    }

    public List<Todo> insertTodo(TodoRequest todoRequest)
    {
        Todo originalTodo = new Todo();
        originalTodo.setItem(todoRequest.getItem());
        AppUser user = appUserRepository.findById(todoRequest.getUserId()).get();
        originalTodo.setAppUser(user);
        todoRepository.save(originalTodo);
        return getAllTodos(todoRequest.getUserId());
    }

    public List<Todo> updateTodo(TodoRequest todoRequest) {

        Todo originalTodo = new Todo();
        originalTodo.setId(todoRequest.getId());
        originalTodo.setItem(todoRequest.getItem());
        AppUser user = appUserRepository.findById(todoRequest.getUserId()).get();
        originalTodo.setAppUser(user);
        todoRepository.save(originalTodo);
        return getAllTodos(todoRequest.getUserId());
    }

    public List<Todo> deleteTodo(int id) {
        int userId = todoRepository.findById(id).get().getAppUser().getId();
        todoRepository.deleteById(id);
        return getAllTodos(userId);
    }

    public Todo getTodo(int id) {
        Todo todo = todoRepository.findById(id).get();
        return todo;
    }
}
