/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author ridho
 */
import db.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderDao {

    public void placeOrder(String userEmail, String daerah, int totalSampah,
            String kategoriSampah, String emailKurir, String namaKategori) throws SQLException {
        try (Connection connection = MySqlConnection.getInstance().getConnection(); PreparedStatement preparedStatementOrder = connection.prepareStatement(
                "INSERT INTO orders (email_user, daerah, total_sampah, kategori_sampah, email_kurir) VALUES (?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS); PreparedStatement preparedStatementUser = connection.prepareStatement(
                        "UPDATE users SET point = point + 6 WHERE email_user = ?"); PreparedStatement preparedStatementKurir = connection.prepareStatement(
                        "UPDATE kurir SET point_kurir = point_kurir + 12 WHERE email_kurir = ?"); PreparedStatement preparedStatementKategori = connection.prepareStatement(
                        "INSERT INTO kategori_terbanyak (nama_kategori, jumlah_order) VALUES (?, 1) ON DUPLICATE KEY UPDATE jumlah_order = jumlah_order + 1")) {

            connection.setAutoCommit(false);

            preparedStatementOrder.setString(1, userEmail);
            preparedStatementOrder.setString(2, daerah);
            preparedStatementOrder.setInt(3, totalSampah);
            preparedStatementOrder.setString(4, kategoriSampah);
            preparedStatementOrder.setString(5, emailKurir);

            preparedStatementOrder.executeUpdate();

            // Get the generated order ID
            // Add logic to retrieve generated keys if needed
            preparedStatementUser.setString(1, userEmail);
            preparedStatementUser.executeUpdate();

            preparedStatementKurir.setString(1, emailKurir);
            preparedStatementKurir.executeUpdate();

            // Insert or update kategori_terbanyak based on the provided namaKategori
            preparedStatementKategori.setString(1, namaKategori);
            preparedStatementKategori.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            // Handle exception or rollback transaction
            e.printStackTrace();
        }
    }

    // You may need additional methods based on your application requirements
    // For example, methods to retrieve orders, update orders, etc.
    // ...
    // Helper methods to handle ResultSet mapping if needed
}
