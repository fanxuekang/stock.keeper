package com.iss.server.controller;

import com.iss.server.model.Stock;
import com.iss.server.service.StockService;

import java.util.ArrayList;
import java.util.List;

public class StockController {
    private static StockService stockService = new StockService();

    public static List<Stock> getAllStockInfo(){
        return stockService.getAllStockInfo();
    }

}
