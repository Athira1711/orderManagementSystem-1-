package com.example;

import com.example.entity.Order;
import com.example.service.OrderService;
import com.example.service.OrderServiceImpl;

import java.util.List;
import java.util.Scanner;

public class MainModule {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        OrderService service = new OrderServiceImpl();
        while (true) {
            System.out.println("\n1. Add Order\n2. Delete Order\n3. View All Orders\n4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addOrder(service);
                case 2 -> deleteOrder(service);
                case 3 -> viewAllOrders(service);
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void addOrder(OrderService service) {
        System.out.print("Customer Name: ");
        String name = sc.nextLine();
        System.out.print("Order Date (YYYY-MM-DD): ");
        String date = sc.nextLine();
        System.out.print("Total Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Order Status: ");
        String status = sc.nextLine();
        Order order = new Order(name, date, amount, status);
        System.out.println(service.addOrder(order));
    }

    private static void deleteOrder(OrderService service) {
        System.out.print("Enter Order ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println(service.deleteOrder(id));
    }

    private static void viewAllOrders(OrderService service) {
        List<Order> orders = service.getAllOrders();
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            orders.forEach(System.out::println);
        }
    }
}