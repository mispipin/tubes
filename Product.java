/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugas_besar;

/**
 *
 * @author LENOVO
 */
abstract class Product implements IManageable {
    protected String productId;
    protected String name;
    protected double price;
    protected int quantity;

    public abstract void applyDiscount();

    public void updateStock(int quantity) {
        this.quantity += quantity;
    }

    @Override
    public void read() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
    }
}