package com.example.buurttuindeelopdracht2.Repositorys;

import com.example.buurttuindeelopdracht2.Entiteiten.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository< Todo, Long> {
}
