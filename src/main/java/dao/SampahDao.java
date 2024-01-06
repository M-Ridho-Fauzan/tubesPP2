/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author ridho
 */
import app.model.Sampah;
import db.MySqlConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SampahDao {

    private static final String INSERT_QUERY = "INSERT INTO sampah(name_sampah, kategori_sampah, alamat_user, email_user, email_kurir) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM sampah";
    private static final String UPDATE_VIEW_QUERY = "UPDATE sampah SET view_sampah = view_sampah + 1 WHERE id = ?";
    private static final String SELECT_TOP_PER_DAERAH_QUERY = "SELECT * FROM sampah WHERE email_kurir = ? ORDER BY view_sampah DESC LIMIT 1";
    private static final String SELECT_TOP_PER_KATEGORI_QUERY = "SELECT * FROM sampah WHERE kategori_sampah = ? ORDER BY view_sampah DESC LIMIT 1";

    public int insert(Sampah sampah) {
        int result = -1;

        try (Connection connection = MySqlConnection.getInstance().getConnection(); PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {

            setStatementParameters(statement, sampah);
            result = statement.executeUpdate();

            System.out.println("Insert data: " + sampah.getId() + " " + sampah.getName() + " "
                    + sampah.getKategori() + " " + sampah.getAlamatUser() + " " + sampah.getEmailUser() + " "
                    + sampah.getEmailKurir());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<Sampah> findAll() {
        List<Sampah> list = new ArrayList<>();

        try (Connection connection = MySqlConnection.getInstance().getConnection(); Statement statement
                = connection.createStatement(); ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUERY)) {

            while (resultSet.next()) {
                Sampah sampah = resultSetToSampah(resultSet);
                list.add(sampah);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public int updateViewCount(int sampahId) {
        int result = -1;

        try (Connection connection = MySqlConnection.getInstance().getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_VIEW_QUERY)) {

            statement.setInt(1, sampahId);
            result = statement.executeUpdate();

            System.out.println("Update view count for sampah ID " + sampahId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public Sampah getTopSampahPerDaerah(String emailKurir) {
        Sampah topSampah = null;

        try (Connection connection = MySqlConnection.getInstance().getConnection(); PreparedStatement statement = connection.prepareStatement(SELECT_TOP_PER_DAERAH_QUERY)) {

            statement.setString(1, emailKurir);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                topSampah = resultSetToSampah(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return topSampah;
    }

    public Sampah getTopSampahPerKategori(String kategori) {
        Sampah topSampah = null;

        try (Connection connection = MySqlConnection.getInstance().getConnection(); PreparedStatement statement = connection.prepareStatement(SELECT_TOP_PER_KATEGORI_QUERY)) {

            statement.setString(1, kategori);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                topSampah = resultSetToSampah(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return topSampah;
    }

    private void setStatementParameters(PreparedStatement statement, Sampah sampah) throws SQLException {
        statement.setString(1, sampah.getName());
        statement.setString(2, sampah.getKategori());
        statement.setString(3, sampah.getAlamatUser());
        statement.setString(4, sampah.getEmailUser());
        statement.setString(5, sampah.getEmailKurir());
    }

    private Sampah resultSetToSampah(ResultSet resultSet) throws SQLException {
        Sampah sampah = new Sampah();
        sampah.setId(resultSet.getLong("id"));
        sampah.setName(resultSet.getString("name_sampah"));
        sampah.setKategori(resultSet.getString("kategori_sampah"));
        sampah.setAlamatUser(resultSet.getString("alamat_user"));
        sampah.setEmailUser(resultSet.getString("email_user"));
        sampah.setEmailKurir(resultSet.getString("email_kurir"));
        sampah.setViewCount(resultSet.getInt("view_sampah"));
        return sampah;
    }
}
