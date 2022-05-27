package com.example.buurttuindeelopdracht2.Repositorys;

import com.example.buurttuindeelopdracht2.Entiteiten.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
