/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugas_besar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Inventory {
    private List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Produk ditambahkan ke inventaris.");
    }

    public void updateProduct(String productId, int quantity, double price) {
        for (Product product : products) {
            if (product.productId.equals(productId)) {
                product.quantity = quantity;
                product.price = price;
                System.out.println("Produk diperbarui.");
                return;
            }
        }
        System.out.println("Produk tidak ditemukan.");
    }

    public void deleteProduct(String productId) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.productId.equals(productId)) {
                iterator.remove();
                System.out.println("Produk dihapus.");
                return;
            }
        }
        System.out.println("Produk tidak ditemukan.");
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Tidak ada produk di inventaris.");
            return;
        }
        
        System.out.println("+----------------+---------------------+------------------------+------------+--------------------+");
        System.out.println("| ID Produk      | Nama Produk         | Harga (Rupiah)         | Jumlah     | Tipe Produk        |");
        System.out.println("+----------------+---------------------+------------------------+------------+--------------------+");
        
        for (Product product : products) {
            System.out.printf("| %-14s | %-19s | %-22s | %-10d | %-18s |\n", 
                              product.productId, 
                              product.name, 
                              String.format("Rp%.2f", product.price), 
                              product.quantity, 
                              (product instanceof PhysicalProduct ? "Fisik" : "Digital"));
        }
        
        System.out.println("+----------------+---------------------+------------------------+------------+--------------------+");
    }
}
