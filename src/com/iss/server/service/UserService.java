package com.iss.server.service;

import com.iss.server.dao.UserDao;
import com.iss.server.model.User;

public class UserService {
    private static UserDao userDao = new UserDao();

    public static boolean exists(User user) {
        return userDao.query(user);
    }

}
