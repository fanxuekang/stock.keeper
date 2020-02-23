package com.iss.server.controller;

import com.iss.server.model.Stock;
import com.iss.server.model.StockIn;
import com.iss.server.service.StockService;


public class StockInController {
    private StockService stockService = new StockService();
    public boolean stockIn(StockIn stockIn){
        return stockService.stockIn(stockIn);
    }
}
