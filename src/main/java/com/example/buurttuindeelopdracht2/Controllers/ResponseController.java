package com.example.buurttuindeelopdracht2.Controllers;

import com.example.buurttuindeelopdracht2.Dtos.ReservationDto;
import com.example.buurttuindeelopdracht2.Dtos.ReservationInputDto;
import com.example.buurttuindeelopdracht2.Dtos.ResponseDto;
import com.example.buurttuindeelopdracht2.Dtos.ResponseInputDto;
import com.example.buurttuindeelopdracht2.Entiteiten.Response;
import com.example.buurttuindeelopdracht2.Entiteiten.Todo;
import com.example.buurttuindeelopdracht2.Exceptions.RecordNotFoundException;
import com.example.buurttuindeelopdracht2.Services.ResponseService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/responses")
public class ResponseController {

    private final ResponseService responseService;

    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @PostMapping("/addResponse/{generalMessages_id}")
    public ResponseDto addResponse (@PathVariable Long generalMessages_id,
                                    @RequestBody ResponseInputDto responseInputDto) throws RecordNotFoundException {
        return responseService.addResponse(responseInputDto, generalMessages_id);
    }

    @DeleteMapping("/deleteResponseById/{id}")
    public String deleteResponse(@PathVariable Response id) {
        return responseService.deleteResponse(id);
    }
}
