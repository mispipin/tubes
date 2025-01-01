/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugas_besar;

/**
 *
 * @author LENOVO
 */
class DigitalProduct extends Product {
    private double fileSize;
    private String fileType;

    @Override
    public void applyDiscount() {
        price *= 0.85; // 15% discount
    }

    public String generateDownload() {
        return "Download link for " + name;
    }

    @Override
    public void create() {
        System.out.println("Membuat produk digital");
    }

    @Override
    public void update() {
        System.out.println("Memperbarui produk digital");
    }

    @Override
    public void delete() {
        System.out.println("Menghapus produk digital");
    }
    
    public DigitalProduct(String productId, String name, double price, int quantity) {
        super(productId, name, price, quantity);
    }
}