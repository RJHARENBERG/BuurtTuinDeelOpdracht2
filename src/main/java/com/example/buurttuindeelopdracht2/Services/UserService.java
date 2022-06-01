package com.example.buurttuindeelopdracht2.Services;

import com.example.buurttuindeelopdracht2.Dtos.UserDto;
import com.example.buurttuindeelopdracht2.Dtos.UserInputDto;
import com.example.buurttuindeelopdracht2.Entiteiten.Authority;
import com.example.buurttuindeelopdracht2.Entiteiten.Tool;
import com.example.buurttuindeelopdracht2.Entiteiten.User;
import com.example.buurttuindeelopdracht2.Exceptions.RecordNotFoundException;
import com.example.buurttuindeelopdracht2.Repositorys.ToolRepository;
import com.example.buurttuindeelopdracht2.Repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ToolRepository toolRepository;

    @Autowired
    public UserService(UserRepository userRepository, ToolRepository toolRepository) {
        this.userRepository = userRepository;
        this.toolRepository = toolRepository;
    }

    public UserDto addUser(UserInputDto userInputDto) {
        User user = toUser(userInputDto);
        userRepository.save(user);
        return fromUser(user);
    }

    public List<UserDto> getAllUsers() {
        List<UserDto> userDtos = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (User user : users) {
            userDtos.add(fromUser(user));
        }
        return userDtos;
    }

    public UserDto getUserById(User id) throws RecordNotFoundException {
        User userFound = userRepository.getById(id.getId());
        if (userFound == null) {
            throw new RecordNotFoundException("cannot find user" + id);
        }
        return fromUser(userFound);
    }

    public UserDto addNewToolToUser(Long toolId, Long userId) throws RecordNotFoundException {
        Optional<Tool> optionalTool = toolRepository.findById(toolId);
        Optional<User> optionalUser = userRepository.findById(userId);

        User user;
        Tool tool;
        if (optionalUser.isEmpty() || optionalTool.isEmpty()) {
            throw new RecordNotFoundException();
        } else {
            tool = optionalTool.get();
            user = optionalUser.get();

            tool.assignUser(user);
            userRepository.save(user);
        }
        return fromUser(user);
    }

    public String deleteUser(User id) {
        userRepository.deleteById(id.getId());
        return "User removed !!" + id;
    }
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public boolean userExists(String userName) {
        return userRepository.existsById(userName);
    }

    public Set<Authority> getAuthorities(String userName) {
        if (!userRepository.existsById(userName)) throw new RecordNotFoundException(userName);
        User user = userRepository.findById(userName).get();
        UserDto userDto = fromUser(user);
        return userDto.getAuthorities();
    }

    public void addAuthority(String username, String authority) {

        if (!userRepository.existsById(username)) throw new RecordNotFoundException(username);
        User user = userRepository.findById(username).get();
        user.addAuthority(new Authority(username, authority));
        userRepository.save(user);
    }

    public void removeAuthority(String username, String authority) {
        if (!userRepository.existsById(username)) throw new RecordNotFoundException(username);
        User user = userRepository.findById(username).get();
        Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();
        user.removeAuthority(authorityToRemove);
        userRepository.save(user);
    }





//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public static UserDto fromUser(User user) {
        var dto = new UserDto();

        dto.setId(user.getId());
        dto.setUserName(user.getUserName());
        dto.setPassword(user.getPassword());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setZipcode(user.getZipcode());
        dto.setStreetName(user.getStreetName());
        dto.setHouseNumber(user.getHouseNumber());
        dto.setEmail(user.getEmail());

        dto.setTools(user.getTools());
        return dto;
    }

    public static User toUser(UserInputDto userInputDto) {
        var user = new User();

        user.setId(userInputDto.getId());
        user.setUserName(userInputDto.getUserName());
        user.setPassword(userInputDto.getPassword());
        user.setFirstName(userInputDto.getFirstName());
        user.setLastName(userInputDto.getLastName());
        user.setZipcode(userInputDto.getZipcode());
        user.setStreetName(userInputDto.getStreetName());
        user.setHouseNumber(userInputDto.getHouseNumber());
        user.setEmail(userInputDto.getEmail());

        user.setTools(userInputDto.getTools());
        return user;
    }


}
