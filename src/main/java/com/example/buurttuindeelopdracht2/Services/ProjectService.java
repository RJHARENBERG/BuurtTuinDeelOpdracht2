package com.example.buurttuindeelopdracht2.Services;

import com.example.buurttuindeelopdracht2.Dtos.ProjectDto;
import com.example.buurttuindeelopdracht2.Dtos.ProjectInputDto;
import com.example.buurttuindeelopdracht2.Entiteiten.Project;
import com.example.buurttuindeelopdracht2.Repositorys.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public ProjectDto addProject(ProjectInputDto projectInputDto) {
        Project project = toProject(projectInputDto);
        projectRepository.save(project);
        return fromProject(project);
    }

    public static ProjectDto fromProject(Project project) {
        var dto = new ProjectDto();

        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setDate(project.getDate());
        dto.setLocation(project.getLocation());

        return dto;
    }

    public static Project toProject(ProjectInputDto projectInputDto) {
        var project = new Project();

        project.setId(projectInputDto.getId());
        project.setName(projectInputDto.getName());
        project.setDate(projectInputDto.getDate());
        project.setLocation(project.getLocation());

        return project;
    }

}
