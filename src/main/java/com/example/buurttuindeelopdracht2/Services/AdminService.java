package com.example.buurttuindeelopdracht2.Services;

import com.example.buurttuindeelopdracht2.Dtos.AdminDto;
import com.example.buurttuindeelopdracht2.Dtos.AdminInputDto;
import com.example.buurttuindeelopdracht2.Entiteiten.Admin;
import com.example.buurttuindeelopdracht2.Repositorys.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public AdminDto addAdmin(AdminInputDto adminInputDto) {
        Admin admin = toAdmin(adminInputDto);
        adminRepository.save(admin);
        return fromAdmin(admin);
    }

    public static AdminDto fromAdmin(Admin admin) {
        var dto = new AdminDto();

        dto.setId(admin.getId());
        dto.setName(admin.getName());

        return dto;
    }

    public static Admin toAdmin(AdminInputDto adminInputDto) {
        var admin = new Admin();

        admin.setId(adminInputDto.getId());
        admin.setName(adminInputDto.getName());

        return admin;
    }
}
