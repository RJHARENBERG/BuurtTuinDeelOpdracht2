package com.example.buurttuindeelopdracht2.Controllers;

import com.example.buurttuindeelopdracht2.Dtos.GeneralMessagesDto;
import com.example.buurttuindeelopdracht2.Dtos.GeneralMessagesInputDto;
import com.example.buurttuindeelopdracht2.Dtos.ToolDto;
import com.example.buurttuindeelopdracht2.Dtos.ToolInputDto;
import com.example.buurttuindeelopdracht2.Services.GeneralMessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralMessagesController {

    private final GeneralMessagesService generalMessagesService;

    @Autowired
    public GeneralMessagesController(GeneralMessagesService generalMessagesService) {
        this.generalMessagesService = generalMessagesService;
    }

    @PostMapping("/addGeneralMessages")
    public GeneralMessagesDto addGeneralMessages (@RequestBody GeneralMessagesInputDto generalMessagesInputDto){
        return generalMessagesService.addGeneralMessages(generalMessagesInputDto);
    }
}
