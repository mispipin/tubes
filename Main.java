package com.mycompany.tugas_besar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Inventory inventory = new Inventory();
            boolean running = true;

            // Menambahkan beberapa kategori dan produk awal
            Category electronics = new Category("C001", "Elektronik");
            Category books = new Category("C002", "Buku");
            inventory.addCategory(electronics);
            inventory.addCategory(books);

            PhysicalProduct laptop = new PhysicalProduct();
            laptop.productId = "P001";
            laptop.name = "Laptop";
            laptop.price = 15000000;
            laptop.quantity = 10;
            electronics.addProduct(laptop);
            inventory.addProduct(laptop);

            DigitalProduct eBook = new DigitalProduct();
            eBook.productId = "P002";
            eBook.name = "E-Book Pemrograman";
            eBook.price = 100000;
            eBook.quantity = 50;
            books.addProduct(eBook);
            inventory.addProduct(eBook);

            // Menambahkan staf
            Staff manager = new Manager();
            Staff warehouseWorker = new WarehouseWorker();

            while (running) {
                System.out.println("===== ITProcure =====");
                System.out.println("1. Tambah Produk");
                System.out.println("2. Lihat Semua Produk");
                System.out.println("3. Update Produk");
                System.out.println("4. Hapus Produk");
                System.out.println("5. Cari Produk");
                System.out.println("6. Tambah Kategori");
                System.out.println("7. Lihat Kategori");
                System.out.println("8. Terapkan Diskon");
                System.out.println("9. Buat Pesanan");
                System.out.println("10. Kelola Staf");
                System.out.println("11. Lihat Pengiriman");
                System.out.println("12. Hitung Pajak");
                System.out.println("13. Keluar");
                System.out.print("Pilih opsi: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Masukkan ID Produk : ");
                        String id = scanner.nextLine();
                        System.out.print("Masukkan Nama Produk: ");
                        String name = scanner.nextLine();
                        System.out.print("Masukkan Harga: ");
                        double price = scanner.nextDouble();
                        System.out.print("Masukkan Jumlah: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();

                        PhysicalProduct product = new PhysicalProduct();
                        product.productId = id;
                        product.name = name;
                        product.price = price;
                        product.quantity = quantity;
                        inventory.addProduct(product);
                    }
                    case 2 -> inventory.displayProducts();
                    case 3 -> {
                        System.out.print("Masukkan ID Produk untuk memperbarui: ");
                        String id = scanner.nextLine();
                        System.out.print("Masukkan Jumlah baru: ");
                        int quantity = scanner.nextInt();
                        System.out.print("Masukkan Harga Baru: ");
                        double price = scanner.nextDouble();
                        inventory.updateProduct(id, quantity, price);
                    }
                    case 4 -> {
                        System.out.print("Masukkan ID Produk untuk menghapus: ");
                        String id = scanner.nextLine();
                        inventory.deleteProduct(id);
                    }
                    case 5 -> {
                        System.out.print("Masukkan kata kunci untuk pencarian: ");
                        String keyword = scanner.nextLine();
                        inventory.searchProduct(keyword);
                    }
                    case 6 -> {
                        System.out.print("Masukkan ID Kategori: ");
                        String id = scanner.nextLine();
                        System.out.print("Masukkan Nama Kategori: ");
                        String name = scanner.nextLine();
                        Category category = new Category(id, name);
                        inventory.addCategory(category);
                    }
                    case 7 -> inventory.displayCategories();
                    case 8 -> {
                        System.out.print("Masukkan diskon (misalkan, 0,1 untuk 10%): ");
                        double discountRate = scanner.nextDouble();
                        inventory.applyGlobalDiscount(discountRate);
                    }
                    case 9 -> 
                    {
                        System.out.print("Masukkan ID Pesanan: ");
                        String orderId = scanner.nextLine();
                        System.out.print("Masukkan Total Jumlah: ");
                        double totalAmount = scanner.nextDouble();
                        PurchaseOrder purchaseOrder = new PurchaseOrder();
                        purchaseOrder.orderId = orderId;
                        purchaseOrder.totalAmount = totalAmount;
                        purchaseOrder.createOrder();
                    }
                    case 10 -> {
                        System.out.println("1. Kelola Stok (Manajer)");
                        System.out.println("2. Ambil Produk (Pekerja Gudang)");
                        System.out.print("Pilih opsi: ");
                        int staffChoice = scanner.nextInt();
                        scanner.nextLine();
                        switch (staffChoice) {
                            case 1 -> manager.manageStock();
                            case 2 -> warehouseWorker.retrieveProduct();
                            default -> System.out.println("Opsi tidak valid.");
                        }
                    }
                    case 11 -> {
                        Shipment shipment = new Shipment();
                        System.out.print("Masukkan ID Pengiriman: ");
                        String shipmentId = scanner.nextLine();
                        System.out.print("Masukkan Alamat: ");
                        String address = scanner.nextLine();
                        System.out.print("Masukkan Status: ");
                        String status = scanner.nextLine();
                        System.out.println("Pengiriman dibuat dengan ID: " + shipmentId);
                    }
                    case 12 -> {
                        System.out.print("Masukkan ID Produk untuk menghitung pajak: ");
                        String productId = scanner.nextLine();
                        for (Product product : inventory.products) {
                            if (product.productId.equals(productId)) {
                                Tax tax = new Tax();
                                System.out.print("Masukkan tarif pajak (misalkan, 0,1 untuk 10%): ");
                                tax.taxRate = scanner.nextDouble();
                                double calculatedTax = tax.calculateTax(product);
                                System.out.println("Pajak untuk produk " + product.name + ": Rp" + String.format("%.2f", calculatedTax));
                                break;
                            }
                        }
                    }
                    case 13 -> {
                        System.out.println("Keluar dari ITProcure. Selamat tinggal!. Goodbye!");
                        running = false;
                    }
                    default -> System.out.println("Opsi tidak valid. Silakan coba lagi.");
                }
            }
        }
    }
}
