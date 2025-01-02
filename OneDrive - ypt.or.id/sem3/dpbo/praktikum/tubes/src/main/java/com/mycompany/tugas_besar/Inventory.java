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
    public List<Product> products;
    public List<Category> categories;

    public Inventory() {
        products = new ArrayList<>();
        categories = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Produk ditambahkan ke inventaris");
    }

    public void addCategory(Category category) {
        categories.add(category);
        System.out.println("Kategori ditambahkan: " + category.getName());
    }

    public void displayCategories() {
        if (categories.isEmpty()) {
            System.out.println("kategori tidak tersedia");
            return;
        }
        System.out.println("Kategori yang tersedia:");
        for (Category category : categories) {
            System.out.println("- " + category.getName());
        }
    }

    public void updateProduct(String productId, int quantity, double price) {
        for (Product product : products) {
            if (product.productId.equals(productId)) {
                product.quantity = quantity;
                product.price = price;
                System.out.println("Produk diperbarui");
                return;
            }
        }
        System.out.println("Produk tidak ditemukan");
    }

    public void deleteProduct(String productId) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.productId.equals(productId)) {
                iterator.remove();
                System.out.println("Produk dihapus");
                return;
            }
        }
        
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Tidak ada produk dalam inventaris");
            return;
        }

        System.out.println("+----------------+---------------------+------------------------+------------+");
        System.out.println("| ID Produk      | Nama Produk         | Harga (Rp)             | Jumlah     |");
        System.out.println("+----------------+---------------------+------------------------+------------+");

        for (Product product : products) {
            System.out.printf("| %-14s | %-19s | %-22.2f | %-10d |\n",
                    product.productId,
                    product.name,
                    product.price,
                    product.quantity);
        }

        System.out.println("+----------------+---------------------+------------------------+------------+");
    }

    public void searchProduct(String keyword) {
        boolean found = false;
        for (Product product : products) {
            if (product.productId.contains(keyword) || product.name.contains(keyword)) {
                product.read();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Tidak ada produk yang ditemukan dengan kata kunci: " + keyword);
        }
    }

    public void applyGlobalDiscount(double discountRate) {
        for (Product product : products) {
            product.price *= (1 - discountRate);
        }
        System.out.println("Diskon diterapkan: " + (discountRate * 100) + "%");
    }
    
    public List<Category> getCategories() {
    return categories;
    }
    
    public void removeProduct(String productId) {
    products.removeIf(product -> product.productId.equals(productId));
}

    public void searchProductByName(String keyword) {
        boolean found = false;
        for (Product product : products) {
            if (product.name.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Produk tidak ditemukan.");
        }
    }

    // Search product by price range
    public void searchProductByPrice(double minPrice, double maxPrice) {
        boolean found = false;
        for (Product product : products) {
            if (product.price >= minPrice && product.price <= maxPrice) {
                System.out.println(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Tidak ada produk dalam rentang harga tersebut.");
        }
    }

    // Search product by category
    public void searchProductByCategory(String categoryId) {
        boolean found = false;
        for (Category category : categories) {
            if (category.getCategoryId().equals(categoryId)) {
                for (Product product : category.getProducts()) {
                    System.out.println(product);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Tidak ada produk dalam kategori ini.");
        }
    }
    
    public Product getProductById(String productId) {
    for (Product product : products) {
        if (product.productId.equals(productId)) {
            return product;
        }
    }
    return null;
}

}