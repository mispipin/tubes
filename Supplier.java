/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugas_besar;

/**
 *
 * @author LENOVO
 */
class Supplier {
    private String supplierId;
    private String name;
    private String contactInfo;

    public void provideProduct(Product product) {
        System.out.println("Supplier providing product: " + product.name);
    }
}