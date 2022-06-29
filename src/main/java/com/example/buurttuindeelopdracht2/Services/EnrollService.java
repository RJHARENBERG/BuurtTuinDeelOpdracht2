package com.example.buurttuindeelopdracht2.Services;

import com.example.buurttuindeelopdracht2.Dtos.*;
import com.example.buurttuindeelopdracht2.Entiteiten.*;
import com.example.buurttuindeelopdracht2.Exceptions.RecordNotFoundException;
import com.example.buurttuindeelopdracht2.Repositorys.EnrollRepository;
import com.example.buurttuindeelopdracht2.Repositorys.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollService {

    private final EnrollRepository enrollRepository;
    private final ProjectRepository projectRepository;

    @Autowired
    public EnrollService(EnrollRepository enrollRepository,
                         ProjectRepository projectRepository) {
        this.enrollRepository = enrollRepository;
        this.projectRepository = projectRepository;
    }

    public EnrollDto addEnroll(EnrollInputDto enrollInputDto, Long projectId) throws RecordNotFoundException {
        Enroll enroll = toEnroll(enrollInputDto);
        enrollRepository.save(enroll);
        Project project = projectRepository.findById(projectId).
                orElseThrow(() -> new RecordNotFoundException("project " + projectId + " doesn't exist"));
        enroll.assignProject(project);
        projectRepository.save(project);

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
