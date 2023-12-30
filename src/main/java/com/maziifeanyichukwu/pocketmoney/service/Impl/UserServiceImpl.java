package com.maziifeanyichukwu.pocketmoney.service.Impl;

import com.maziifeanyichukwu.pocketmoney.models.User;
import com.maziifeanyichukwu.pocketmoney.repositories.UserRepository;
import com.maziifeanyichukwu.pocketmoney.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User createNewUser(User user) {
//        String password = user.getPassword();
// Encode aPassword
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String hashedPassword = bCryptPasswordEncoder.encode(password);
//        user.setPassword(hashedPassword);
//        boolean isMatch = passwordEncoder.matches(rawPassword, hashedPassword);
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
    return users;
    }

    @Override
    public User getUserProfile(String userName) {
        User byUsername = userRepository.findByUserName(userName);
        return  byUsername;

    }

    @Override
    public User updateUserProfile(String userName, User user) {
        User updatedUser = userRepository.findByUserName(userName);
        updatedUser.setUserName(user.getUserName());
        updatedUser.setEmail(user.getUserName());
        updatedUser.setPassword(user.getPassword());
        userRepository.save(updatedUser);
        return updatedUser;

    }
}
