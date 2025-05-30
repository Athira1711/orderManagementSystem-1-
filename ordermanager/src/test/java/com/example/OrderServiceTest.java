package com.example;

import com.example.entity.Order;
import com.example.service.OrderService;
import com.example.service.OrderServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {
    OrderService service = new OrderServiceImpl();

    @Test
    void testAddOrder() {
        Order order = new Order("John Doe", "2025-05-19", 299.99, "Pending");
        String result = service.addOrder(order);
        assertTrue(result.contains("successfully"));
    }

    @Test
    void testGetAllOrders() {
        List<Order> orders = service.getAllOrders();
        assertNotNull(orders);
    }

    @Test
    void testDeleteOrder() {
        String result = service.deleteOrder(1); // ensure ID 1 exists
        assertTrue(result.contains("Order"));
    }
}