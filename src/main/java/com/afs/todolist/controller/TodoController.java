package com.afs.todolist.controller;

import com.afs.todolist.controller.mapper.TodoMapper;
import com.afs.todolist.entity.Todo;
import com.afs.todolist.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;
    private final TodoMapper todoMapper;

    public TodoController(TodoService todoService, TodoMapper todoMapper) {
        this.todoService = todoService;
        this.todoMapper = todoMapper;
    }

    @GetMapping
    @CrossOrigin(origins = {"http://localhost:3000"})
    List<Todo> getAll() {
        return todoService.findAll();
    }

    @PostMapping
    @CrossOrigin(origins = {"http://localhost:3000"})
    @ResponseStatus(HttpStatus.CREATED)
    Todo addTodo(@RequestBody Todo todo) {
        return todoService.add(todo);
    }

    //delete


    //update
}

//@CrossOrigin method
//@CrossOrigin controller
//