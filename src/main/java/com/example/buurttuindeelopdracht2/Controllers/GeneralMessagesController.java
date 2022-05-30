package com.example.buurttuindeelopdracht2.Controllers;

import com.example.buurttuindeelopdracht2.Dtos.GeneralMessagesDto;
import com.example.buurttuindeelopdracht2.Dtos.GeneralMessagesInputDto;
import com.example.buurttuindeelopdracht2.Exceptions.RecordNotFoundException;
import com.example.buurttuindeelopdracht2.Services.GeneralMessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/addNewResponse/{response_id}/ToGeneralMessages/{generalMessages_id}")
    public GeneralMessagesDto addNewResponseToGeneralMessages(@PathVariable Long response_id,
                                           @PathVariable Long generalMessages_id) throws RecordNotFoundException {
        return generalMessagesService.addNewResponseToGeneralMessages(response_id, generalMessages_id);
    }
}

