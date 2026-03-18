package com.lab.orders.model;

public class Order {
    private String orderId;
    private String accountId;
    private String stockSymbol;
    private int quantity;
    private String orderType;
    private String status;

    public Order() {}

    public Order(String orderId, String accountId, String stockSymbol, int quantity, String orderType, String status) {
        this.orderId = orderId;
        this.accountId = accountId;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.orderType = orderType;
        this.status = status;
    }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public String getAccountId() { return accountId; }
    public void setAccountId(String accountId) { this.accountId = accountId; }
    public String getStockSymbol() { return stockSymbol; }
    public void setStockSymbol(String stockSymbol) { this.stockSymbol = stockSymbol; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public String getOrderType() { return orderType; }
    public void setOrderType(String orderType) { this.orderType = orderType; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
