package pojo;

import java.time.LocalDateTime;
import enums.ProductStatus;

public class Product {
    private Long productId;
    private ProductStatus status;
    private String name;
    private String description;
    private double price;
    private LocalDateTime createdAt;

    public Product () {}

    public Product (Long productId, ProductStatus status, String name, String description, double price,
                    LocalDateTime createdAt) {
        this.productId = productId;
        this.status = status;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdAt = createdAt;
    }

    public Long getProductId() {
        return this.productId;
    }

    public ProductStatus getStatus() {
        return this.status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

}
