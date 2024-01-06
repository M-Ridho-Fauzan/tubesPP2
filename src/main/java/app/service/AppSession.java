/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.service;

import app.model.User;

/**
 *
 * @author ridho
 */
public class AppSession {

    private static AppSession instance;
    private User loggedInUser;

    private AppSession() {
        // Constructor private untuk mencegah instansiasi langsung
    }

    public static AppSession getInstance() {
        if (instance == null) {
            instance = new AppSession();
        }
        return instance;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User user) {
        loggedInUser = user;
    }

    public void logout() {
        // Bersihkan sesi atau lakukan tindakan logout lainnya
        loggedInUser = null;
    }
}
