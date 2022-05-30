package com.example.buurttuindeelopdracht2.Controllers;

import com.example.buurttuindeelopdracht2.Dtos.TodoDto;
import com.example.buurttuindeelopdracht2.Dtos.TodoInputDto;
import com.example.buurttuindeelopdracht2.Services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
}
