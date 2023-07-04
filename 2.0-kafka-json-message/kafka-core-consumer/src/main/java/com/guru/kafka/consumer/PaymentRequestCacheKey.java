package com.guru.kafka.consumer;

import java.util.Objects;

public class PaymentRequestCacheKey {

    private String paymentNumber;
    private int amount;
    private String transactionType;

    public PaymentRequestCacheKey(String paymentNumber, int amount, String transactionType) {
        this.paymentNumber = paymentNumber;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentRequestCacheKey that = (PaymentRequestCacheKey) o;
        return amount == that.amount && Objects.equals(paymentNumber, that.paymentNumber) && Objects.equals(transactionType, that.transactionType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentNumber, amount, transactionType);
    }

    @Override
    public String toString() {
        return "PaymentRequestCacheKey{" + "paymentNumber='" + paymentNumber + '\'' + ", amount=" + amount + ", transactionType='" + transactionType + '\'' + '}';
    }
}
