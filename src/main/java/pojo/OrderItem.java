package pojo;

import java.time.LocalDateTime;

public class OrderItem {
    private Long orderItemId;
    private Long orderId;
    private Long productId;
    private int quantity;
    private LocalDateTime createdAt;

    public OrderItem() {}

    public OrderItem(Long orderItemId, Long orderId, Long productId, int quantity, LocalDateTime createdAt) {
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.createdAt = createdAt;
    }

    public Long getOrderItemId() {
        return this.orderItemId;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public Long getProductId() {
        return this.productId;
    }

    private int getQuantity() {
        return this.quantity;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

}
