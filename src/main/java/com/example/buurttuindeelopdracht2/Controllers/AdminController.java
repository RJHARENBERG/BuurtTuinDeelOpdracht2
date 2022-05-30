package com.example.buurttuindeelopdracht2.Controllers;

import com.example.buurttuindeelopdracht2.Dtos.AdminDto;
import com.example.buurttuindeelopdracht2.Dtos.AdminInputDto;
import com.example.buurttuindeelopdracht2.Dtos.EnrollDto;
import com.example.buurttuindeelopdracht2.Dtos.EnrollInputDto;
import com.example.buurttuindeelopdracht2.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/addAdmin")
    public AdminDto addAdmin (@RequestBody AdminInputDto adminInputDto){
        return adminService.addAdmin(adminInputDto);
    }
}
