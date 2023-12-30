package com.maziifeanyichukwu.pocketmoney.controllers;

// add individual response Status and exceptions later later
import com.maziifeanyichukwu.pocketmoney.dto.UserDto;
import com.maziifeanyichukwu.pocketmoney.models.User;
import com.maziifeanyichukwu.pocketmoney.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public Map<String,String> createNewUser(@RequestBody User user){
        User newUser = userService.createNewUser(user);
        Map<String, String> responseDTO = new HashMap<>();
        responseDTO.put("response","User "+ user.getUserName() +" has been Successfully Created");
        return responseDTO;
    }
    @GetMapping
    public List<UserDto> getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        List<UserDto> userList = allUsers.stream().map(user -> UserDto.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .wallets(user.getWallets())
                .build()
        ).toList();
        return userList;
    }
    @GetMapping("/{userName}")
    public UserDto getUserProfile(@PathVariable String userName){
        User user = userService.getUserProfile(userName);
        UserDto userResponse = UserDto.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .wallets(user.getWallets())
                .build();
        return userResponse;
    }

    @PutMapping("/{userName}")
    public UserDto updateUserProfile(@PathVariable String userName, @RequestBody User user){
        User updatedUserProfile = userService.updateUserProfile(userName, user);
        UserDto userResponse = UserDto.builder()
                .userId(updatedUserProfile.getUserId())
                .userName(updatedUserProfile.getUserName())
                .email(updatedUserProfile.getEmail())
                .wallets(updatedUserProfile.getWallets())
                .build();
        return userResponse;
    }
}
