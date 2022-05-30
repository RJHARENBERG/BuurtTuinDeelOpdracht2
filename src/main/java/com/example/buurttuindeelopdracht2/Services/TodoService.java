package com.example.buurttuindeelopdracht2.Services;

import com.example.buurttuindeelopdracht2.Dtos.TodoDto;
import com.example.buurttuindeelopdracht2.Dtos.TodoInputDto;
import com.example.buurttuindeelopdracht2.Dtos.ToolDto;
import com.example.buurttuindeelopdracht2.Dtos.ToolInputDto;
import com.example.buurttuindeelopdracht2.Entiteiten.Todo;
import com.example.buurttuindeelopdracht2.Entiteiten.Tool;
import com.example.buurttuindeelopdracht2.Repositorys.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoDto addTodo(TodoInputDto todoInputDto) {
        Todo todo = toTodo(todoInputDto);
        todoRepository.save(todo);
        return fromTodo(todo);
    }

    public static TodoDto fromTodo(Todo todo) {
        var dto = new TodoDto();

        dto.setId(todo.getId());
        dto.setNameTodo(todo.getNameTodo());
        dto.setDefinition(todo.getDefinition());
        dto.setDone(todo.getDone());

        dto.setProject(todo.getProject());

        return dto;
    }

    public static Todo toTodo(TodoInputDto todoInputDto) {
        var todo = new Todo();

        todo.setId(todoInputDto.getId());
        todo.setNameTodo(todoInputDto.getNameTodo());
        todo.setDefinition(todoInputDto.getDefinition());
        todo.setDone(todoInputDto.getDone());

        todo.setProject(todoInputDto.getProject());

        return todo;
    }

}
