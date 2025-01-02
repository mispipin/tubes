/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugas_besar;

/**
 *
 * @author LENOVO
 */
import java.util.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Order {
    private String orderId; // Properti baru untuk kode unik
    private Map<Product, Integer> orderItems = new HashMap<>();
    private double discount = 0.0;
    private double tax = 0.0;
    private String status = "Pending";

    // Konstruktor
    public Order() {
        this.orderId = generateOrderId(); // Kode unik dibuat saat objek Order dibuat
    }

    // Metode baru untuk menghasilkan kode unik
    private String generateOrderId() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = formatter.format(new Date());
        int randomNum = new Random().nextInt(900) + 100; // Angka acak 3 digit
        return "ORD-" + timestamp + "-" + randomNum;
    }

    public String getOrderId() {
        return orderId;
    }

    // Metode lama tetap berfungsi tanpa perubahan
    public void addProduct(Product product, int quantity) {
        orderItems.put(product, orderItems.getOrDefault(product, 0) + quantity);
    }

    public void printOrderSummary() {
        double subtotal = 0.0;
        System.out.println("\n=== Ringkuman Pesanan ===");
        System.out.println("Kode Pesanan: " + orderId); // Kode pesanan ditampilkan

        for (Map.Entry<Product, Integer> entry : orderItems.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double itemTotal = product.price * quantity;
            subtotal += itemTotal;

            System.out.println("- " + product.name + ": " + quantity + " unit x Rp" + 
                String.format("%,.2f", product.price) + " = Rp" + String.format("%,.2f", itemTotal));
        }

        double discountAmount = (discount / 100) * subtotal;
        double taxAmount = (tax / 100) * (subtotal - discountAmount);
        double total = subtotal - discountAmount + taxAmount;

        System.out.println("Subtotal: Rp" + String.format("%,.2f", subtotal));
        System.out.println("Diskon: " + discount + "% (-Rp" + String.format("%,.2f", discountAmount) + ")");
        System.out.println("Pajak: " + tax + "% (+Rp" + String.format("%,.2f", taxAmount) + ")");
        System.out.println("Total: Rp" + String.format("%,.2f", total));
        System.out.println("Status: " + status);
    }

    // Metode lain tetap tidak berubah
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

