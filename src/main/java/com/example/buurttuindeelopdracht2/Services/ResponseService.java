package com.example.buurttuindeelopdracht2.Services;

import com.example.buurttuindeelopdracht2.Dtos.ResponseDto;
import com.example.buurttuindeelopdracht2.Dtos.ResponseInputDto;
import com.example.buurttuindeelopdracht2.Entiteiten.*;
import com.example.buurttuindeelopdracht2.Exceptions.RecordNotFoundException;
import com.example.buurttuindeelopdracht2.Repositorys.GeneralMessagesRepository;
import com.example.buurttuindeelopdracht2.Repositorys.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    private final ResponseRepository responseRepository;
    private final GeneralMessagesRepository generalMessagesRepository;

    @Autowired
    public ResponseService(ResponseRepository responseRepository,
                           GeneralMessagesRepository generalMessagesRepository) {
        this.responseRepository = responseRepository;
        this.generalMessagesRepository = generalMessagesRepository;
    }


    public ResponseDto addResponse(ResponseInputDto responseInputDto) {
        Response response = toResponse(responseInputDto);
        responseRepository.save(response);
        return fromResponse(response);
    }

    public ResponseDto addResponse(ResponseInputDto responseInputDto, Long generalMessagesId) throws RecordNotFoundException {
        Response response = toResponse(responseInputDto);
        responseRepository.save(response);
        GeneralMessages generalMessages = generalMessagesRepository.findById(generalMessagesId).
                orElseThrow(() -> new RecordNotFoundException("generalMessages " + generalMessagesId + " doesn't exist"));
        response.assignGeneralMessages(generalMessages);
        generalMessagesRepository.save(generalMessages);

        return fromResponse(response);
    }

    public String deleteResponse(Response id) {
        responseRepository.deleteById(id.getId());
        return "Response removed !!" + id;
    }
    public static ResponseDto fromResponse(Response response) {
        var dto = new ResponseDto();

        dto.setId(response.getId());
        dto.setMessage(response.getMessage());
        dto.setMessengerId(response.getMessengerId());

        return dto;
    }

    public static Response toResponse(ResponseInputDto responseInputDto) {
        var response = new Response();

        response.setId(responseInputDto.getId());
        response.setMessage(responseInputDto.getMessage());
        response.setMessengerId(responseInputDto.getMessengerId());

        return response;
    }


}
