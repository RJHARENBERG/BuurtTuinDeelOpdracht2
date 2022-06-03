package com.example.buurttuindeelopdracht2.Repositorys;

import com.example.buurttuindeelopdracht2.Entiteiten.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
