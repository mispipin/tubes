package com.mycompany.tugas_besar;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Inventory inventory = new Inventory();
            boolean running = true;

            // Menambahkan beberapa kategori dan produk awal
            Category electronics = new Category("C1", "Elektronik");
            Category books = new Category("C2", "Buku");
            inventory.addCategory(electronics);
            inventory.addCategory(books);

            PhysicalProduct laptop = new PhysicalProduct("P001", "Laptop", 15000000, 10);
            electronics.addProduct(laptop);
            inventory.addProduct(laptop);

            DigitalProduct eBook = new DigitalProduct("P002", "E-Book Pemrograman", 100000, 50);
            books.addProduct(eBook);
            inventory.addProduct(eBook);

            // Menambahkan staf
            Staff manager = new Manager();
            Staff warehouseWorker = new WarehouseWorker();
            
            Map<String, Category> categories = new HashMap<>();

            while (running) {
                System.out.println("===== ITProcure =====");
                System.out.println("1. Tambah Produk");
                System.out.println("2. Lihat Semua Produk");
                System.out.println("3. Update Produk");
                System.out.println("4. Hapus Produk");
                System.out.println("5. Cari Produk");
                System.out.println("6. Tambah Kategori");
                System.out.println("7. Lihat Kategori");
                System.out.println("8. Buat Pesanan");
                System.out.println("9. Kelola Staf");
                System.out.println("10. Lihat Pengiriman");
                System.out.println("0. Keluar");
                System.out.print("Pilih opsi: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Masukkan ID Kategori: ");
                    String categoryId = scanner.nextLine();

                    if (categories.containsKey(categoryId)) {
                        // Masukkan detail produk
                        System.out.print("Masukkan ID Produk: ");
                        String id = scanner.nextLine();
                        System.out.print("Masukkan Nama Produk: ");
                        String name = scanner.nextLine();
                        System.out.print("Masukkan Harga: ");
                        double price = scanner.nextDouble();
                        System.out.print("Masukkan Jumlah: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine(); // Menghapus newline dari input buffer

                        // Membuat produk
                        PhysicalProduct product = new PhysicalProduct(id, name, price, quantity);

                        // Menambahkan produk ke kategori
                        categories.get(categoryId).addProduct(product);
                        
                        inventory.addProduct(product);
                    } else {
                        System.out.println("Kategori tidak ditemukan.");
                    }
                    break;
                    }
                    case 2 -> inventory.displayProducts();
                    case 3 -> {
                        System.out.print("Masukkan ID Produk yang ingin di-update: ");
                        String updateProductId = scanner.nextLine();

                        // Cari produk di dalam inventory
                        Product productToUpdate = null;
                        for (Category category : inventory.getCategories()) {
                            for (Product product : category.getProducts()) {
                                if (product.productId.equals(updateProductId)) {
                                    productToUpdate = product;
                                    break;
                                }
                            }
                        }

                        if (productToUpdate == null) {
                            System.out.println("Produk dengan ID " + updateProductId + " tidak ditemukan.");
                        } else {
                            // Menu update
                            System.out.println("Produk ditemukan: " + productToUpdate.name);
                            System.out.println("1. Update Nama");
                            System.out.println("2. Update Harga");
                            System.out.println("3. Update Jumlah");
                            System.out.print("Pilih opsi: ");
                            int updateChoice = scanner.nextInt();
                            scanner.nextLine(); // Hapus newline dari buffer

                            switch (updateChoice) {
                                case 1:
                                    System.out.print("Masukkan Nama Baru: ");
                                    String newName = scanner.nextLine();
                                    productToUpdate.name = newName;
                                    System.out.println("Nama produk berhasil di-update.");
                                    break;

                                case 2:
                                    System.out.print("Masukkan Harga Baru: ");
                                    double newPrice = scanner.nextDouble();
                                    productToUpdate.price = newPrice;
                                    System.out.println("Harga produk berhasil di-update.");
                                    break;

                                case 3:
                                    System.out.print("Masukkan Jumlah Baru: ");
                                    int newQuantity = scanner.nextInt();
                                    productToUpdate.quantity = newQuantity;
                                    System.out.println("Jumlah produk berhasil di-update.");
                                    break;

                                default:
                                    System.out.println("Pilihan tidak valid.");
                            }
                        }
                        break;
                    }
                    case 4 -> {
                        System.out.print("Masukkan ID Produk yang ingin dihapus: ");
                        String deleteProductId = scanner.nextLine();

                        // Cari dan hapus produk
                        boolean found = false;
                        for (Category category : inventory.getCategories()) {
                            List<Product> products = category.getProducts();
                            for (int i = 0; i < products.size(); i++) {
                                if (products.get(i).productId.equals(deleteProductId)) {
                                    System.out.println("Produk ditemukan: " + products.get(i).name);
                                    products.remove(i); // Hapus produk dari kategori
                                    inventory.removeProduct(deleteProductId); // Hapus dari inventori (jika ada)
                                    System.out.println("Produk berhasil dihapus.");
                                    found = true;
                                    break;
                                }
                            }
                            if (found) break; // Jika produk ditemukan, keluar dari loop kategori
                        }

                        if (!found) {
                            System.out.println("Produk dengan ID " + deleteProductId + " tidak ditemukan.");
                        }
                        break;
                    }
                    case 5 -> {
                        System.out.println("Pencarian Produk");
                        System.out.println("1. Berdasarkan Nama");
                        System.out.println("2. Berdasarkan Harga");
                        System.out.println("3. Berdasarkan Kategori");
                        System.out.print("Pilih opsi pencarian: ");
                        int searchChoice = scanner.nextInt();
                        scanner.nextLine();  // Menghapus newline
                        switch (searchChoice) {
                            case 1 -> {
                                System.out.print("Masukkan kata kunci nama produk: ");
                                String keyword = scanner.nextLine();
                                inventory.searchProductByName(keyword);
                            }
                            case 2 -> {
                                System.out.print("Masukkan harga minimal: ");
                                double minPrice = scanner.nextDouble();
                                System.out.print("Masukkan harga maksimal: ");
                                double maxPrice = scanner.nextDouble();
                                inventory.searchProductByPrice(minPrice, maxPrice);
                            }
                            case 3 -> {
                                System.out.print("Masukkan ID Kategori: ");
                                String categoryId = scanner.nextLine();
                                inventory.searchProductByCategory(categoryId);
                            }
                            default -> System.out.println("Pilihan tidak valid.");
                        }
                    }
                    case 6 -> {
                        System.out.print("Masukkan ID Kategori: ");
                        String categoryId = scanner.nextLine();
                        System.out.print("Masukkan Nama Kategori: ");
                        String categoryName = scanner.nextLine();
                        categories.put(categoryId, new Category(categoryId, categoryName));
                        System.out.println("Kategori berhasil ditambahkan!");
                    break;
                    }
                    case 7 -> inventory.displayCategories();
                    case 56 -> {
                        System.out.print("Masukkan diskon (misalkan, 0,1 untuk 10%): ");
                        double discountRate = scanner.nextDouble();
                        inventory.applyGlobalDiscount(discountRate);
                    }
                    case 8 -> 
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
                    case 9 -> {
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
                    case 10 -> {
                        Shipment shipment = new Shipment();
                        System.out.print("Masukkan ID Pengiriman: ");
                        String shipmentId = scanner.nextLine();
                        System.out.print("Masukkan Alamat: ");
                        String address = scanner.nextLine();
                        System.out.print("Masukkan Status: ");
                        String status = scanner.nextLine();
                        System.out.println("Pengiriman dibuat dengan ID: " + shipmentId);
                    }
                    case 89 -> {
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
                    case 0 -> {
                        System.out.println("Keluar dari ITProcure. Selamat tinggal!. Goodbye!");
                        running = false;
                    }
                default -> System.out.println("Opsi tidak valid. Silakan coba lagi.");
                }
            }
        }
    }
}