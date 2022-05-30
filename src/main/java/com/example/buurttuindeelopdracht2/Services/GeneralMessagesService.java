package com.example.buurttuindeelopdracht2.Services;

import com.example.buurttuindeelopdracht2.Dtos.GeneralMessagesDto;
import com.example.buurttuindeelopdracht2.Dtos.GeneralMessagesInputDto;
import com.example.buurttuindeelopdracht2.Entiteiten.GeneralMessages;
import com.example.buurttuindeelopdracht2.Entiteiten.Response;
import com.example.buurttuindeelopdracht2.Exceptions.RecordNotFoundException;
import com.example.buurttuindeelopdracht2.Repositorys.GeneralMessagesRepository;
import com.example.buurttuindeelopdracht2.Repositorys.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GeneralMessagesService {

    private final GeneralMessagesRepository generalMessagesRepository;
    private final ResponseRepository responseRepository;

    @Autowired
    public GeneralMessagesService(GeneralMessagesRepository generalMessagesRepository,
                                  ResponseRepository responseRepository) {
        this.generalMessagesRepository = generalMessagesRepository;
        this.responseRepository = responseRepository;
    }


    public GeneralMessagesDto addGeneralMessages(GeneralMessagesInputDto generalMessagesInputDto) {
        GeneralMessages generalMessages = toGeneralMessages(generalMessagesInputDto);
        generalMessagesRepository.save(generalMessages);
        return fromGeneralMessages(generalMessages);
    }


    public GeneralMessagesDto addNewResponseToGeneralMessages(Long responseId, Long generalMessagesId)
            throws RecordNotFoundException {
        Optional<Response> optionalResponse = responseRepository.findById(responseId);
        Optional<GeneralMessages> optionalGeneralMessages = generalMessagesRepository.findById(generalMessagesId);

        GeneralMessages generalMessages;
        Response response;
        if (optionalGeneralMessages.isEmpty() || optionalResponse.isEmpty()) {
            throw new RecordNotFoundException();
        } else {
            response = optionalResponse.get();
            generalMessages = optionalGeneralMessages.get();

            response.assignGeneralMessages(generalMessages);
            generalMessagesRepository.save(generalMessages);
        }
        return fromGeneralMessages(generalMessages);
    }


    public static GeneralMessagesDto fromGeneralMessages(GeneralMessages generalMessages) {
        var dto = new GeneralMessagesDto();

        dto.setId(generalMessages.getId());
        dto.setTitle(generalMessages.getTitle());
        dto.setMessage(generalMessages.getMessage());

        dto.setResponses(generalMessages.getResponses());

        return dto;
    }

    public static GeneralMessages toGeneralMessages(GeneralMessagesInputDto generalMessagesInputDto) {
        var generalMessages = new GeneralMessages();

        generalMessages.setId(generalMessagesInputDto.getId());
        generalMessages.setTitle(generalMessagesInputDto.getTitle());
        generalMessages.setMessage(generalMessages.getMessage());

        generalMessages.setResponses(generalMessagesInputDto.getResponses());

        return generalMessages;
    }



}
