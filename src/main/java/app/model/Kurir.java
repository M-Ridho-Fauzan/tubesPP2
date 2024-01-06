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

    private long id;
    private String email;
    private int point;

    // Konstruktor, setter, getter
    public Kurir() {
        // Konstruktor kosong
    }

    public Kurir(long id, String email, int point) {
        this.id = id;
        this.email = email;
        this.point = point;
    }

    // Setter
    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    // Getter
    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public int getPoint() {
        return point;
    }
}
