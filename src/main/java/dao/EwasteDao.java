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
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class EwasteDao {

    private MySqlConnection mySqlConnection;

    private static final String GET_TOTAL_ORDERED_WASTE_QUERY = "SELECT SUM(total_sampah) FROM orders";
    private static final String GET_TOTAL_REGISTERED_USERS_QUERY = "SELECT COUNT(*) FROM users";
    private static final String GET_TOTAL_REGISTERED_COURIERS_QUERY = "SELECT COUNT(*) FROM kurir";
    private static final String GET_TOP_10_WASTE_CATEGORIES_QUERY = "SELECT kategori_sampah, COUNT(*) FROM orders GROUP BY kategori_sampah ORDER BY COUNT(*) DESC LIMIT 10";
    private static final String GET_TOP_10_USERS_WITH_MOST_POINTS_QUERY = "SELECT name, point FROM users ORDER BY point DESC LIMIT 10";
    private static final String GET_TOP_10_REGIONS_QUERY = "SELECT daerah, COUNT(*) FROM orders GROUP BY daerah ORDER BY COUNT(*) DESC LIMIT 10";
    private static final String GET_ORDERED_WASTE_CATEGORIES_QUERY = "SELECT kategori_sampah, COUNT(*) FROM orders GROUP BY kategori_sampah ORDER BY COUNT(*)";

    public EwasteDao() {
        this.mySqlConnection = MySqlConnection.getInstance();
    }

    // Method to get the total amount of waste ordered
    public int getTotalOrderedWaste() {
        int totalWaste = 0;

        try (Connection connection = mySqlConnection.getConnection(); Statement statement
                = connection.createStatement(); ResultSet resultSet = statement.executeQuery(GET_TOTAL_ORDERED_WASTE_QUERY)) {

            if (resultSet.next()) {
                totalWaste = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalWaste;
    }

    // Method to get the total number of registered users
    public int getTotalRegisteredUsers() {
        int totalUsers = 0;

        try (Connection connection = mySqlConnection.getConnection(); Statement statement
                = connection.createStatement(); ResultSet resultSet = statement.executeQuery(GET_TOTAL_REGISTERED_USERS_QUERY)) {

            if (resultSet.next()) {
                totalUsers = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalUsers;
    }

    // Method to get the total number of registered couriers
    public int getTotalRegisteredCouriers() {
        int totalCouriers = 0;

        try (Connection connection = mySqlConnection.getConnection(); Statement statement
                = connection.createStatement(); ResultSet resultSet = statement.executeQuery(GET_TOTAL_REGISTERED_COURIERS_QUERY)) {

            if (resultSet.next()) {
                totalCouriers = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalCouriers;
    }

    // Method to get the top 10 waste categories ordered
    public List<Object[]> getTop10WasteCategories() {
        List<Object[]> topCategories = new ArrayList<>();

        try (Connection connection = mySqlConnection.getConnection(); Statement statement
                = connection.createStatement(); ResultSet resultSet = statement.executeQuery(GET_TOP_10_WASTE_CATEGORIES_QUERY)) {

            while (resultSet.next()) {
                String category = resultSet.getString(1);
                int count = resultSet.getInt(2);
                topCategories.add(new Object[]{category, count});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return topCategories;
    }

    // Method to get the top 10 users with the most points
    public List<Object[]> getTop10UsersWithMostPoints() {
        List<Object[]> topUsers = new ArrayList<>();

        try (Connection connection = mySqlConnection.getConnection(); Statement statement
                = connection.createStatement(); ResultSet resultSet = statement.executeQuery(GET_TOP_10_USERS_WITH_MOST_POINTS_QUERY)) {

            while (resultSet.next()) {
                String userName = resultSet.getString(1);
                int userPoints = resultSet.getInt(2);
                topUsers.add(new Object[]{userName, userPoints});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return topUsers;
    }

    // Method to get the top 10 regions mentioned in orders
    public List<Object[]> getTop10Regions() {
        List<Object[]> topRegions = new ArrayList<>();

        try (Connection connection = mySqlConnection.getConnection(); Statement statement
                = connection.createStatement(); ResultSet resultSet = statement.executeQuery(GET_TOP_10_REGIONS_QUERY)) {

            while (resultSet.next()) {
                String region = resultSet.getString(1);
                int count = resultSet.getInt(2);
                topRegions.add(new Object[]{region, count});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return topRegions;
    }

    // Method to get the list of waste categories that have been ordered
    public List<Object[]> getOrderedWasteCategories() {
        List<Object[]> orderedCategories = new ArrayList<>();

        try (Connection connection = mySqlConnection.getConnection(); Statement statement
                = connection.createStatement(); ResultSet resultSet = statement.executeQuery(GET_ORDERED_WASTE_CATEGORIES_QUERY)) {

            while (resultSet.next()) {
                String category = resultSet.getString(1);
                int count = resultSet.getInt(2);
                orderedCategories.add(new Object[]{category, count});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderedCategories;
    }

    // Helper method to construct the SQL query
    private String getOrdersDataQuery() {
        return "SELECT "
                + "u.name AS username, "
                + "o.daerah, "
                + "o.total_sampah, "
                + "u_kurir.name AS kurir_name "
                + "FROM orders o "
                + "JOIN users u ON o.email_user = u.email_user "
                + "JOIN kurir k ON o.email_kurir = k.email_kurir "
                + "JOIN users u_kurir ON k.email_kurir = u_kurir.email_user";
    }

    public List<Object[]> getOrdersDataAll() {
        List<Object[]> ordersData = new ArrayList<>();

        try (Connection connection = mySqlConnection.getConnection(); Statement statement
                = connection.createStatement(); ResultSet resultSet = statement.executeQuery(getOrdersDataQuery())) {

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String daerah = resultSet.getString("daerah");
                int totalSampah = resultSet.getInt("total_sampah");
                String kurirName = resultSet.getString("kurir_name");

                ordersData.add(new Object[]{username, daerah, totalSampah, kurirName});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ordersData;
    }

    public static DefaultTableModel getAllUsers(Connection connection) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Email User");
        model.addColumn("Password");
        model.addColumn("Telp");
        model.addColumn("Alamat");
        model.addColumn("Point");
        model.addColumn("Is Kurir");
        model.addColumn("Is Admin");

        String query = "SELECT * FROM users";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Vector row = new Vector();
                row.add(resultSet.getString("name"));
                row.add(resultSet.getString("email_user"));
                row.add(resultSet.getString("password"));
                row.add(resultSet.getString("telp"));
                row.add(resultSet.getString("alamat"));
                row.add(resultSet.getInt("point"));
                row.add(resultSet.getBoolean("is_kurir"));
                row.add(resultSet.getBoolean("is_admin"));

                model.addRow(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }

    private static final String GET_ALL_USERS = "SELECT Name, email_user, telp, alamat, Point, is_kurir FROM users";

    public List<Object[]> getAllUsers() {
        List<Object[]> allUsers = new ArrayList<>();

        try (Connection connection = mySqlConnection.getConnection(); Statement statement
                = connection.createStatement(); ResultSet resultSet = statement.executeQuery(GET_ALL_USERS)) {

            while (resultSet.next()) {
                String username = resultSet.getString("Name");
                String emailUser = resultSet.getString("email_user");
                String telp = resultSet.getString("telp");
                String daerah = resultSet.getString("Alamat");
                int point = resultSet.getInt("Point");
                Boolean isKurir = resultSet.getBoolean("is_kurir");

                // Konversi boolean ke string 'ya' atau 'tidak'
                String isKurirString = (isKurir != null && isKurir) ? "ya" : "tidak";

                allUsers.add(new Object[]{username, emailUser, telp, daerah, point, isKurirString});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allUsers;
    }
}
