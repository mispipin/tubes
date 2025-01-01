/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugas_besar;

/**
 *
 * @author LENOVO
 */
abstract class Order {
    protected String orderId;
    protected double totalAmount;

    public abstract void createOrder();
    public abstract void updateOrder();

    public double calculateTotal() {
        return totalAmount;
    }
    
    
}