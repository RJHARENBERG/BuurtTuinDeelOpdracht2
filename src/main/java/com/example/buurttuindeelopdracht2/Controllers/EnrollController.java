package com.example.buurttuindeelopdracht2.Controllers;

import com.example.buurttuindeelopdracht2.Dtos.EnrollDto;
import com.example.buurttuindeelopdracht2.Dtos.EnrollInputDto;
import com.example.buurttuindeelopdracht2.Services.EnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrollController {

    private final EnrollService enrollService;

    @Autowired
    public EnrollController(EnrollService enrollService) {
        this.enrollService = enrollService;
    }

    @PostMapping("/addEnroll")
    public EnrollDto addEnroll (@RequestBody EnrollInputDto enrollInputDto){
        return enrollService.addEnroll(enrollInputDto);
    }

}
