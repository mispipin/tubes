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
        System.out.println("Menciptakan produk fisik");
    }

    @Override
    public void update() {
        System.out.println("Memperbarui produk fisik");
    }

    @Override
    public void delete() {
        System.out.println("Menghapus produk fisik");
    }
    
    public PhysicalProduct(String productId, String name, double price, int quantity) {
        super(productId, name, price, quantity);
    }
    
    @Override
    public String toString() {
        return super.toString() + " (Fisik)";
    }

}
