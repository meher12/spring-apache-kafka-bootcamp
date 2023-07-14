package com.guru.kafka.entity;
import javax.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue
    private int orderItemId;

    @Column
    private String itemName;

    @Column
    private int price;

    @Column
    private int quantity;

    @JoinColumn(name = "order_id")
    @ManyToOne
    private Order order;

    public String getItemName() {
        return itemName;
    }

    public Order getOrder() {
        return order;
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem [orderItemId=" + orderItemId + ", itemName=" + itemName + ", price=" + price + ", quantity="
                + quantity + "]";
    }

}
