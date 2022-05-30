package com.example.buurttuindeelopdracht2.Services;

import com.example.buurttuindeelopdracht2.Dtos.EnrollDto;
import com.example.buurttuindeelopdracht2.Dtos.EnrollInputDto;
import com.example.buurttuindeelopdracht2.Dtos.ToolDto;
import com.example.buurttuindeelopdracht2.Dtos.ToolInputDto;
import com.example.buurttuindeelopdracht2.Entiteiten.Enroll;
import com.example.buurttuindeelopdracht2.Entiteiten.GeneralMessages;
import com.example.buurttuindeelopdracht2.Entiteiten.Tool;
import com.example.buurttuindeelopdracht2.Repositorys.EnrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollService {

    private final EnrollRepository enrollRepository;

    @Autowired
    public EnrollService(EnrollRepository enrollRepository) {
        this.enrollRepository = enrollRepository;
    }

    public EnrollDto addEnroll(EnrollInputDto enrollInputDto) {
        Enroll enroll = toEnroll(enrollInputDto);
        enrollRepository.save(enroll);
        return fromEnroll(enroll);
    }

    public String deleteEnroll(Enroll id) {
        enrollRepository.deleteById(id.getId());
        return "Enroll removed !!" + id;
    }

    public static EnrollDto fromEnroll(Enroll enroll) {
        var dto = new EnrollDto();

        dto.setId(enroll.getId());
        dto.setTenderId(enroll.getTenderId());

        dto.setProject(enroll.getProject());

        return dto;
    }

    public static Enroll toEnroll(EnrollInputDto enrollInputDto) {
        var enroll = new Enroll();

        enroll.setId(enrollInputDto.getId());
        enroll.setTenderId(enrollInputDto.getTenderId());

        enroll.setProject(enrollInputDto.getProject());

        return enroll;
    }


}
