package com.example.buurttuindeelopdracht2.Controllers;

import com.example.buurttuindeelopdracht2.Dtos.ToolDto;
import com.example.buurttuindeelopdracht2.Dtos.ToolInputDto;
import com.example.buurttuindeelopdracht2.Dtos.UserDto;
import com.example.buurttuindeelopdracht2.Exceptions.RecordNotFoundException;
import com.example.buurttuindeelopdracht2.Services.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToolController {

    private final ToolService toolService;

    @Autowired
    public ToolController(ToolService toolService) {
        this.toolService = toolService;
    }

    @PostMapping("/addTool")
    public ToolDto addTool (@RequestBody ToolInputDto toolInputDto){
        return toolService.addTool(toolInputDto);
    }

    @GetMapping("/allTools")
    public List<ToolDto> getAllTools(){
        return toolService.getAllTools();
    }

    @PutMapping("/addNewReservation/{reservation_id}/ToTool/{tool_id}")
    public ToolDto addNewReservationToUser(@PathVariable Long reservation_id,
                                    @PathVariable Long tool_id) throws RecordNotFoundException {
        return toolService.addNewReservationToTool(reservation_id, tool_id);
    }
}
