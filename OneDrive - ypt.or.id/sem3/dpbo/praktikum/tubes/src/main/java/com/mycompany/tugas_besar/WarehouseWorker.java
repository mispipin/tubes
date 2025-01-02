/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugas_besar;

/**
 *
 * @author LENOVO
 */
public class WarehouseWorker extends Staff {
    public WarehouseWorker(String name, String position) {
        super(name, position, "Warehouse Worker");
    }

    public void retrieveProduct() {
        System.out.println("Warehouse Worker sedang mengambil produk...");
        // Tambahkan logika pengambilan produk
    }
}
