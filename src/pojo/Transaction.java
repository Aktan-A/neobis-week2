package pojo;

import java.time.LocalDateTime;
import enums.TransactionStatus;

public class Transaction {

    private Long transactionId;
    private double totalPrice;
    private TransactionStatus status;
    private LocalDateTime createdAt;

    public Transaction () {}

    public Transaction (Long transactionId, double totalPrice, TransactionStatus status, LocalDateTime createdAt) {
        this.transactionId = transactionId;
        this.totalPrice = totalPrice;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getTransactionId() {
        return this.transactionId;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public TransactionStatus getStatus() {
        return this.status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

}