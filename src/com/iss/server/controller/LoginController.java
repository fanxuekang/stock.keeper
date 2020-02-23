package com.iss.server.controller;


import com.iss.server.model.User;
import com.iss.server.service.UserService;

/**
 * 用于控制试图和服务器端通信（前台页面） 和模型（服务端程序）
 */
public class LoginController {

    private static UserService userService = new UserService();
    public static boolean login(User user){
        return userService.exists(user);
    }
}
