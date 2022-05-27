package com.example.buurttuindeelopdracht2.Controllers;

import com.example.buurttuindeelopdracht2.Dtos.ReservationDto;
import com.example.buurttuindeelopdracht2.Dtos.ReservationInputDto;
import com.example.buurttuindeelopdracht2.Dtos.ToolDto;
import com.example.buurttuindeelopdracht2.Entiteiten.Reservation;
import com.example.buurttuindeelopdracht2.Entiteiten.User;
import com.example.buurttuindeelopdracht2.Services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @PostMapping("/addReservation")
    public ReservationDto addReservation (@RequestBody ReservationInputDto reservationInputDto){
        return reservationService.addReservation(reservationInputDto);
    }

    @GetMapping("/allReservation")
    public List<ReservationDto> getAllReservations(){
        return reservationService.getAllReservations();
    }

    @DeleteMapping("/deleteReservationById/{id}")
    public String deleteReservation(@PathVariable Reservation id) {
        return reservationService.deleteReservation(id);
    }
}
