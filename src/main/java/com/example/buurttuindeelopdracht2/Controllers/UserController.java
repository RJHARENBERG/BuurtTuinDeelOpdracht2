package com.example.buurttuindeelopdracht2.Controllers;

import com.example.buurttuindeelopdracht2.Dtos.UserDto;
import com.example.buurttuindeelopdracht2.Dtos.UserInputDto;
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
@RequestMapping(value = "/users")
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

    @PutMapping("/addNewTool/{tool_id}/ToUser/{username}")
    public UserDto addNewToolToUser(@PathVariable Long tool_id,
                                    @PathVariable String username) throws RecordNotFoundException {
        return userService.addNewToolToUser(tool_id, username);
    }

    @GetMapping("/findUserByUsername/{username}")
    public UserDto findUserById(@PathVariable String username) {
        return userService.getUser(username);
    }

    @DeleteMapping("/deleteUserById/{username}")
    public String deleteUser(@PathVariable String username) {
        return userService.deleteUser(username);
    }

    //    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @GetMapping(value = "/{userName}/authorities")
    public ResponseEntity<Object> getUserAuthorities(@PathVariable("userName") String username) throws RecordNotFoundException {
        return ResponseEntity.ok().body(userService.getAuthorities(username));
    }

    @PostMapping(value = "/{username}/authorities")
    public ResponseEntity<Object> addUserAuthority(@PathVariable("username") String username,
                                                   @RequestBody Map<String, Object> fields) {
        try {
            String authorityName = (String) fields.get("authority");
            userService.addAuthority(username, authorityName);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            throw new BadRequestException();
        }
    }

    @DeleteMapping(value = "/{username}/authorities/{authority}")
    public ResponseEntity<Object> deleteUserAuthority(@PathVariable("username") String userName,
                                                      @PathVariable("authority") String authority) throws RecordNotFoundException {
        userService.removeAuthority(userName, authority);
        return ResponseEntity.noContent().build();
    }

//    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


}
