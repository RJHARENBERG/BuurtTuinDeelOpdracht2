package com.example.buurttuindeelopdracht2.Services;

import com.example.buurttuindeelopdracht2.Dtos.ProjectDto;
import com.example.buurttuindeelopdracht2.Dtos.ProjectInputDto;
import com.example.buurttuindeelopdracht2.Entiteiten.Enroll;
import com.example.buurttuindeelopdracht2.Entiteiten.Project;
import com.example.buurttuindeelopdracht2.Entiteiten.Todo;
import com.example.buurttuindeelopdracht2.Entiteiten.User;
import com.example.buurttuindeelopdracht2.Exceptions.RecordNotFoundException;
import com.example.buurttuindeelopdracht2.Repositorys.EnrollRepository;
import com.example.buurttuindeelopdracht2.Repositorys.ProjectRepository;
import com.example.buurttuindeelopdracht2.Repositorys.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final TodoRepository todoRepository;
    private final EnrollRepository enrollRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository,
                          TodoRepository todoRepository,
                          EnrollRepository enrollRepository) {
        this.projectRepository = projectRepository;
        this.todoRepository = todoRepository;
        this.enrollRepository = enrollRepository;
    }

    public ProjectDto addProject(ProjectInputDto projectInputDto) {
        Project project = toProject(projectInputDto);
        projectRepository.save(project);
        return fromProject(project);
    }

    public List<ProjectDto> getAllProjects() {
        List<ProjectDto> projectDtos = new ArrayList<>();
        List<Project> projects = projectRepository.findAll();
        for (Project project : projects) {
            projectDtos.add(fromProject(project));
        }
        return projectDtos;
    }

//    public ProjectDto addNewTodoToProject(Long todoId, Long projectId) throws RecordNotFoundException {
//        Optional<Todo> optionalTodo = todoRepository.findById(todoId);
//        Optional<Project> optionalProject = projectRepository.findById(projectId);
//
//        Project project;
//        Todo todo;
//        if (optionalProject.isEmpty() || optionalTodo.isEmpty()) {
//            throw new RecordNotFoundException();
//        } else {
//            todo = optionalTodo.get();
//            project = optionalProject.get();
//
//            todo.assignProject(project);
//            projectRepository.save(project);
//        }
//        return fromProject(project);
//    }

//    public ProjectDto addNewEnrollToProject(Long enrollId, Long projectId) throws RecordNotFoundException {
//        Optional<Enroll> optionalEnroll = enrollRepository.findById(enrollId);
//        Optional<Project> optionalProject = projectRepository.findById(projectId);
//
//        Project project;
//        Enroll enroll;
//        if (optionalProject.isEmpty() || optionalEnroll.isEmpty()) {
//            throw new RecordNotFoundException();
//        } else {
//            enroll = optionalEnroll.get();
//            project = optionalProject.get();
//
//            enroll.assignProject(project);
//            projectRepository.save(project);
//        }
//        return fromProject(project);
//    }

    public String deleteProject(Project id) {
        projectRepository.deleteById(id.getId());
        return "Project removed !!" + id;
    }


    public static ProjectDto fromProject(Project project) {
        var dto = new ProjectDto();

        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setDate(project.getDate());
        dto.setLocation(project.getLocation());
        dto.setDescription(project.getDescription());

//        dto.setFile(project.getFile());

        dto.setTodos(project.getTodos());
        dto.setEnrolls(project.getEnrolls());

        return dto;
    }

    public static Project toProject(ProjectInputDto projectInputDto) {
        var project = new Project();

        project.setId(projectInputDto.getId());
        project.setName(projectInputDto.getName());
        project.setDate(projectInputDto.getDate());
        project.setLocation(projectInputDto.getLocation());
        project.setDescription(projectInputDto.getDescription());

//        project.setFile(projectInputDto.getFile());

        project.setTodos(projectInputDto.getTodos());
        project.setEnrolls(projectInputDto.getEnrolls());

        return project;
    }

}
