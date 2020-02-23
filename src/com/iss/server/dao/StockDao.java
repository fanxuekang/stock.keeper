package com.iss.server.dao;

import com.iss.server.model.Stock;
import com.iss.server.model.StockOut;
import com.iss.server.util.DBUtil;
import com.iss.server.util.Entityable;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StockDao extends BaseDao<Stock> implements Entityable<Stock> {

    @Override
    public List<Stock> convertToEntity(ResultSet resultSet) {
        List<Stock> list = new ArrayList<Stock>();


        try {
            while (resultSet.next()) {
                Stock stock = new Stock();
                stock.setStockId(resultSet.getInt("stock_id"));
                stock.setProductId(resultSet.getInt("product_id"));
                stock.setProductName(resultSet.getString("product_name"));
                stock.setQuantity(resultSet.getInt("quantity"));
                list.add(stock);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean insert(Stock stock) {

        String sql1 = "insert into k_stock(product_id,quantity) VALUES("+stock.getProductId()+","+stock.getQuantity()+")";
        String sql2 = "insert into k_product(product_id,product_name) VALUES("+stock.getProductId()+",'"+stock.getProductName()+"')";

        boolean flag1 = DBUtil.update(sql1);
        boolean flag2 = DBUtil.update(sql2);
        if(flag1 && flag2){
            System.out.println("插入成功！");
            return true;
        }else{
            System.out.println("插入失败！");
            return false;
        }
    }

    @Override
    public boolean update(Stock stock) {
        String sql = "UPDATE k_stock SET quantity = "+stock.getQuantity()+" WHERE product_id = "+stock.getProductId();
        boolean flag = DBUtil.update(sql);
        if(flag){
            System.out.println("更新成功！");
        }else{
            System.out.println("更新失败！");
        }
        return DBUtil.update(sql);
    }

    public boolean update(StockOut stockOut){
        boolean flag = false;
        try{
            String sql1 = "select quantity from k_stock where product_id = "+stockOut.getProductId();
            ResultSet rs = DBUtil.query(sql1);
            int source = 0;
            while(rs.next()){
                source = rs.getInt("quantity");
            }
            int ans = source - stockOut.getQuantity();
            String sql2 = "update k_stock set quantity = "+ans+" where product_id = "+stockOut.getProductId();
            flag= DBUtil.update(sql2);
        }catch (Exception e){
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }
    @Override
    public boolean remove(Stock stock) {
        return false;
    }

    @Override
    public List<Stock> query(Stock stock) {
        String sql = "Select k_stock.stock_id,k_stock.product_id,k_product.product_name," +
                "k_stock.quantity from k_stock,k_product where k_stock.product_id = k_product.product_id;";
        ResultSet rs = DBUtil.query(sql);
        return convertToEntity(rs);
    }

    public Stock isExist(Stock stock) {
        Stock s = new Stock();
        String sql = "select * from k_stock where product_id =" + stock.getProductId();
        ResultSet rs = DBUtil.query(sql);
        try {
            while (rs.next()) {
                s.setStockId(rs.getInt(1));
                s.setProductId(rs.getInt(2));
                s.setQuantity(rs.getInt(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

}
