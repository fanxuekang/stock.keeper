package com.iss.client.view;

import com.iss.client.router.Router;
import com.iss.client.view.Component.GetSelect;
import com.iss.client.view.Component.StockWindow;

public class Index extends StockWindow {

    private Router router = new Router();

    public void display() {
        System.out.println("请选择不同的命令进入不同的页面：");
        System.out.println("-----------------------------");
        System.out.println("\t库存列表：list");
        System.out.println("\t入库操作：in");
        System.out.println("\t出库操作：out");
        System.out.println("\t退出：esc");
        System.out.println("-----------------------------");
        GetSelect.getSelect();

    }
}
