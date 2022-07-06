package com.example.buurttuindeelopdracht2.Controllers;
import com.example.buurttuindeelopdracht2.Dtos.*;
import com.example.buurttuindeelopdracht2.Entiteiten.Enroll;
import com.example.buurttuindeelopdracht2.Exceptions.RecordNotFoundException;
import com.example.buurttuindeelopdracht2.Services.EnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/enrolls")
public class EnrollController {

    private final EnrollService enrollService;

    @Autowired
    public EnrollController(EnrollService enrollService) {
        this.enrollService = enrollService;
    }

    @GetMapping("/allEnrolls")
    public List<EnrollDto> getAllEnrolls() {
        return enrollService.getAllEnrolls();
    }

    @PostMapping("/addEnroll/{project_id}")
    public EnrollDto addEnroll (@PathVariable Long project_id,
                                    @RequestBody EnrollInputDto enrollInputDto) throws RecordNotFoundException {
        return enrollService.addEnroll(enrollInputDto, project_id);
    }

    @DeleteMapping("/deleteEnrollById/{id}")
    public String deleteEnroll(@PathVariable Enroll id) {
        return enrollService.deleteEnroll(id);
    }

}
