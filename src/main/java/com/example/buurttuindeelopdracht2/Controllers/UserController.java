package com.example.buurttuindeelopdracht2.Controllers;

import com.example.buurttuindeelopdracht2.Dtos.UserDto;
import com.example.buurttuindeelopdracht2.Dtos.UserInputDto;
import com.example.buurttuindeelopdracht2.Entiteiten.User;
import com.example.buurttuindeelopdracht2.Exceptions.BadRequestException;
import com.example.buurttuindeelopdracht2.Exceptions.RecordNotFoundException;
import com.example.buurttuindeelopdracht2.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public UserDto addUser(@RequestBody UserInputDto userInputDto) {
        return userService.addUser(userInputDto);
    }

    @GetMapping("/allUsers")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/addNewTool/{tool_id}/ToUser/{userName}")
    public UserDto addNewToolToUser(@PathVariable Long tool_id,
                                    @PathVariable String userName) throws RecordNotFoundException {
        return userService.addNewToolToUser(tool_id, userName);
    }

    @GetMapping("/findUserById/{userName}")
    public UserDto findUserById(@PathVariable String userName) throws RecordNotFoundException {
        return userService.getUser(userName);
    }

    @DeleteMapping("/deleteUserById/{userName}")
    public String deleteUser(@PathVariable String userName) {
        return userService.deleteUser(userName);
    }

    //    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @GetMapping(value = "/{userName}/authorities")
    public ResponseEntity<Object> getUserAuthorities(@PathVariable("userName") String userName) throws RecordNotFoundException {
        return ResponseEntity.ok().body(userService.getAuthorities(userName));
    }

    @PostMapping(value = "/{userName}/authorities")
    public ResponseEntity<Object> addUserAuthority(@PathVariable("userName") String userName,
                                                   @RequestBody Map<String, Object> fields) {
        try {
            String authorityName = (String) fields.get("authority");
            userService.addAuthority(userName, authorityName);
            return ResponseEntity.noContent().build();
        } catch (Exception | RecordNotFoundException ex) {
            throw new BadRequestException();
        }
    }

    @DeleteMapping(value = "/{userName}/authorities/{authority}")
    public ResponseEntity<Object> deleteUserAuthority(@PathVariable("userName") String userName,
                                                      @PathVariable("authority") String authority) throws RecordNotFoundException {
        userService.removeAuthority(userName, authority);
        return ResponseEntity.noContent().build();
    }

//    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


}
