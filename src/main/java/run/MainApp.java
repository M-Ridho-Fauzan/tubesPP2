/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package run;

import db.Seeders;
import id.ac.unpas.tubes.aut.Login;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author ridho
 */
public class MainApp {

    public static void main(String[] args) {
        // Membuat objek frame
        JFrame frame = new JFrame("Main App");

        // Seeder db
        Seeders seeders = new Seeders();
        seeders.insertAdmin();

        // Menetapkan panel awal ke frame
        Login loginPanel = new Login();
        frame.setContentPane(loginPanel);

        // Mengatur operasi penutupan frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Mengatur ukuran frame
        // frame.setSize(400, 300);
        frame.setMaximumSize(new Dimension(700, Integer.MAX_VALUE)); // Set maximum width
        frame.setMinimumSize(new Dimension(850, 650)); // Set minimum width
        frame.setSize(850, 650);

        // Menempatkan frame di tengah layar
        frame.setLocationRelativeTo(null);

        // Menampilkan frame
        frame.setVisible(true);
    }
}
