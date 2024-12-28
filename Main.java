package com.mycompany.tugas_besar;
import java.util.Scanner;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Inventory inventory = new Inventory();
            boolean running = true;

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
                System.out.println("9. Keluar");
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
                    case 9 -> {
                        System.out.println("Keluar dari ITProcure. Selamat tinggal!. Goodbye!");
                        running = false;
                    }
                    default -> System.out.println("Opsi tidak valid. Silakan coba lagi.");
                }
            }
        }
    }
}

