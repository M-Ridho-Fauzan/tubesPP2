/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author ridho
 */
import app.model.Kurir;
import db.MySqlConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KurirDao {

    private static final String INSERT_QUERY = "INSERT INTO kurir(email_kurir) VALUES (?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM kurir";
    private static final String UPDATE_POINT_QUERY = "UPDATE kurir SET point_kurir = point_kurir + 1 WHERE id = ?";
    private static final String SELECT_TOP_KURIR_QUERY = "SELECT * FROM kurir ORDER BY point_kurir DESC LIMIT 1";

    public int insert(Kurir kurir) {
        int result = -1;

        try (Connection connection = MySqlConnection.getInstance().getConnection(); PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {

            statement.setString(1, kurir.getEmail());
            result = statement.executeUpdate();

            System.out.println("Insert data: " + kurir.getId() + " " + kurir.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<Kurir> findAll() {
        List<Kurir> list = new ArrayList<>();

        try (Connection connection = MySqlConnection.getInstance().getConnection(); Statement statement
                = connection.createStatement(); ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUERY)) {

            while (resultSet.next()) {
                Kurir kurir = resultSetToKurir(resultSet);
                list.add(kurir);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public int updatePoint(int kurirId) {
        int result = -1;

        try (Connection connection = MySqlConnection.getInstance().getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_POINT_QUERY)) {

            statement.setInt(1, kurirId);
            result = statement.executeUpdate();

            System.out.println("Update point for kurir ID " + kurirId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public Kurir getTopKurir() {
        Kurir topKurir = null;

        try (Connection connection = MySqlConnection.getInstance().getConnection(); PreparedStatement statement = connection.prepareStatement(SELECT_TOP_KURIR_QUERY)) {

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                topKurir = resultSetToKurir(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return topKurir;
    }

    private Kurir resultSetToKurir(ResultSet resultSet) throws SQLException {
        Kurir kurir = new Kurir();
        kurir.setId(resultSet.getLong("id"));
        kurir.setEmail(resultSet.getString("email_kurir"));
        kurir.setPoint(resultSet.getInt("point_kurir"));
        return kurir;
    }
}
