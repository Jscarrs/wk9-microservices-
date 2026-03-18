package com.lab.fees.model;

public class FeeResponse {
    private String stockSymbol;
    private int quantity;
    private double feeRate;
    private double totalFee;
    private String feeType;

    public FeeResponse() {}

    public FeeResponse(String stockSymbol, int quantity, double feeRate, double totalFee, String feeType) {
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.feeRate = feeRate;
        this.totalFee = totalFee;
        this.feeType = feeType;
    }

    public String getStockSymbol() { return stockSymbol; }
    public void setStockSymbol(String stockSymbol) { this.stockSymbol = stockSymbol; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getFeeRate() { return feeRate; }
    public void setFeeRate(double feeRate) { this.feeRate = feeRate; }
    public double getTotalFee() { return totalFee; }
    public void setTotalFee(double totalFee) { this.totalFee = totalFee; }
    public String getFeeType() { return feeType; }
    public void setFeeType(String feeType) { this.feeType = feeType; }
}
