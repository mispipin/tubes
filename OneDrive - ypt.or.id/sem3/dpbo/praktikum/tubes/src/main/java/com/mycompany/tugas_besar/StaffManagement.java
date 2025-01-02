/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugas_besar;

/**
 *
 * @author LEGION
 */
import java.util.*; // Import utilitas seperti Scanner, Map, dll.

public class StaffManagement {
    private static Map<String, Staff> staffDirectory = new HashMap<>();

    public static void staffMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n=== Menu Pengelolaan Staf ===");
            System.out.println("1. Tambah Staf");
            System.out.println("2. Lihat Semua Staf");
            System.out.println("3. Jalankan Tugas Staf");
            System.out.println("4. Kembali ke Menu Utama");
            System.out.print("Pilih opsi: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Bersihkan buffer

            switch (choice) {
                case 1 -> addStaff(scanner);
                case 2 -> viewStaff();
                case 3 -> assignTask(scanner);
                case 4 -> System.out.println("Kembali ke menu utama...");
                default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (choice != 4);
    }

    private static void addStaff(Scanner scanner) {
        System.out.print("Masukkan nama staf: ");
        String name = scanner.nextLine();

        System.out.print("Masukkan jabatan staf: ");
        String position = scanner.nextLine();

        System.out.println("Pilih peran staf:");
        System.out.println("1. Manager");
        System.out.println("2. Warehouse Worker");
        System.out.print("Pilih peran: ");
        int roleChoice = scanner.nextInt();
        scanner.nextLine(); // Bersihkan buffer

        Staff newStaff;
        if (roleChoice == 1) {
            newStaff = new Manager(name, position);
        } else if (roleChoice == 2) {
            newStaff = new WarehouseWorker(name, position);
        } else {
            System.out.println("Peran tidak valid. Staf tidak ditambahkan.");
            return;
        }

        staffDirectory.put(newStaff.getStaffId(), newStaff);
        System.out.println("Staf berhasil ditambahkan dengan ID: " + newStaff.getStaffId());
    }

    private static void viewStaff() {
        if (staffDirectory.isEmpty()) {
            System.out.println("Belum ada staf yang terdaftar.");
        } else {
            System.out.println("\n=== Daftar Staf ===");
            for (Staff staff : staffDirectory.values()) {
                staff.displayInfo();
            }
        }
    }

    private static void assignTask(Scanner scanner) {
        if (staffDirectory.isEmpty()) {
            System.out.println("Belum ada staf yang terdaftar.");
            return;
        }

        System.out.println("\n=== Daftar Staf ===");
        for (Staff staff : staffDirectory.values()) {
            staff.displayInfo();
        }

        System.out.print("\nMasukkan ID staf untuk menjalankan tugas: ");
        String staffId = scanner.nextLine();
        Staff selectedStaff = staffDirectory.get(staffId);

        if (selectedStaff == null) {
            System.out.println("Staf dengan ID " + staffId + " tidak ditemukan.");
        } else {
            if (selectedStaff instanceof Manager manager) {
                manager.manageStock();
            } else if (selectedStaff instanceof WarehouseWorker worker) {
                worker.retrieveProduct();
            } else {
                System.out.println("Staf ini tidak memiliki tugas yang ditentukan.");
            }
        }
    }
}

