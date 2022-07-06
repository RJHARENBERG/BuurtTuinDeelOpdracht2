package com.example.buurttuindeelopdracht2.Controllers;

import com.example.buurttuindeelopdracht2.Dtos.TodoDto;
import com.example.buurttuindeelopdracht2.Dtos.TodoInputDto;
import com.example.buurttuindeelopdracht2.Entiteiten.Todo;
import com.example.buurttuindeelopdracht2.Exceptions.RecordNotFoundException;
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

    @PostMapping("/addTodo/{project_id}")
    public TodoDto addTodo (@PathVariable Long project_id,
                            @RequestBody TodoInputDto todoInputDto) throws RecordNotFoundException {
        return todoService.addTodo(todoInputDto, project_id);
    }

    @DeleteMapping("/deleteTodoById/{id}")
    public String deleteTodo(@PathVariable Todo id) {
        return todoService.deleteTodo(id);
    }
}
