package com.example.buurttuindeelopdracht2.Dtos;

import com.example.buurttuindeelopdracht2.Entiteiten.Reservation;

import java.util.HashSet;
import java.util.Set;

public class ToolInputDto {

    private Long id;

    private String toolName;
    private String type;
    //    private IMG
    private String description;

    private Set<Reservation> reservations = new HashSet<>();

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
