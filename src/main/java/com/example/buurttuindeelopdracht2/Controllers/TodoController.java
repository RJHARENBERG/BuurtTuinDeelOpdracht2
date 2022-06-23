package com.example.buurttuindeelopdracht2.Controllers;

import com.example.buurttuindeelopdracht2.Dtos.TodoDto;
import com.example.buurttuindeelopdracht2.Dtos.TodoInputDto;
import com.example.buurttuindeelopdracht2.Entiteiten.Todo;
import com.example.buurttuindeelopdracht2.Entiteiten.User;
import com.example.buurttuindeelopdracht2.Services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/todos")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/addTodo")
    public TodoDto addTodo (@RequestBody TodoInputDto todoInputDto){
        return todoService.addTodo(todoInputDto);
    }

    @DeleteMapping("/deleteTodoById/{id}")
    public String deleteTodo(@PathVariable Todo id) {
        return todoService.deleteTodo(id);
    }
}
