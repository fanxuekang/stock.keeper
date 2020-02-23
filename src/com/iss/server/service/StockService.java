package com.iss.server.service;

import com.iss.server.dao.StockDao;
import com.iss.server.model.Stock;
import com.iss.server.model.StockIn;
import com.iss.server.model.StockOut;

import java.util.List;

public class StockService {
    private static StockDao stockDao = new StockDao();

    public static List<Stock> getAllStockInfo(){
        return stockDao.query(new Stock());
    }

    public boolean stockIn(StockIn stockIn){
        boolean flag = false;

        Stock stock  = new Stock();
        stock.setProductId(stockIn.getProductid());
        stock.setQuantity(stockIn.getQuantity());
        stock.setProductName(stockIn.getProductName());
        Stock source = stockDao.isExist(stock);
        if(source.getStockId() == null){
            System.out.println("当前库中不包含该货物信息，正在插入。。。");
            flag = stockDao.insert(stock);
        }else{
            System.out.println("当前库中已包含该货物信息，正在更新。。。");
            Integer quantity = source.getQuantity() + stock.getQuantity();
            stock.setQuantity(quantity);
            flag = stockDao.update(stock);
        }
        /**
         * 1.创建入库单据  insert，
         * 2.查找库存信息：如果有，+，如果没有，new；
         */
        return flag;
    }

    public boolean stockOut(StockOut stockOut){
        return stockDao.update(stockOut);
    }

}
