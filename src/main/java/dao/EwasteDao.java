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

public class EwasteDao {

    private MySqlConnection mySqlConnection;

    private static final String GET_TOTAL_ORDERED_WASTE_QUERY = "SELECT SUM(total_sampah) FROM orders";
    private static final String GET_TOTAL_REGISTERED_USERS_QUERY = "SELECT COUNT(*) FROM users";
    private static final String GET_TOTAL_REGISTERED_COURIERS_QUERY = "SELECT COUNT(*) FROM kurir";
    private static final String GET_TOP_10_WASTE_CATEGORIES_QUERY = "SELECT kategori_sampah, COUNT(*) FROM orders GROUP BY kategori_sampah ORDER BY COUNT(*) DESC LIMIT 10";
    private static final String GET_TOP_10_USERS_WITH_MOST_POINTS_QUERY = "SELECT name, point FROM users ORDER BY point DESC LIMIT 10";
    private static final String GET_TOP_10_REGIONS_QUERY = "SELECT daerah, COUNT(*) FROM orders GROUP BY daerah ORDER BY COUNT(*) DESC LIMIT 10";
    private static final String GET_ORDERED_WASTE_CATEGORIES_QUERY = "SELECT kategori_sampah, COUNT(*) FROM orders GROUP BY kategori_sampah";
    private static final String GET_ALL_ORDERS_QUERY = "SELECT * FROM orders";

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

    // Method to get all order details based on username, region, total waste, and courier
    public List<Object[]> getAllOrders() {
        List<Object[]> allOrders = new ArrayList<>();

        try (Connection connection = mySqlConnection.getConnection(); Statement statement
                = connection.createStatement(); ResultSet resultSet = statement.executeQuery(GET_ALL_ORDERS_QUERY)) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                allOrders.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allOrders;
    }
}
