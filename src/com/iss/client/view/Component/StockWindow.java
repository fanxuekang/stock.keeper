package com.iss.client.view.Component;

import com.iss.server.controller.StockController;
import com.iss.server.model.Stock;

import java.util.ArrayList;

public abstract class StockWindow {
    /**
     * 1.打印头部信息，
     * 2.显示业务内容
     */

    private void showHeader() {
        System.out.println("*************欢迎使用库存管理系统*************");
    }

    private void showBottom() {
        System.out.println("********************************************");
    }

    public abstract void display();

    public void show() {
        showHeader();
        display();
        showBottom();
    }
}
