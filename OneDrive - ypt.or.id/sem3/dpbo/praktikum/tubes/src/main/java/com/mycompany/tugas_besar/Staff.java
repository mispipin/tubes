/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugas_besar;

/**
 *
 * @author LENOVO
 */
import java.util.UUID;

public class Staff {
    private String staffId;
    private String name;
    private String position;
    private String role;

    public Staff(String name, String position, String role) {
        this.staffId = generateStaffId();
        this.name = name;
        this.position = position;
        this.role = role;
    }

    private String generateStaffId() {
        return "STF-" + UUID.randomUUID().toString().substring(0, 8);
    }

    public String getStaffId() {
        return staffId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getRole() {
        return role;
    }

    public void displayInfo() {
        System.out.println("ID: " + staffId + " | Nama: " + name + " | Jabatan: " + position + " | Peran: " + role);
    }
}

