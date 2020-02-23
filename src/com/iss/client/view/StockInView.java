package com.iss.client.view;

import com.iss.client.router.Router;
import com.iss.client.view.Component.StockWindow;
import com.iss.server.controller.StockInController;
import com.iss.server.model.StockIn;

import java.util.Scanner;

public class StockInView extends StockWindow {

    /**
     * client
     * 1.收集入库的商品的名称
     * 2.收集入库的商品的数量
     * 3.通过controller发送给服务器端
     *
     * server
     * 4.接受入库的商品的名称，数量
     * 5.调用业务逻辑层处理
     * 6.返回处理结果
     *
     * client
     *7.根据处理结果做出相应的响应
     **/

    private StockInController stockInController = new StockInController();
    private Router router = new Router();
    @Override
    public void display() {
        StockIn stockIn = getInput();
        boolean flag = stockInController.stockIn(stockIn);
        if(flag){
            router.getWindow(Router.LIST).show();
        }else{
            System.out.println("入库失败 ");
        }
    }



    public StockIn getInput(){
        StockIn stockIn = new StockIn();
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入商品的id：");
        int productId = Integer.parseInt(scanner.next());
        stockIn.setProductid(productId);
        System.out.print("请输入商品的名称：");
        String productName = scanner.next();
        stockIn.setProductName(productName);
        System.out.print("请输入商品的数量：");
        int quantity = Integer.parseInt(scanner.next());
        stockIn.setQuantity(quantity);
        return stockIn;
    }
}
