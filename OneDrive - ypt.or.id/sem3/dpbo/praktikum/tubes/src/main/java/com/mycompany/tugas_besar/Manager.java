/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugas_besar;

/**
 *
 * @author LENOVO
 */
class Manager extends Staff {
    @Override
    public void manageStock() {
        System.out.println("Mengelola stok sebagai manajer");
    }

    public void generateReport() {
        System.out.println("Membuat laporan...");
    }

    public void manageStaff() {
        System.out.println("Mengelola staf...");
    }
}