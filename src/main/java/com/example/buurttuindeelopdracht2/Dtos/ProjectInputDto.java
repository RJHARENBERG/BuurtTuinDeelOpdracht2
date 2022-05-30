package com.example.buurttuindeelopdracht2.Dtos;

import com.example.buurttuindeelopdracht2.Entiteiten.Enroll;
import com.example.buurttuindeelopdracht2.Entiteiten.Todo;

import java.util.HashSet;
import java.util.Set;

public class ProjectInputDto {

    private Long id;

    private String name;
    private String date;
    private String location;

    private Set<Enroll> enrolls = new HashSet<>();
    private Set<Todo> todos =new HashSet<>();

    public Set<Enroll> getEnrolls() {
        return enrolls;
    }

    public void setEnrolls(Set<Enroll> enrolls) {
        this.enrolls = enrolls;
    }

    public Set<Todo> getTodos() {
        return todos;
    }

    public void setTodos(Set<Todo> todos) {
        this.todos = todos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
