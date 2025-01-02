/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugas_besar;

/**
 *
 * @author LENOVO
 */
public class Manager extends Staff {
    public Manager(String name, String position) {
        super(name, position, "Manager");
    }

    public void manageStock() {
        System.out.println("Manager sedang mengelola stok...");
        // Tambahkan logika pengelolaan stok
    }
}