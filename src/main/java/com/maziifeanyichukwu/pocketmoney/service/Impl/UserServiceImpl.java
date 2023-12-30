package com.maziifeanyichukwu.pocketmoney.service.Impl;

import com.maziifeanyichukwu.pocketmoney.models.User;
import com.maziifeanyichukwu.pocketmoney.models.ValidationToken;
import com.maziifeanyichukwu.pocketmoney.repositories.TokenRepository;
import com.maziifeanyichukwu.pocketmoney.repositories.UserRepository;
import com.maziifeanyichukwu.pocketmoney.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenRepository tokenRepository;
    @Override
    @Transactional
    public User registerUser(User user) {
        String password = user.getPassword();
//        Encode aPassword
        String encoded = passwordEncoder.encode(password);
        user.setPassword(encoded);
//        boolean isMatch = passwordEncoder.matches(rawPassword, hashedPassword);
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) throw new RuntimeException("User with this email already exists");
            User savedUser = userRepository.save(user);
            return savedUser;

    }

    @Override
    public void saveValidationToken(User user, String token) {
        ValidationToken validationToken = new ValidationToken(token, user);
        tokenRepository.save(validationToken);

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
