package com.example.buurttuindeelopdracht2.Dtos;

import com.example.buurttuindeelopdracht2.Entiteiten.Project;

public class TodoDto {

    private Long id;

    private String nameTodo;
    private String definition;
    private Boolean isDone;

    private Project project;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameTodo() {
        return nameTodo;
    }

    public void setNameTodo(String nameTodo) {
        this.nameTodo = nameTodo;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean isdone) {
        isDone = isdone;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
