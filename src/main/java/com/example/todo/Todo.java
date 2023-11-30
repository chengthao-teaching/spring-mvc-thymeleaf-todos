
package com.example.todo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author cheng
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private int id;
    private String desc;
    private boolean done;
    
    public Todo(int id){
        this.id = id;
    }
    
    public Todo(String desc, boolean done){
        this.desc = desc;
        this.done = done;
    }

    public Todo(Todo todo){
        this.id = todo.id;
        this.desc = todo.desc;
        this.done = todo.done;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + this.id;
        return hash;
    }
    
    @Override
    public boolean equals(Object o){
        if (o == null) return false;
        if (!(o instanceof Todo)) return false;
        return id == ((Todo)o).id;
    }
    
    @Override
    public String toString(){
        return String.format("Todo[id=%d, desc=%s, done=%s]",
                id, desc,done);
    }
}
