/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugas_besar;

/**
 *
 * @author LENOVO
 */
class Shipment {
    private String shipmentId;
    private String address;
    private String status;

    public String trackShipment() {
        return "Tracking shipment: " + shipmentId;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}