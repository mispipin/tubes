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

   
            
            Map<String, Category> categories = new HashMap<>();
            Map<String, Order> orders = new HashMap<>(); // Menyimpan pesanan
            Map<String, Staff> staffDirectory = new HashMap<>();



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
                       System.out.println("Kategori yang tersedia:");
                        // Menampilkan daftar kategori
                        for (Category category : inventory.getCategories()) {
                            System.out.println("- ID: " + category.getCategoryId() + ", Nama: " + category.getName());
                        }
                        System.out.print("Masukkan ID Kategori: ");
                        String categoryId = scanner.nextLine();

                        // Cek apakah kategori ada
                        Category selectedCategory = null;
                        for (Category category : inventory.getCategories()) {
                            if (category.getCategoryId().equals(categoryId)) {
                                selectedCategory = category;
                                break;
                            }
                        }

                        if (selectedCategory == null) {
                            System.out.println("Kategori tidak ditemukan.");
                        } else {
                            // Masukkan detail produk
                            System.out.print("Masukkan ID Produk: ");
                            String id = scanner.nextLine();
                            System.out.print("Masukkan Nama Produk: ");
                            String name = scanner.nextLine();

                            double price = 0.0;
                            int quantity = 0;

                            // Validasi input harga
                            while (true) {
                                try {
                                    System.out.print("Masukkan Harga: ");
                                    price = Double.parseDouble(scanner.nextLine());
                                    if (price <= 0) throw new IllegalArgumentException("Harga harus lebih besar dari 0.");
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Input tidak valid! Harga harus berupa angka.");
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                            }

                            // Validasi input jumlah
                            while (true) {
                                try {
                                    System.out.print("Masukkan Jumlah: ");
                                    quantity = Integer.parseInt(scanner.nextLine());
                                    if (quantity < 0) throw new IllegalArgumentException("Jumlah tidak boleh negatif.");
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Input tidak valid! Jumlah harus berupa angka bulat.");
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                            }

                            // Tanyakan apakah produk fisik atau digital
                            System.out.print("Jenis produk (1 untuk Fisik, 2 untuk Digital): ");
                            int productType = scanner.nextInt();
                            scanner.nextLine();  // Menghapus newline

                            if (productType == 1) {
                                // Membuat produk fisik
                                PhysicalProduct physicalProduct = new PhysicalProduct(id, name, price, quantity);
                                selectedCategory.addProduct(physicalProduct);
                                inventory.addProduct(physicalProduct);
                                System.out.println("Produk fisik berhasil ditambahkan.");
                            } else if (productType == 2) {
                                // Membuat produk digital
                                DigitalProduct digitalProduct = new DigitalProduct(id, name, price, quantity);
                                selectedCategory.addProduct(digitalProduct);
                                inventory.addProduct(digitalProduct);
                                System.out.println("Produk digital berhasil ditambahkan.");
                            } else {
                                System.out.println("Pilihan tidak valid.");
                            }
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

                        // Buat kategori baru dan tambahkan ke inventori
                        Category newCategory = new Category(categoryId, categoryName);
                        inventory.addCategory(newCategory);

                        System.out.println("Kategori \"" + categoryName + "\" berhasil ditambahkan.");
                        break;
                    }
                    case 7 -> {
                        System.out.println("Daftar Kategori dan Produknya:");
                        if (inventory.getCategories().isEmpty()) {
                            System.out.println("Tidak ada kategori yang tersedia.");
                        } else {
                            for (Category category : inventory.getCategories()) {
                                System.out.println("\nKategori: " + category.getName());
                                List<Product> products = category.getProducts();
                                if (products.isEmpty()) {
                                    System.out.println("  Tidak ada produk dalam kategori ini.");
                                } else {
                                    for (Product product : products) {
                                        System.out.println("  - ID: " + product.productId + ", Nama: " + product.name +
                                                           ", Harga: " + product.price + ", Jumlah: " + product.quantity);
                                    }
                                }
                            }
                        }
                        break;
                    }
                    case 8 -> 
                    {
                       Order order = new Order(); // Membuat pesanan baru dengan kode unik
                        orders.put(order.getOrderId(), order); // Simpan pesanan ke map

                        System.out.println("Pesanan berhasil dibuat dengan Kode: " + order.getOrderId());

                        boolean ordering = true;
                        while (ordering) {
                            System.out.println("\n===== Menu Pesanan =====");
                            System.out.println("1. Tambah Produk ke Pesanan");
                            System.out.println("2. Lihat Ringkasan Pesanan");
                            System.out.println("3. Atur Diskon");
                            System.out.println("4. Atur Pajak");
                            System.out.println("5. Atur Status Pengiriman");
                            System.out.println("6. Selesai");

                            System.out.print("Pilih opsi: ");
                            int pilih = scanner.nextInt();
                            scanner.nextLine();

                            switch (pilih) {
                                case 1 -> {
                                    System.out.println("Produk yang tersedia:");
                                    inventory.displayProducts();

                                    System.out.print("Masukkan ID produk: ");
                                    String productId = scanner.nextLine();
                                    Product product = inventory.getProductById(productId);

                                    if (product == null) {
                                        System.out.println("Produk tidak ditemukan.");
                                        break;
                                    }

                                    System.out.print("Masukkan jumlah: ");
                                    int quantity = scanner.nextInt();
                                    scanner.nextLine();

                                    order.addProduct(product, quantity);
                                }
                                case 2 -> order.printOrderSummary();
                                case 3 -> {
                                    System.out.print("Masukkan diskon (dalam persen): ");
                                    double discount = scanner.nextDouble();
                                    order.setDiscount(discount);
                                }
                                case 4 -> {
                                    System.out.print("Masukkan pajak (dalam persen): ");
                                    double tax = scanner.nextDouble();
                                    order.setTax(tax);
                                }
                                case 5 -> {
                                    System.out.print("Masukkan status pengiriman (Pending/Shipped/Delivered): ");
                                    String status = scanner.nextLine();
                                    order.setStatus(status);
                                }
                                case 6 -> {
                                    order.printOrderSummary();
                                    ordering = false;
                                }
                                default -> System.out.println("Opsi tidak valid.");
                            }
                        }
                    }
                    case 9 -> StaffManagement.staffMenu(scanner);
                    case 10 -> {
                        System.out.print("Masukkan Kode Pesanan: ");
                        String searchOrderId = scanner.nextLine();
                        Order foundOrder = orders.get(searchOrderId);

                        if (foundOrder != null) {
                            foundOrder.printOrderSummary();
                        } else {
                            System.out.println("Pesanan dengan kode " + searchOrderId + " tidak ditemukan.");
                        }}
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