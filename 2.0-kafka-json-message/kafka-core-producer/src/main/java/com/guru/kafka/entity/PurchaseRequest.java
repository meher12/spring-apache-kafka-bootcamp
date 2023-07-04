package com.guru.kafka.entity;

public class PurchaseRequest {

    private int id;
    private String prNumber;
    private int amount;
    private String currency;

    public PurchaseRequest() {

    }

    public PurchaseRequest(int id, String prNumber, int amount, String currency) {
        super();
        this.id = id;
        this.prNumber = prNumber;
        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public int getId() {
        return id;
    }

    public String getPrNumber() {
        return prNumber;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrNumber(String prNumber) {
        this.prNumber = prNumber;
    }

    @Override
    public String toString() {
        return "PurchaseRequest [id=" + id + ", prNumber=" + prNumber + ", amount=" + amount + ", currency=" + currency
                + "]";
    }
}
