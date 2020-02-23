package com.iss.client.view.Component;

import com.iss.client.router.Router;
import com.iss.client.view.Component.StockWindow;

import java.util.Scanner;

public class GetSelect {
    public static void getSelect() {
        Router router = new Router();
        Scanner sc = new Scanner(System.in);
        String inpute = "";
        do {
            System.out.print("请输入您的选择：");
            inpute = sc.next();
            switch (inpute) {
                case "list": {
                    StockWindow stockWindow = router.getWindow(Router.LIST);
                    stockWindow.show();
                    break;
                }
                case "in": {
                    StockWindow stockWindow = router.getWindow(Router.STOCKIN);
                    stockWindow.show();
                    break;
                }

                case "out": {
                    StockWindow stockWindow = router.getWindow(Router.STOCKOUT);
                    stockWindow.show();
                    break;
                }

                case "esc": {
                    StockWindow stockWindow = router.getWindow(Router.LOGIN);
                    stockWindow.show();
                    break;
                }

                default: {
                    System.out.println("您的输入有误，请重新输入");
                }

            }
        } while (!inpute.equals("in") && !inpute.equals("list") && !inpute.equals("out") && !inpute.equals("esc"));

    }
}
