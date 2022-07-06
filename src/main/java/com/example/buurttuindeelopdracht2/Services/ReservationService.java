package com.example.buurttuindeelopdracht2.Services;

import com.example.buurttuindeelopdracht2.Dtos.*;
import com.example.buurttuindeelopdracht2.Entiteiten.Reservation;
import com.example.buurttuindeelopdracht2.Entiteiten.Tool;
import com.example.buurttuindeelopdracht2.Exceptions.RecordNotFoundException;
import com.example.buurttuindeelopdracht2.Repositorys.ReservationRepository;
import com.example.buurttuindeelopdracht2.Repositorys.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ToolRepository toolRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository,
                              ToolRepository toolRepository) {
        this.reservationRepository = reservationRepository;
        this.toolRepository = toolRepository;
    }

    public ReservationDto addReservation(ReservationInputDto reservationInputDto, Long toolId) throws RecordNotFoundException {
        Reservation reservation = toReservation(reservationInputDto);
        reservationRepository.save(reservation);
        Tool tool = toolRepository.findById(toolId).
                orElseThrow(() -> new RecordNotFoundException("tool " + toolId + " doesn't exist"));
        reservation.assignTool(tool);
        toolRepository.save(tool);

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

    public String deleteReservation(Reservation id) {
        reservationRepository.deleteById(id.getId());
        return "User removed !!" + id;
    }

    public static ReservationDto fromReservation(Reservation reservation) {
        var dto = new ReservationDto();

        dto.setId(reservation.getId());
        dto.setStartDate(reservation.getStartDate());
        dto.setEndDate(reservation.getEndDate());
        dto.setBorrowerId(reservation.getBorrowerId());

        return dto;
    }

    public static Reservation toReservation(ReservationInputDto reservationInputDto) {
        var reservation = new Reservation();

        reservation.setId(reservationInputDto.getId());
        reservation.setStartDate(reservationInputDto.getStartDate());
        reservation.setEndDate(reservationInputDto.getEndDate());
        reservation.setBorrowerId(reservationInputDto.getBorrowerId());

        return reservation;
    }
}
