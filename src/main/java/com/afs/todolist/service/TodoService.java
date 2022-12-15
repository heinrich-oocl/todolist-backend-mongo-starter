package com.afs.todolist.service;

import com.afs.todolist.entity.Todo;
import com.afs.todolist.exception.InvalidIdException;
import com.afs.todolist.exception.TodoNotFoundException;
import com.afs.todolist.repository.TodoRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    private void validateObjectId(String id){
        if(!ObjectId.isValid(id)){
            throw new InvalidIdException(id);
        }
    }

    public Todo add(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo update(String id, Todo todo) {
        if (todoRepository.existsById(id)){
            return todoRepository.save(todo);
        } else {
            throw new TodoNotFoundException(id);
        }
    }

    public Todo delete(String id) {
        Todo todo = todoRepository
                .findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
        todoRepository.delete(todo);
        return todo;
    }
}
