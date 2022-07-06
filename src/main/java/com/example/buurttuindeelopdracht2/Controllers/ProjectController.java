package com.example.buurttuindeelopdracht2.Controllers;

import com.example.buurttuindeelopdracht2.Dtos.ProjectDto;
import com.example.buurttuindeelopdracht2.Dtos.ProjectInputDto;
import com.example.buurttuindeelopdracht2.Dtos.ToolDto;
import com.example.buurttuindeelopdracht2.Dtos.UserDto;
import com.example.buurttuindeelopdracht2.Entiteiten.Enroll;
import com.example.buurttuindeelopdracht2.Entiteiten.Project;
import com.example.buurttuindeelopdracht2.Entiteiten.User;
import com.example.buurttuindeelopdracht2.Exceptions.RecordNotFoundException;
import com.example.buurttuindeelopdracht2.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    private final ProjectService projectService;
    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/addProject")
    public ProjectDto addProject (@RequestBody ProjectInputDto projectInputDto){
        return projectService.addProject(projectInputDto);

    }

    @GetMapping("/allProjects")
    public List< ProjectDto> getAllProjects(){
        return  projectService.getAllProjects();
    }


    @GetMapping("/projects/{tender_id}")
    public Optional<List<Enroll>> getAllProjects(@PathVariable String tender_id){
        return  projectService.findProjectsByTenderId(tender_id);
    }


    @GetMapping("/findProjectById/{project_id}")
    public ProjectDto findProjectById(@PathVariable long project_id) throws RecordNotFoundException {
        return projectService.getProject(project_id);
    }

    @DeleteMapping("/deleteProjectById/{id}")
    public String deleteProject(@PathVariable Project id) {
        return projectService.deleteProject(id);
    }
}



