package pojo;

import java.time.LocalDateTime;
import enums.OrderStatus;

public class Order {

    private Long orderId;
    private Long customerId;
    private Long transactionId;
    private OrderStatus status;
    private LocalDateTime createdAt;

    public Order() {}

    public Order(Long orderId, Long customerId, Long transactionId, OrderStatus status, LocalDateTime createdAt) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.transactionId = transactionId;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public Long getCustomerId() {
        return this.customerId;
    }

    public Long getTransactionId() {
        return this.transactionId;
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

}
