package com.example.buurttuindeelopdracht2.Entiteiten;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String date;
    private String location;
    private String description;

//    @OneToOne
//    FileUploadResponse file;

    @OneToMany(mappedBy = "project")
    private Set<Enroll> enrolls = new HashSet<>();

    @OneToMany(mappedBy = "project")
    private Set<Todo> todos =new HashSet<>();

    public Set<Todo> getTodos() {
        return todos;
    }

    public void setTodos(Set<Todo> todos) {
        this.todos = todos;
    }

    public Set<Enroll> getEnrolls() {
        return enrolls;
    }

    public void setEnrolls(Set<Enroll> enrolls) {
        this.enrolls = enrolls;
    }

//    public FileUploadResponse getFile() {
//        return file;
//    }
//
//    public void setFile(FileUploadResponse file) {
//        this.file = file;
//    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
