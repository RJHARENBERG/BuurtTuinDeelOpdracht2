package com.example.buurttuindeelopdracht2.Controllers;

import com.example.buurttuindeelopdracht2.Dtos.UserDto;
import com.example.buurttuindeelopdracht2.Dtos.UserInputDto;
import com.example.buurttuindeelopdracht2.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public UserDto addUser (@RequestBody UserInputDto userInputDto){
        return userService.addUser(userInputDto);
    }

    @GetMapping("/allUsers")
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }


}
