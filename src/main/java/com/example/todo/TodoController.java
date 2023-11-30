
package com.example.todo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {

    /*
    
    HTML form only supports: POST and GET 
    So, we must encode in the URL the action.
    */
    
    @Autowired
    private TodoService service;

    @PostMapping("/todos/add")
    public String add(@RequestParam String desc, Model model){
        service.add(new Todo(desc, false));
        return "redirect:/todos";
    }

    @GetMapping("/todos")
    public String all(Model model){
        model.addAttribute("todos", service.getAll());
        return "todos";
    }

    @GetMapping("/todos/{id}/delete")
    public String delete(@PathVariable int id){
        service.remove(id);
        return "redirect:/todos";
    }

    @GetMapping("/todos/{id}/done")
    public String markDone(@PathVariable int id){
        service.get(id).setDone(true);
        return "redirect:/todos";
    }
    
    @GetMapping("/todos/{id}/update")
    public String updateForm(@PathVariable int id, Model model){
        model.addAttribute("todo", service.get(id));
        return "update";
    }

    @PostMapping("/todos/{id}/update")
    public String update(@ModelAttribute Todo todo){
        service.update(todo);
        return "redirect:/todos";
    }
    
    @PostMapping("/todos/delete-multiple")
    public String deleteMultiple(@RequestParam(required=false) List<Integer> ids, Model model){
        if (ids == null) return "redirect:/todos";
        ids.forEach(service::remove);
        return "redirect:/todos";
    }
    
    @PostMapping("/todos/done-multiple")
    public String doneMultiple(@RequestParam(required=false) List<Integer> ids, Model model){
        if (ids == null) return "redirect:/todos";
        ids.forEach(id->service.get(id).setDone(true));
        return "redirect:/todos";
    }

    @PostMapping("/todos/update-multiple")
    public String updateMultiple(@ModelAttribute Todos todos, Model model){
        todos.getTodos().forEach(service::update);
        return "redirect:/todos";
    }
    
    @PostMapping("/todos/update-multiple-form")
    public String updateMultipleForm(@RequestParam(required = false) List<Integer> ids, Model model){
        //user did not select any todo
        if (ids == null) return "redirect:/todos";
        
       
        List<Todo> todos = new ArrayList<>();
        ids.forEach(id->todos.add(service.get(id)));
        model.addAttribute("form", new Todos(todos));
        return "update-multiple";
    }
        
    
}
