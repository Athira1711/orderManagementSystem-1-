package com.example.entity;

public class Order {
    private int orderId;
    private String customerName;
    private String orderDate;
    private double totalAmount;
    private String orderStatus;

    public Order(int orderId, String customerName, String orderDate, double totalAmount, String orderStatus) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
    }

    public Order(String customerName, String orderDate, double totalAmount, String orderStatus) {
        this(0, customerName, orderDate, totalAmount, orderStatus);
    }

    public int getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public String getOrderDate() { return orderDate; }
    public double getTotalAmount() { return totalAmount; }
    public String getOrderStatus() { return orderStatus; }

    @Override
    public String toString() {
        return String.format("OrderID: %d | Customer: %s | Date: %s | Amount: %.2f | Status: %s",
                orderId, customerName, orderDate, totalAmount, orderStatus);
    }
}
