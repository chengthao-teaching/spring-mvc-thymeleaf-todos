package com.example.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private int curId = 0;
    private final List<Todo> todos = new ArrayList<>();

    public List<Todo> getAll(){
        return todos;
    }

    public Todo get(int id){
        return todos.get(todos.indexOf(new Todo(id)));
    }

    public void remove(int id){
        todos.remove(new Todo(id));
    }

    public void add(Todo todo){
        todos.add(new Todo(curId++, todo.getDesc(), todo.isDone()));
    }

    public void update(Todo todo){
        todos.set(todos.indexOf(todo), todo);
    }
}
