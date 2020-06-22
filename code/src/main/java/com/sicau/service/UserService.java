package com.sicau.service;

import com.sicau.pojo.UOrder;
import com.sicau.pojo.User;

/**
 *
 */
public interface UserService {
    UOrder getUserDataByUName(String uName);
    User registerUser(String uName, String uPass);
    User getUserByUNameAndUPass(User user);
}
