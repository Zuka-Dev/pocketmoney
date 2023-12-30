package com.maziifeanyichukwu.pocketmoney.service;

import com.maziifeanyichukwu.pocketmoney.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
   User createNewUser(User user);

   List<User> getAllUsers();
   User getUserProfile(String userName);

   User updateUserProfile(String userName, User user);
}
