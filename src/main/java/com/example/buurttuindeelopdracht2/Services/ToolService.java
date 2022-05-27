package com.example.buurttuindeelopdracht2.Services;

import com.example.buurttuindeelopdracht2.Dtos.ToolDto;
import com.example.buurttuindeelopdracht2.Dtos.ToolInputDto;
import com.example.buurttuindeelopdracht2.Entiteiten.Tool;
import com.example.buurttuindeelopdracht2.Repositorys.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToolService {

    private final ToolRepository toolRepository;

    @Autowired
    public ToolService(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    public ToolDto addTool(ToolInputDto toolInputDto) {
        Tool tool = toTool(toolInputDto);
        toolRepository.save(tool);
        return fromTool(tool);
    }

    public static ToolDto fromTool(Tool tool) {
        var dto = new ToolDto();

        dto.setId(tool.getId());
        dto.setToolName(tool.getToolName());
        dto.setType(tool.getType());
        dto.setDescription(tool.getDescription());

        return dto;
    }

    public static Tool toTool(ToolInputDto toolInputDto) {
        var tool = new Tool();

        tool.setId(toolInputDto.getId());
        tool.setToolName(toolInputDto.getToolName());
        tool.setType(toolInputDto.getType());
        tool.setToolName(toolInputDto.getToolName());

        return tool;
    }
}
