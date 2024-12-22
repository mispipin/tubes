/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugas_besar;

/**
 *
 * @author LENOVO
 */
class PhysicalProduct extends Product {
    private double weight;
    private String dimensions;

    @Override
    public void applyDiscount() {
        price *= 0.9; // 10% discount
    }

    public double calculateShipping() {
        return weight * 5; // Shipping cost logic
    }

    @Override
    public void create() {
        System.out.println("Creating physical product");
    }

    @Override
    public void update() {
        System.out.println("Updating physical product");
    }

    @Override
    public void delete() {
        System.out.println("Deleting physical product");
    }
}
