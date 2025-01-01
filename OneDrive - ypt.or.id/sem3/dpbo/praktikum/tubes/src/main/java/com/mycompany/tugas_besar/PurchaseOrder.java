/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugas_besar;

/**
 *
 * @author LENOVO
 */
class PurchaseOrder extends Order {
    @Override
    public void createOrder() {
        System.out.println("Membuat pesanan pembelian");
    }

    @Override
    public void updateOrder() {
        System.out.println("Memperbarui pesanan pembelian");
    }
}