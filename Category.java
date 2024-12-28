/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugas_besar;

/**
 *
 * @author LENOVO
 */
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

    public void removeProduct(Product product) {
        products.remove(product);
        System.out.println("Product removed from category: " + name);
    }

    public void displayProducts() {
        System.out.println("Category: " + name);
        for (Product product : products) {
            System.out.println("- " + product.name);
        }
    }

    public String getName() {
        return name;
    }
}
