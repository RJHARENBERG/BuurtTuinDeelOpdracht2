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
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    public UserDto getUser(String userName) {
        UserDto dto = new UserDto();
        Optional<User> user = userRepository.findById(userName);
        if (user.isPresent()){
            dto = fromUser(user.get());
        }else {
            throw new UsernameNotFoundException(userName);
        }
        return dto;
    }

    public UserDto addNewToolToUser(Long toolId, String userId) throws RecordNotFoundException {
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

    public String deleteUser(String id) {
        userRepository.deleteById(id);
        return "User removed !!" + id;
    }
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public boolean userExists(String userName) {
        return userRepository.existsById(userName);
    }

    public Set<Authority> getAuthorities(String userName) throws RecordNotFoundException {
        if (!userRepository.existsById(userName)) throw new RecordNotFoundException(userName);
        User user = userRepository.findById(userName).get();
        UserDto userDto = fromUser(user);
        return userDto.getAuthorities();
    }

    public void addAuthority(String username, String authority) throws RecordNotFoundException {

        if (!userRepository.existsById(username)) throw new RecordNotFoundException(username);
        User user = userRepository.findById(username).get();
        user.addAuthority(new Authority(username, authority));
        userRepository.save(user);
    }

    public void removeAuthority(String username, String authority) throws RecordNotFoundException {
        if (!userRepository.existsById(username)) throw new RecordNotFoundException(username);
        User user = userRepository.findById(username).get();
        Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();
        user.removeAuthority(authorityToRemove);
        userRepository.save(user);
    }





//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public static UserDto fromUser(User user) {
        var dto = new UserDto();

        dto.setUserName(user.getUserName());
        dto.setPassword(user.getPassword());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setZipcode(user.getZipcode());
        dto.setStreetName(user.getStreetName());
        dto.setHouseNumber(user.getHouseNumber());
        dto.setEmail(user.getEmail());

        dto.setTools(user.getTools());
        dto.setAuthorities(user.getAuthorities());
        return dto;
    }

    public static User toUser(UserInputDto userInputDto) {
        var user = new User();

        user.setUserName(userInputDto.getUserName());
        user.setPassword(userInputDto.getPassword());
        user.setFirstName(userInputDto.getFirstName());
        user.setLastName(userInputDto.getLastName());
        user.setZipcode(userInputDto.getZipcode());
        user.setStreetName(userInputDto.getStreetName());
        user.setHouseNumber(userInputDto.getHouseNumber());
        user.setEmail(userInputDto.getEmail());

        user.setTools(userInputDto.getTools());
        user.setAuthorities(userInputDto.getAuthorities());
        return user;
    }


}
