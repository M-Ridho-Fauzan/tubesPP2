/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;

/**
 *
 * @author ridho
 */
import java.sql.Timestamp;

public class Order {

    private long id;
    private String emailUser;
    private String daerah;
    private int totalSampah;
    private String kategoriSampah;
    private String emailKurir;
    private Timestamp tanggalOrder;

    // Constructor
    // Konstruktor, setter, getter
    public Order() {
        // Konstruktor kosong
    }

    // Getter and Setter methods for each field
    public long getIdOrder() {
        return id;
    }

    public void setIdOrder(long id) {
        this.id = id;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getDaerah() {
        return daerah;
    }

    public void setDaerah(String daerah) {
        this.daerah = daerah;
    }

    public int getTotalSampah() {
        return totalSampah;
    }

    public void setTotalSampah(int totalSampah) {
        this.totalSampah = totalSampah;
    }

    public String getKategoriSampah() {
        return kategoriSampah;
    }

    public void setKategoriSampah(String kategoriSampah) {
        this.kategoriSampah = kategoriSampah;
    }

    public String getEmailKurir() {
        return emailKurir;
    }

    public void setEmailKurir(String emailKurir) {
        this.emailKurir = emailKurir;
    }

    public Timestamp getTanggalOrder() {
        return tanggalOrder;
    }

    public void setTanggalOrder(Timestamp tanggalOrder) {
        this.tanggalOrder = tanggalOrder;
    }
}
