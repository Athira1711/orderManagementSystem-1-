package com.example.service;

import com.example.entity.Order;
import com.example.util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    public String addOrder(Order order) {
        String sql = "INSERT INTO orders (customerName, orderDate, totalAmount, orderStatus) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, order.getCustomerName());
            stmt.setString(2, order.getOrderDate());
            stmt.setDouble(3, order.getTotalAmount());
            stmt.setString(4, order.getOrderStatus());
            stmt.executeUpdate();
            return "Order added successfully!";
        } catch (SQLException e) {
            return "Error adding order: " + e.getMessage();
        }
    }

    public String deleteOrder(int orderId) {
        String sql = "DELETE FROM orders WHERE orderId = ?";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, orderId);
            int rows = stmt.executeUpdate();
            return rows > 0 ? "Order deleted successfully." : "Order not found.";
        } catch (SQLException e) {
            return "Error deleting order: " + e.getMessage();
        }
    }

    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                orders.add(new Order(
                        rs.getInt("orderId"),
                        rs.getString("customerName"),
                        rs.getString("orderDate"),
                        rs.getDouble("totalAmount"),
                        rs.getString("orderStatus")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching orders: " + e.getMessage());
        }
        return orders;
    }
}