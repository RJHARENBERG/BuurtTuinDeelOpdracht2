package com.example.buurttuindeelopdracht2.Entiteiten;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Enroll {

    @Id
    @GeneratedValue
    private Long id;
    private String tenderId;

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

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

    public String getTenderId() {
        return tenderId;
    }

    public void setTenderId(String tenderId) {
        this.tenderId = tenderId;
    }

    public void assignProject(Project project) {
        this.project = project;
    }
}
