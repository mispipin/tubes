/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugas_besar;

/**
 *
 * @author LENOVO
 */
abstract class Staff {
    protected String staffId;
    protected String name;
    protected String role;

    public abstract void manageStock();
    
    public void retrieveProduct() {
        System.out.println("Mengambil produk...");
    }
}
