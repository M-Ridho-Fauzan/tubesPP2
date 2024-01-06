/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;

/**
 *
 * @author ridho
 */
public class KategoriTerbanyak {

    private long id;
    private String namaKategori;
    private int jumlahOrder;

    // Constructor
    // Konstruktor, setter, getter
    public KategoriTerbanyak() {
        // Konstruktor kosong
    }
    // Getter and Setter methods for each field

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public void setNamaKategori(String namaKategori) {
        this.namaKategori = namaKategori;
    }

    public int getJumlahOrder() {
        return jumlahOrder;
    }

    public void setJumlahOrder(int jumlahOrder) {
        this.jumlahOrder = jumlahOrder;
    }
}
