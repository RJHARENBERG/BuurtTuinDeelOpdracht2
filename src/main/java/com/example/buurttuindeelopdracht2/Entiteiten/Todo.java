package com.example.buurttuindeelopdracht2.Entiteiten;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Todo {
    @Id
    @GeneratedValue
    private Long id;

    private String nameTodo;
    private String definition;
    private Boolean isDone = false;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean isDone) {
        isDone = isDone;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

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

    public void assignProject(Project project) {
        this.project = project;
    }
}
