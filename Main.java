/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugas_besar;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Inventory inventory = new Inventory();
            boolean running = true;
            
            while (running) {
                // Menampilkan menu pilihan
                System.out.println("===== INVENTORY MANAGEMENT =====");
                System.out.println("1. Add Product");
                System.out.println("2. View All Products");
                System.out.println("3. Update Product");
                System.out.println("4. Delete Product");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                
                switch (choice) {
                    case 1 -> {
                        // Menambahkan produk
                        System.out.println("Enter Product Type (1 for Physical, 2 for Digital): ");
                        int productType = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        
                        System.out.print("Enter Product ID: ");
                        String productId = scanner.nextLine();
                        
                        System.out.print("Enter Product Name: ");
                        String name = scanner.nextLine();
                        
                        System.out.print("Enter Product Price: ");
                        double price = scanner.nextDouble();
                        
                        System.out.print("Enter Product Quantity: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                    switch (productType) {
                        case 1:
                            PhysicalProduct physicalProduct = new PhysicalProduct();
                            physicalProduct.productId = productId;
                            physicalProduct.name = name;
                            physicalProduct.price = price;
                            physicalProduct.quantity = quantity;
                            inventory.addProduct(physicalProduct);
                            break;
                        case 2:
                            DigitalProduct digitalProduct = new DigitalProduct();
                            digitalProduct.productId = productId;
                            digitalProduct.name = name;
                            digitalProduct.price = price;
                            digitalProduct.quantity = quantity;
                            inventory.addProduct(digitalProduct);
                            break;
                        default:
                            System.out.println("Invalid product type.");
                            break;
                    }
                    }
                        
                    case 2 -> // Menampilkan semua produk
                        inventory.displayProducts();
                        
                    case 3 -> {
                        // Mengupdate produk
                        System.out.print("Enter Product ID to Update: ");
                        String updateId = scanner.nextLine();
                        
                        System.out.print("Enter new Quantity: ");
                        int newQuantity = scanner.nextInt();
                        
                        System.out.print("Enter new Price: ");
                        double newPrice = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        
                        inventory.updateProduct(updateId, newQuantity, newPrice);
                    }
                        
                    case 4 -> {
                        // Menghapus produk
                        System.out.print("Enter Product ID to Delete: ");
                        String deleteId = scanner.nextLine();
                        inventory.deleteProduct(deleteId);
                    }
                        
                    case 5 -> {
                        // Keluar
                        running = false;
                        System.out.println("Exiting...");
                    }
                        
                    default -> System.out.println("Invalid choice. Please try again.");
                }
                
                System.out.println();
            }
        }
    }
}