package com.iss.client.view;

import com.iss.client.router.Router;
import com.iss.client.view.Component.GetSelect;
import com.iss.client.view.Component.StockWindow;
import com.iss.server.controller.LoginController;
import com.iss.server.controller.StockController;
import com.iss.server.controller.StockOutController;
import com.iss.server.model.Stock;
import com.iss.server.model.StockIn;
import com.iss.server.model.StockOut;
import com.iss.server.model.User;

import java.util.List;
import java.util.Scanner;

public class StockOutView extends StockWindow {
    private Router router = new Router();
    @Override
    public void display() {
        StockOut stockOut = getInput();
        boolean flag = StockOutController.stockOut(stockOut);
        if(flag){
            System.out.println("出库成功！当前库存信息如下：");
            StockWindow window = router.getWindow(Router.LIST);
            window.show();
        }else{
            System.out.println("您的输入有误，请重新输入。。");
            StockWindow window = router.getWindow(Router.STOCKOUT);
            window.show();
        }

    }

    public StockOut getInput(){
        Scanner sc = new Scanner(System.in);
        StockOut stockOut = new StockOut();
        System.out.print("请输入出库商品ID：");
        stockOut.setProductId(Integer.parseInt(sc.next()));
        System.out.print("请输入出库商品名称：");
        stockOut.setProductName(sc.next());
        System.out.print("请输入出库商品数量：");
        stockOut.setQuantity(Integer.parseInt(sc.next()));
        return stockOut;
    }
}
