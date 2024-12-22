/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugas_besar;

/**
 *
 * @author LENOVO
 */
class Category {
    private String categoryId;
    private String name;

    public void addProduct(Product product) {
        System.out.println("Product added to category: " + name);
    }

    public void removeProduct(Product product) {
        System.out.println("Product removed from category: " + name);
    }
}
