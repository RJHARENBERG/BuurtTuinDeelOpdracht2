package com.example.buurttuindeelopdracht2.Services;

import com.example.buurttuindeelopdracht2.Dtos.ReservationDto;
import com.example.buurttuindeelopdracht2.Dtos.ReservationInputDto;
import com.example.buurttuindeelopdracht2.Dtos.ToolDto;
import com.example.buurttuindeelopdracht2.Dtos.ToolInputDto;
import com.example.buurttuindeelopdracht2.Entiteiten.Reservation;
import com.example.buurttuindeelopdracht2.Entiteiten.Tool;
import com.example.buurttuindeelopdracht2.Repositorys.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public ReservationDto addReservation(ReservationInputDto reservationInputDto) {
        Reservation reservation = toReservation(reservationInputDto);
        reservationRepository.save(reservation);
        return fromReservation(reservation);
    }

    public List<ReservationDto> getAllReservations() {
        List<ReservationDto> reservationDtos = new ArrayList<>();
        List<Reservation> reservations = reservationRepository.findAll();
        for (Reservation reservation : reservations) {
            reservationDtos.add(fromReservation(reservation));
        }
        return reservationDtos;
    }

    public static ReservationDto fromReservation(Reservation reservation) {
        var dto = new ReservationDto();

        dto.setId(reservation.getId());
        dto.setBorrowerId(reservation.getBorrowerId());

        return dto;
    }

    public static Reservation toReservation(ReservationInputDto reservationInputDto) {
        var reservation = new Reservation();

        reservation.setId(reservationInputDto.getId());
        reservation.setBorrowerId(reservationInputDto.getBorrowerId());

        return reservation;
    }



}
