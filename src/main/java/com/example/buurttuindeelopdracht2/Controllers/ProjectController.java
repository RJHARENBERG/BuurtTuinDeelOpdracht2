package com.example.buurttuindeelopdracht2.Controllers;

import com.example.buurttuindeelopdracht2.Dtos.ProjectDto;
import com.example.buurttuindeelopdracht2.Dtos.ProjectInputDto;
import com.example.buurttuindeelopdracht2.Dtos.ToolDto;
import com.example.buurttuindeelopdracht2.Entiteiten.Project;
import com.example.buurttuindeelopdracht2.Entiteiten.User;
import com.example.buurttuindeelopdracht2.Exceptions.RecordNotFoundException;
import com.example.buurttuindeelopdracht2.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

//    @PutMapping("/addNewTodo/{todo_id}/ToProject/{project_id}")
//    public ProjectDto addNewTodoToProject(@PathVariable Long todo_id,
//                                           @PathVariable Long project_id) throws RecordNotFoundException {
//        return projectService.addNewTodoToProject(todo_id, project_id);
//    }

//    @PutMapping("/addNewEnroll/{enroll_id}/ToProject/{project_id}")
//    public ProjectDto addNewEnrollToProject(@PathVariable Long enroll_id,
//                                          @PathVariable Long project_id) throws RecordNotFoundException {
//        return projectService.addNewEnrollToProject(enroll_id, project_id);
//    }

    @DeleteMapping("/deleteProjectById/{id}")
    public String deleteProject(@PathVariable Project id) {
        return projectService.deleteProject(id);
    }
}



