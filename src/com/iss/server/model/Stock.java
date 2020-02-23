package com.iss.server.model;

public class Stock {
    private Integer stockId;
    private Integer productId;
    private Integer quantity;

    private String productName;


    public void Stock(){
        setStockId(null);
        setProductId(null);
        setQuantity(null);
        setProductName(null);
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
