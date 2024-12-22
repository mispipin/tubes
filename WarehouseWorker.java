/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugas_besar;

/**
 *
 * @author LENOVO
 */
class WarehouseWorker extends Staff {
    @Override
    public void manageStock() {
        System.out.println("Managing stock as warehouse worker");
    }

    public void retrieveProduct() {
        System.out.println("Retrieving product...");
    }

    public void storeProduct() {
        System.out.println("Storing product...");
    }
}
