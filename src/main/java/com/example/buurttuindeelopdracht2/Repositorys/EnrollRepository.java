package com.example.buurttuindeelopdracht2.Repositorys;

import com.example.buurttuindeelopdracht2.Entiteiten.Enroll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnrollRepository extends JpaRepository<Enroll, Long> {

    Optional<List<Enroll>> findByTenderIdIsContainingIgnoreCase(String username);

}
