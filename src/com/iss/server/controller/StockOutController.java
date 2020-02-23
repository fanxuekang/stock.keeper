package com.iss.server.controller;

import com.iss.server.model.StockOut;
import com.iss.server.service.StockService;

public class StockOutController {
    private static StockService stockService = new StockService();
    public static boolean stockOut(StockOut stockOut){
        return  stockService.stockOut(stockOut);
    }
}
