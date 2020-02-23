package com.iss.client.view;

import com.iss.client.router.Router;
import com.iss.client.view.Component.StockWindow;
import com.iss.server.controller.LoginController;
import com.iss.server.model.User;

import java.util.Scanner;

/**
 * client
 * 1. 接受用户输入的用户名和密码，
 * 2. 把用户名和密码发送给服务器，
 * <p>
 * server
 * 3.服务器接收用户名和密码
 * 4.服务器校验用户密码是否正确，并返回校验信息，
 * <p>
 * client
 * 4. 页面接受返回信息，做相关处理
 */
public class Login extends StockWindow {
    private static StockList stockList = new StockList();

    private Router router = new Router();

    public void display() {
        User user = getLoginInfo();
        boolean flag = LoginController.login(user);
        if (flag) {
            System.out.println("\t登录成功");
            StockWindow window = router.getWindow(Router.INDEX);
            window.show();
        } else {
            System.out.println("用户名或密码输入错误，请重新输入。。");
            StockWindow window = router.getWindow(Router.LOGIN);
            window.show();
        }

    }

    public User getLoginInfo() {
        String userName = "";
        String password = "";
        User user = new User();
        System.out.println("请输入用户名和密码：");
        System.out.print("    用户名：");
        Scanner sc = new Scanner(System.in);
        userName = sc.next();
        System.out.print("    密码：");
        password = sc.next();
        System.out.println("");
        user.setUserName(userName);
        user.setPassword(password);
        return user;
    }


}
