/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

/**
 *
 * @author ridho
 */
public class User {

    private String id; // Variable id untuk menyimpan nilai id
    private String name; // Variable nama untuk menyimpan nilai nama
    private String email;
    private String password;
    private String telp; // Variable telp untuk menyimpan nilai telp
    private String alamat; // Variable alamat untuk menyimpan nilai alamat
    private boolean is_admin;

    // Set nilai dari id dengan parameter id
    public void setUserId(String id) {
        // Set this.id dengan parameter id
        this.id = id;
    }

    // Dapatkan nilai dari id
    public String getUserId() {
        // Kembalikan nilai dari this.id
        return this.id;
    }
//    ==========================

    // Set nilai dari nama dengan parameter nama
    public void setUserName(String name) {
        // Set this.nama dengan parameter nama
        this.name = name;
    }

    // Dapatkan nilai dari nama
    public String getUserName() {
        // Kembalikan nilai dari this.nama
        return this.name;
    }

    //    ==========================
    // Set nilai dari nama dengan parameter nama
    public void setUserEmail(String email) {
        // Set this.nama dengan parameter nama
        this.email = email;
    }

    // Dapatkan nilai dari nama
    public String getUserEmail() {
        // Kembalikan nilai dari this.nama
        return this.email;
    }
//==========================

    public void setUserPassword(String password) {
        this.password = password;
    }

    public String getUserPassword() {
        return this.password;
    }

//==========================
    // Set nilai dari telp dengan parameter telp
    public void setUserTelp(String telp) {
        // Set this.telp dengan parameter telp
        this.telp = telp;
    }

    // Dapatkan nilai dari telp
    public String getUserTelp() {
        // Kembalikan nilai dari this.telp
        return this.telp;
    }

//    ========================
    // Set nilai dari alamat dengan parameter alamat
    public void setUserAlamat(String alamat) {
        // Set this.alamat dengan parameter alamat
        this.alamat = alamat;
    }

    // Dapatkan nilai dari alamat
    public String getUserAlamat() {
        // Kembalikan nilai dari this.alamat
        return this.alamat;
    }

    //    ========================
    // Set nilai dari alamat dengan parameter alamat
    public void setIsAdmin(Boolean admin) {
        // Set this.alamat dengan parameter alamat
        this.is_admin = admin;
    }

    // Dapatkan nilai dari alamat
    public Boolean getUserIsAdmin() {
        // Kembalikan nilai dari this.alamat
        return this.is_admin;
    }
}
