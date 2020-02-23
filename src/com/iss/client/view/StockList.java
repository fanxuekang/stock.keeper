package com.iss.client.view;

import com.iss.client.view.Component.GetSelect;
import com.iss.client.view.Component.StockDataTable;
import com.iss.client.view.Component.StockWindow;
import com.iss.server.controller.StockController;
import com.iss.server.model.Stock;

import java.util.List;

public class StockList extends StockWindow {

    @Override
    public void display() {
        List<Stock> stocks = StockController.getAllStockInfo();

        StockDataTable stockDataTable = new StockDataTable();
        stockDataTable.initTable(stocks);
        GetSelect.getSelect();
    }
}
