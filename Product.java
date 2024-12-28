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
        System.out.println("ID Produk: " + productId);
        System.out.println("Nama: " + name);
        System.out.println("Harga: Rp" + String.format("%.2f", price));
        System.out.println("Jumlah: " + quantity);
    }
}
