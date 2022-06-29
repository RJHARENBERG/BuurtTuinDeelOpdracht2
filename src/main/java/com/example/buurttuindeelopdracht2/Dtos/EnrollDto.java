package com.example.buurttuindeelopdracht2.Dtos;

import com.example.buurttuindeelopdracht2.Entiteiten.Project;

public class EnrollDto {

    private Long id;
    private String tenderId;

    private Project project;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenderId() {
        return tenderId;
    }

    public void setTenderId(String tenderId) {
        this.tenderId = tenderId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
