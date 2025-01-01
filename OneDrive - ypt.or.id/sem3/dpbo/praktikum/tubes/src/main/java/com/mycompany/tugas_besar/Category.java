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
class Category {
    private String categoryId;
    private String name;
    private List<Product> products;

    public Category(String categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added to category: " + name);
    }

    public void removeProduct(String productId) {
        products.removeIf(product -> product.productId.equals(productId));
        System.out.println("Product removed from category: " + name);
    }

    public void displayProducts() {
        System.out.println("Category: " + name);
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product product : products) {
                System.out.println("- " + product.getName());
            }
        }
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }
    
    public List<Product> getProducts() {
    return products;
}

}