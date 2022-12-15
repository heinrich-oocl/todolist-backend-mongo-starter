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
    List<Todo> getAll() {
        return todoService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Todo addTodo(@RequestBody Todo todo) {
        return todoService.add(todo);
    }

    //update
    @PutMapping("/{id}")
    Todo updateTodo(@PathVariable String id, @RequestBody Todo todo) {
        return todoService.update(id, todo);
    }


    //delete
    @DeleteMapping("/{id}")
    Todo deleteTodo(@PathVariable String id) {
        return todoService.delete(id);
    }
}

//@CrossOrigin method
//@CrossOrigin controller
//