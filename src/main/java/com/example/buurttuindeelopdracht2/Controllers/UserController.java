package com.example.buurttuindeelopdracht2.Controllers;

import com.example.buurttuindeelopdracht2.Dtos.UserDto;
import com.example.buurttuindeelopdracht2.Dtos.UserInputDto;
import com.example.buurttuindeelopdracht2.Entiteiten.User;
import com.example.buurttuindeelopdracht2.Exceptions.RecordNotFoundException;
import com.example.buurttuindeelopdracht2.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/addNewTool/{tool_id}/ToUser/{user_id}")
    public UserDto addNewToolToUser(@PathVariable Long tool_id,
                                    @PathVariable Long user_id) throws RecordNotFoundException {
        return userService.addNewToolToUser(tool_id, user_id);
    }

    @GetMapping("/findUserById/{id}")
    public UserDto findUserById(@PathVariable User id) throws RecordNotFoundException {
        return userService.getUserById(id);
    }

    @DeleteMapping("/deleteUserById/{id}")
    public String deleteUser(@PathVariable User id) {
        return userService.deleteUser(id);
    }



}
