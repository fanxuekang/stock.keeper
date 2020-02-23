package com.iss.server.model;

public class StockOut {
    private Integer productId;
    private String productName;
    private Integer quantity;

    public StockOut() {
        setProductId(null);
        setProductName(null);
        setQuantity(null);
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
