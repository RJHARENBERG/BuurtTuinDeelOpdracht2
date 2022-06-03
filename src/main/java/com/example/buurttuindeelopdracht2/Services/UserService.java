package com.example.buurttuindeelopdracht2.Services;

import com.example.buurttuindeelopdracht2.Dtos.UserDto;
import com.example.buurttuindeelopdracht2.Dtos.UserInputDto;
import com.example.buurttuindeelopdracht2.Entiteiten.Tool;
import com.example.buurttuindeelopdracht2.Entiteiten.User;
import com.example.buurttuindeelopdracht2.Exceptions.RecordNotFoundException;
import com.example.buurttuindeelopdracht2.Repositorys.ToolRepository;
import com.example.buurttuindeelopdracht2.Repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

//    public UserDto getUserById(String userName) throws RecordNotFoundException {
//        User userFound = userRepository.getById(userName);
//        if (userFound == null) {
//            throw new RecordNotFoundException("cannot find user" + userName);
//        }
//        return fromUser(userFound);
//    }

    public UserDto getUser(String username) {
        UserDto dto = new UserDto();
        Optional<User> user = userRepository.findById(username);
        if (user.isPresent()){
            dto = fromUser(user.get());
        }else {
            throw new UsernameNotFoundException(username);
        }
        return dto;
    }

    public UserDto addNewToolToUser(Long toolId, String userName) throws RecordNotFoundException {
        Optional<Tool> optionalTool = toolRepository.findById(toolId);
        Optional<User> optionalUser = userRepository.findById(userName);

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

    public String deleteUser(String id) {
        userRepository.deleteById(id);
        return "User removed !!" + id;
    }


    public static UserDto fromUser(User user) {
        var dto = new UserDto();

        dto.setUserName(user.getUserName());
        dto.setPassword(user.getPassword());
        dto.setEnabled(user.getEnabled());
        dto.setRole(user.getRole());

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

        user.setUserName(userInputDto.getUserName());
        user.setPassword(userInputDto.getPassword());
        user.setEnabled(userInputDto.getEnabled());
        user.setRole(userInputDto.getRole());

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
