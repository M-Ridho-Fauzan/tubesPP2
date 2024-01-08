/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;

/**
 *
 * @author ridho
 */
public class Kurir {

    private long id_kurir;
    private String emailKurir;
    private int pointKurir;

    // Konstruktor, setter, getter
    public Kurir() {
        // Konstruktor kosong
    }
    // Getter and Setter methods for each field

    public void setKurirId(long id_kurir) {
        this.id_kurir = id_kurir;
    }

    public long getKurirId() {
        return id_kurir;
    }

    public String getEmailKurir() {
        return emailKurir;
    }

    public void setEmailKurir(String emailKurir) {
        this.emailKurir = emailKurir;
    }

    public int getPointKurir() {
        return pointKurir;
    }

    public void setPointKurir(int pointKurir) {
        this.pointKurir = pointKurir;
    }
}
