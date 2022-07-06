package com.example.buurttuindeelopdracht2.Repositorys;

import com.example.buurttuindeelopdracht2.Entiteiten.Project;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
