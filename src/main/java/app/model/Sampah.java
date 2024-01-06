/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;

/**
 *
 * @author ridho
 */
public class Sampah {

    private long id;
    private String name;
    private String kategori;
    private String alamatUser;
    private String emailUser;
    private String emailKurir;
    private int viewCount;

    // Konstruktor, setter, getter
    public Sampah() {
        // Konstruktor kosong
    }

    public Sampah(long id, String name, String kategori, String alamatUser, String emailUser, String emailKurir, int viewCount) {
        this.id = id;
        this.name = name;
        this.kategori = kategori;
        this.alamatUser = alamatUser;
        this.emailUser = emailUser;
        this.emailKurir = emailKurir;
        this.viewCount = viewCount;
    }

    // Setter
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setAlamatUser(String alamatUser) {
        this.alamatUser = alamatUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public void setEmailKurir(String emailKurir) {
        this.emailKurir = emailKurir;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    // Getter
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getKategori() {
        return kategori;
    }

    public String getAlamatUser() {
        return alamatUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public String getEmailKurir() {
        return emailKurir;
    }

    public int getViewCount() {
        return viewCount;
    }
}
