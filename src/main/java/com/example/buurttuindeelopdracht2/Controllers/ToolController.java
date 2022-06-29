package com.example.buurttuindeelopdracht2.Controllers;

import com.example.buurttuindeelopdracht2.Dtos.ToolDto;
import com.example.buurttuindeelopdracht2.Dtos.ToolInputDto;
import com.example.buurttuindeelopdracht2.Dtos.UserDto;
import com.example.buurttuindeelopdracht2.Entiteiten.Tool;
import com.example.buurttuindeelopdracht2.Entiteiten.User;
import com.example.buurttuindeelopdracht2.Exceptions.RecordNotFoundException;
import com.example.buurttuindeelopdracht2.Services.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/tools")
public class ToolController {

    private final ToolService toolService;

    @Autowired
    public ToolController(ToolService toolService) {
        this.toolService = toolService;
    }

    @PostMapping("/addTool/{username}")
    public ToolDto addTool (@PathVariable String username,
                            @RequestBody ToolInputDto toolInputDto) throws RecordNotFoundException {
        return toolService.addTool(toolInputDto, username);
    }

    @GetMapping("/allTools")
    public List<ToolDto> getAllTools(){
        return toolService.getAllTools();
    }

    @DeleteMapping("/deleteToolById/{id}")
    public String deleteTool(@PathVariable Tool id) {
        return toolService.deleteTool(id);
    }

}
