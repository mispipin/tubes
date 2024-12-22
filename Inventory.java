/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugas_besar;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
class Inventory {
    private List<Product> products = new ArrayList<>();

    // Create
    public void addProduct(Product product) {
        products.add(product);
        product.create();
    }

    // Read
    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available in inventory.");
        } else {
            for (Product product : products) {
                product.read();
                System.out.println("--------------------------");
            }
        }
    }
    // Update
    public void updateProduct(String productId, int newQuantity, double newPrice) {
        for (Product product : products) {
            if (product.productId.equals(productId)) {
                product.updateStock(newQuantity);
                product.price = newPrice;
                product.update();
                break;
            }
        }
    }

    // Delete
    public void deleteProduct(String productId) {
        products.removeIf(product -> product.productId.equals(productId));
        System.out.println("Product with ID " + productId + " deleted.");
    }
}

