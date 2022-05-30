package com.example.buurttuindeelopdracht2.Services;

import com.example.buurttuindeelopdracht2.Dtos.ResponseDto;
import com.example.buurttuindeelopdracht2.Dtos.ResponseInputDto;
import com.example.buurttuindeelopdracht2.Entiteiten.Response;
import com.example.buurttuindeelopdracht2.Entiteiten.User;
import com.example.buurttuindeelopdracht2.Repositorys.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    private final ResponseRepository responseRepository;

    @Autowired
    public ResponseService(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }


    public ResponseDto addResponse(ResponseInputDto responseInputDto) {
        Response response = toResponse(responseInputDto);
        responseRepository.save(response);
        return fromResponse(response);
    }

    public String deleteResponse(Response id) {
        responseRepository.deleteById(id.getId());
        return "Response removed !!" + id;
    }
    public static ResponseDto fromResponse(Response response) {
        var dto = new ResponseDto();

        dto.setId(response.getId());
        dto.setMessengerId(response.getMessengerId());

        return dto;
    }

    public static Response toResponse(ResponseInputDto responseInputDto) {
        var response = new Response();

        response.setId(responseInputDto.getId());
        response.setMessengerId(responseInputDto.getMessengerId());

        return response;
    }


}
