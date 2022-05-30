package com.example.buurttuindeelopdracht2.Services;

import com.example.buurttuindeelopdracht2.Dtos.ToolDto;
import com.example.buurttuindeelopdracht2.Dtos.ToolInputDto;
import com.example.buurttuindeelopdracht2.Entiteiten.Reservation;
import com.example.buurttuindeelopdracht2.Entiteiten.Tool;
import com.example.buurttuindeelopdracht2.Exceptions.RecordNotFoundException;
import com.example.buurttuindeelopdracht2.Repositorys.ReservationRepository;
import com.example.buurttuindeelopdracht2.Repositorys.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ToolService {

    private final ToolRepository toolRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ToolService(ToolRepository toolRepository, ReservationRepository reservationRepository) {
        this.toolRepository = toolRepository;
        this.reservationRepository = reservationRepository;
    }

    public ToolDto addTool(ToolInputDto toolInputDto) {
        Tool tool = toTool(toolInputDto);
        toolRepository.save(tool);
        return fromTool(tool);
    }

    public List<ToolDto> getAllTools() {
        List<ToolDto> toolDtos = new ArrayList<>();
        List<Tool> tools = toolRepository.findAll();
        for (Tool tool : tools) {
            toolDtos.add(fromTool(tool));
        }
        return toolDtos;
    }

    public ToolDto addNewReservationToTool(Long reservationId, Long toolId) throws RecordNotFoundException {
        Optional<Reservation> optionalReservation = reservationRepository.findById(reservationId);
        Optional<Tool> optionalTool = toolRepository.findById(toolId);

        Tool tool;
        Reservation reservation;
        if (optionalTool.isEmpty() || optionalReservation.isEmpty()) {
            throw new RecordNotFoundException();
        } else {
            reservation = optionalReservation.get();
            tool = optionalTool.get();

            reservation.assignTool(tool);
            toolRepository.save(tool);
        }
        return fromTool(tool);
    }

    public String deleteTool(Tool id) {
        toolRepository.deleteById(id.getId());
        return "Tool removed !!" + id;
    }

    public static ToolDto fromTool(Tool tool) {
        var dto = new ToolDto();

        dto.setId(tool.getId());
        dto.setToolName(tool.getToolName());
        dto.setType(tool.getType());
        dto.setDescription(tool.getDescription());

        dto.setReservations(tool.getReservations());

        return dto;
    }

    public static Tool toTool(ToolInputDto toolInputDto) {
        var tool = new Tool();

        tool.setId(toolInputDto.getId());
        tool.setToolName(toolInputDto.getToolName());
        tool.setType(toolInputDto.getType());
        tool.setDescription(toolInputDto.getDescription());

        tool.setReservations(toolInputDto.getReservations());

        return tool;
    }
}
