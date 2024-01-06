package dao;

import db.MySqlConnection;
import app.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private static final String INSERT_QUERY = "INSERT INTO users(name, email_user, password, telp, alamat, point, is_kurir, is_admin) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE users SET name = ?, email = ?, password = ?, telp = ?, alamat = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM users WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM users";
    private static final String SELECT_BY_COLUMN_QUERY = "SELECT * FROM users WHERE %s = '%s'";

    public int insert(User user) {
        int result = -1;

        try (Connection connection = MySqlConnection.getInstance().getConnection(); PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {

            if (connection != null) {
                System.out.println("Insert Method connected to the database!");
            }

            setStatementParameters(statement, user);
            statement.setBoolean(7, user.getUserIsKurir()); // is_kurir
            statement.setBoolean(8, user.getUserIsAdmin()); // is_admin
            result = statement.executeUpdate();

            System.out.println("Insert data: " + user.getUserId() + " " + user.getUserName() + " "
                    + user.getUserTelp() + " " + user.getUserAlamat() + " " + user.getUserPassword() + " "
                    + user.getUserAlamat() + " " + user.getUserPoint() + " " + user.getUserIsKurir() + " "
                    + user.getUserIsAdmin());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public int update(User user) {
        int result = -1;

        try (Connection connection = MySqlConnection.getInstance().getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {

            setStatementParameters(statement, user);
            // Tidak memperbarui kolom is_admin
            statement.setString(5, user.getUserId()); // id
            result = statement.executeUpdate();

            System.out.println("Insert data: " + user.getUserId() + " " + user.getUserName() + " "
                    + user.getUserTelp() + " " + user.getUserAlamat() + " " + user.getUserPassword() + " "
                    + user.getUserAlamat() + " " + user.getUserPoint() + " " + user.getUserIsKurir() + " "
                    + user.getUserIsAdmin());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public int delete(User user) {
        int result = -1;

        try (Connection connection = MySqlConnection.getInstance().getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {

            // Tidak menghapus berdasarkan kolom is_admin
            statement.setString(1, user.getUserId()); // id
            result = statement.executeUpdate();

            System.out.println("Insert data: " + user.getUserId() + " " + user.getUserName() + " "
                    + user.getUserTelp() + " " + user.getUserAlamat() + " " + user.getUserPassword() + " "
                    + user.getUserAlamat() + " " + user.getUserPoint() + " " + user.getUserIsKurir() + " "
                    + user.getUserIsAdmin());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();

        try (Connection connection = MySqlConnection.getInstance().getConnection(); Statement statement
                = connection.createStatement(); ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUERY)) {

            while (resultSet.next()) {
                User user = resultSetToUser(resultSet);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public User select(String column, String value) {
        User user = new User();

        String selectByColumnQuery = String.format(SELECT_BY_COLUMN_QUERY, column, value);

        try (Connection connection = MySqlConnection.getInstance().getConnection(); Statement statement
                = connection.createStatement(); ResultSet resultSet = statement.executeQuery(selectByColumnQuery)) {

            while (resultSet.next()) {
                user = resultSetToUser(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    private void setStatementParameters(PreparedStatement statement, User user) throws SQLException {
//        statement.setString(1, user.getUserId());
        statement.setString(1, user.getUserName());
        statement.setString(2, user.getUserEmail());
        statement.setString(3, user.getUserPassword());
        statement.setString(4, user.getUserTelp());
        statement.setString(5, user.getUserAlamat());
        statement.setInt(6, user.getUserPoint());
        statement.setBoolean(7, user.getUserIsKurir());
        statement.setBoolean(8, user.getUserIsAdmin());
    }

    private User resultSetToUser(ResultSet resultSet) throws SQLException {
        User user = new User();
//        user.setUserId(resultSet.getString("id"));
        user.setUserName(resultSet.getString("name"));
        user.setUserEmail(resultSet.getString("email_user"));
        user.setUserPassword(resultSet.getString("password"));
        user.setUserTelp(resultSet.getString("telp"));
        user.setUserAlamat(resultSet.getString("alamat"));
        user.setUserPoint(resultSet.getInt("point"));
        user.setIsKurir(resultSet.getBoolean("is_kurir"));
        user.setIsAdmin(resultSet.getBoolean("is_admin"));
        return user;
    }
}
