package com.example.buurttuindeelopdracht2.Controllers;

import com.example.buurttuindeelopdracht2.Dtos.GeneralMessagesDto;
import com.example.buurttuindeelopdracht2.Dtos.GeneralMessagesInputDto;
import com.example.buurttuindeelopdracht2.Dtos.UserDto;
import com.example.buurttuindeelopdracht2.Entiteiten.GeneralMessages;
import com.example.buurttuindeelopdracht2.Entiteiten.User;
import com.example.buurttuindeelopdracht2.Exceptions.RecordNotFoundException;
import com.example.buurttuindeelopdracht2.Services.GeneralMessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/generalMessages")
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

    @GetMapping("/allGeneralMessages")
    public List<GeneralMessagesDto> getAllGeneralMessages() {
        return generalMessagesService.getAllGeneralMessages();
    }

    @DeleteMapping("/deleteGeneralMessagesById/{id}")
    public String deleteGeneralMessages(@PathVariable GeneralMessages id) {
        return generalMessagesService.deleteGeneralMessages(id);
    }


}

