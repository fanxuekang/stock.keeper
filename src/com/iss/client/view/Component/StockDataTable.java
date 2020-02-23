package com.iss.client.view.Component;

import com.iss.server.model.Stock;

import java.util.List;

public class StockDataTable extends DataTable<Stock> {
    @Override
    public void initTable() {

    }

    @Override
    public void initTable(List<Stock> dataSource) {
        System.out.println("****库存ID****货物ID****货物名称****库存数量****");

        for(int i = 0;i < dataSource.size(); i++){
            System.out.printf("%6s%10s%10s%10s\n",dataSource.get(i).getStockId(),dataSource.get(i).getProductId(),dataSource.get(i).getProductName(),dataSource.get(i).getQuantity());
        }
        System.out.println("************************************");

    }
}
