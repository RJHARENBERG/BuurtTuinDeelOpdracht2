package com.example.buurttuindeelopdracht2.Controllers;

import com.example.buurttuindeelopdracht2.Dtos.ResponseDto;
import com.example.buurttuindeelopdracht2.Dtos.ResponseInputDto;
import com.example.buurttuindeelopdracht2.Entiteiten.Response;
import com.example.buurttuindeelopdracht2.Entiteiten.Todo;
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

    @PostMapping("/addResponse")
    public ResponseDto addResponse(@RequestBody ResponseInputDto responseInputDto) {
        return responseService.addResponse(responseInputDto);
    }
    @DeleteMapping("/deleteResponseById/{id}")
    public String deleteResponse(@PathVariable Response id) {
        return responseService.deleteResponse(id);
    }
}
