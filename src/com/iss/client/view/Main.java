package com.iss.client.view;

import com.iss.client.router.Router;
import com.iss.client.view.Component.StockWindow;

/**
 * 程序主入口
 */
public class Main {
    public static void main(String[] args) {
        Router router = new Router();
        StockWindow stockWindow =  router.getWindow(Router.LOGIN);
        stockWindow.show();
    }
}
