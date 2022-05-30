package com.example.buurttuindeelopdracht2.Services;

import com.example.buurttuindeelopdracht2.Dtos.GeneralMessagesDto;
import com.example.buurttuindeelopdracht2.Dtos.GeneralMessagesInputDto;
import com.example.buurttuindeelopdracht2.Dtos.ToolDto;
import com.example.buurttuindeelopdracht2.Dtos.ToolInputDto;
import com.example.buurttuindeelopdracht2.Entiteiten.GeneralMessages;
import com.example.buurttuindeelopdracht2.Entiteiten.Tool;
import com.example.buurttuindeelopdracht2.Repositorys.GeneralMessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneralMessagesService {

    private final GeneralMessagesRepository generalMessagesRepository;

    @Autowired
    public GeneralMessagesService(GeneralMessagesRepository generalMessagesRepository) {
        this.generalMessagesRepository = generalMessagesRepository;
    }


    public GeneralMessagesDto addGeneralMessages(GeneralMessagesInputDto generalMessagesInputDto) {
        GeneralMessages generalMessages = toGeneralMessages(generalMessagesInputDto);
        generalMessagesRepository.save(generalMessages);
        return fromGeneralMessages(generalMessages);
    }


    public static GeneralMessagesDto fromGeneralMessages(GeneralMessages generalMessages) {
        var dto = new GeneralMessagesDto();

        dto.setId(generalMessages.getId());
        dto.setTitle(generalMessages.getTitle());
        dto.setMessage(generalMessages.getMessage());

        return dto;
    }

    public static GeneralMessages toGeneralMessages(GeneralMessagesInputDto GeneralMessagesInputDto) {
        var generalMessages = new GeneralMessages();

        generalMessages.setId(GeneralMessagesInputDto.getId());
        generalMessages.setTitle(GeneralMessagesInputDto.getTitle());
        generalMessages.setMessage(generalMessages.getMessage());

        return generalMessages;
    }


}
