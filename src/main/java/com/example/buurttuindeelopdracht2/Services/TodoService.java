package com.example.buurttuindeelopdracht2.Services;

import com.example.buurttuindeelopdracht2.Dtos.TodoDto;
import com.example.buurttuindeelopdracht2.Dtos.TodoInputDto;
import com.example.buurttuindeelopdracht2.Entiteiten.*;
import com.example.buurttuindeelopdracht2.Exceptions.RecordNotFoundException;
import com.example.buurttuindeelopdracht2.Repositorys.ProjectRepository;
import com.example.buurttuindeelopdracht2.Repositorys.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final ProjectRepository projectRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository,
                       ProjectRepository projectRepository) {
        this.todoRepository = todoRepository;
        this.projectRepository = projectRepository;
    }

    public TodoDto addTodo(TodoInputDto todoInputDto) {
        Todo todo = toTodo(todoInputDto);
        todoRepository.save(todo);
        return fromTodo(todo);
    }









    public TodoDto addTodo(TodoInputDto todoInputDto, Long projectId) throws RecordNotFoundException {
        Todo todo = toTodo(todoInputDto);
        todoRepository.save(todo);
        Project project = projectRepository.findById(projectId).
                orElseThrow(() -> new RecordNotFoundException("project " + projectId + " doesn't exist"));
        todo.assignProject(project);
        projectRepository.save(project);

        return fromTodo(todo);
    }








    public String deleteTodo(Todo id) {
        todoRepository.deleteById(id.getId());
        return "Todo removed !!" + id;
    }

    public static TodoDto fromTodo(Todo todo) {
        var dto = new TodoDto();

        dto.setId(todo.getId());
        dto.setNameTodo(todo.getNameTodo());
        dto.setDefinition(todo.getDefinition());
        dto.setIsDone(todo.getIsDone());

        dto.setProject(todo.getProject());

        return dto;
    }

    public static Todo toTodo(TodoInputDto todoInputDto) {
        var todo = new Todo();

        todo.setId(todoInputDto.getId());
        todo.setNameTodo(todoInputDto.getNameTodo());
        todo.setDefinition(todoInputDto.getDefinition());
        todo.setIsDone(todoInputDto.getDone());

        todo.setProject(todoInputDto.getProject());

        return todo;
    }

}
