package com.mycompany.tugas_besar;

import java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Inventory inventory = new Inventory();
            boolean running = true;

            while (running) {
                // Menampilkan menu pilihan
                System.out.println("===== ITProcure =====");
                System.out.println("1. Tambah Produk");
                System.out.println("2. Lihat Semua Produk");
                System.out.println("3. Update Produk");
                System.out.println("4. Hapus Produk");
                System.out.println("5. Keluar");
                System.out.print("Pilih opsi: ");
                
                // Validasi pilihan menu
                int choice = -1;
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                } else {
                    scanner.nextLine(); // Consume invalid input
                    System.out.println("Input tidak valid. Harap pilih angka antara 1 dan 5.");
                    continue;
                }

                switch (choice) {
                    case 1 -> {
                        // Menambahkan produk
                        System.out.println("Pilih Jenis Produk (1 untuk Fisik, 2 untuk Digital): ");
                        int productType = -1;
                        boolean validProductType = false;
                        while (!validProductType) {
                            if (scanner.hasNextInt()) {
                                productType = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                if (productType == 1 || productType == 2) {
                                    validProductType = true;
                                } else {
                                    System.out.println("Jenis produk tidak valid. Harap masukkan angka 1 untuk Fisik atau 2 untuk Digital.");
                                }
                            } else {
                                scanner.nextLine(); // Consume invalid input
                                System.out.println("Input tidak valid. Harap masukkan angka 1 untuk Fisik atau 2 untuk Digital.");
                            }
                        }

                        System.out.print("Masukkan ID Produk: ");
                        String productId = scanner.nextLine();

                        // Cek apakah ID produk terdiri hanya dari huruf
                        if (productId.matches("[a-zA-Z]+")) {
                            System.out.println("ID Produk tidak valid. Harap masukkan ID yang mengandung angka atau karakter selain huruf.");
                            continue;
                        }

                        System.out.print("Masukkan Nama Produk: ");
                        String name = scanner.nextLine();

                        double price = 0;
                        System.out.print("Masukkan Harga Produk (dalam Rupiah): ");
                        if (scanner.hasNextDouble()) {
                            price = scanner.nextDouble();
                        } else {
                            System.out.println("Harga tidak valid. Harap masukkan angka.");
                            scanner.nextLine(); // Consume invalid input
                            continue;
                        }

                        System.out.print("Masukkan Jumlah Produk: ");
                        int quantity = 0;
                        if (scanner.hasNextInt()) {
                            quantity = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                        } else {
                            System.out.println("Jumlah tidak valid. Harap masukkan angka.");
                            scanner.nextLine(); // Consume invalid input
                            continue;
                        }

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
                                System.out.println("Jenis produk tidak valid.");
                                break;
                        }
                    }

                    case 2 -> {
                        // Menampilkan semua produk dalam tabel
                        inventory.displayProducts();
                    }

                    case 3 -> {
                        // Mengupdate produk
                        System.out.print("Masukkan ID Produk yang akan diupdate: ");
                        String updateId = scanner.nextLine();

                        System.out.print("Masukkan jumlah baru: ");
                        int newQuantity = 0;
                        if (scanner.hasNextInt()) {
                            newQuantity = scanner.nextInt();
                        } else {
                            System.out.println("Jumlah tidak valid. Harap masukkan angka.");
                            scanner.nextLine(); // Consume invalid input
                            continue;
                        }

                        System.out.print("Masukkan harga baru: ");
                        double newPrice = 0;
                        if (scanner.hasNextDouble()) {
                            newPrice = scanner.nextDouble();
                        } else {
                            System.out.println("Harga tidak valid. Harap masukkan angka.");
                            scanner.nextLine(); // Consume invalid input
                            continue;
                        }

                        inventory.updateProduct(updateId, newQuantity, newPrice);
                    }

                    case 4 -> {
                        // Menghapus produk
                        System.out.print("Masukkan ID Produk yang akan dihapus: ");
                        String deleteId = scanner.nextLine();
                        inventory.deleteProduct(deleteId);
                    }

                    case 5 -> {
                        // Keluar dari program
                        running = false;
                        System.out.println("Keluar...");
                    }

                    default -> {
                        System.out.println("Input tidak valid. Harap pilih angka antara 1 dan 5.");
                    }
                }

                System.out.println();
            }
        }
    }
}
