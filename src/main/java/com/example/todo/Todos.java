package com.example.todo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cheng
 * We need this wrapper class in order to support
 * editing multiple todo on a single form. 
 */
public class Todos {
    
    private List<Todo> todos;

    public Todos() {
        todos = new ArrayList<>();
    }

    public Todos(List<Todo> todos) {
        this.todos = todos;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
    
    
}
