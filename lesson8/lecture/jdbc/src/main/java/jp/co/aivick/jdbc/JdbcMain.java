package jp.co.aivick.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcMain
{
    public static void main(String[] args) throws Exception {
        selectMenu();
        //selectMenuByNameDanger(args[0]);
        //selectMenuByNameSafe(args[0]);
    }

    public static void selectMenu() throws SQLException {
        try (Connection connection = DriverManager.getConnection(
            "jdbc:mysql://mysql/mydatabase?user=root&password=root")) {

            Statement statement = connection.createStatement();

            String sql = "select * from menus";

            ResultSet resultset = statement.executeQuery(sql);

            while (resultset.next()) {
                int menuId = resultset.getInt("menu_id");
                String menuName = resultset.getString("menu_name");
                System.out.println(String.format("menuId:%d, menuName:%s", menuId, menuName));
            }
        }
    }

    public static void selectMenuByNameDanger(String name) throws Exception {
        try (Connection connection = DriverManager.getConnection(
            "jdbc:mysql://mysql/mydatabase?user=root&password=root")) {

            Statement statement = connection.createStatement();

            String sql = "select * from menus where menu_name = '" + name + "'";

            System.out.println(sql);

            ResultSet resultset = statement.executeQuery(sql);

            while (resultset.next()) {
                int menuId = resultset.getInt("menu_id");
                String menuName = resultset.getString("menu_name");
                System.out.println(String.format("menuId:%d, menuName:%s", menuId, menuName));
            }
        }
    }

    public static void selectMenuByNameSafe(String name) throws Exception {
        try (Connection connection = DriverManager.getConnection(
            "jdbc:mysql://mysql/mydatabase?user=root&password=root")) {

            String sql = "select * from menus where menu_name = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1,  name);

            ResultSet resultset = statement.executeQuery();

            while (resultset.next()) {
                int menuId = resultset.getInt("menu_id");
                String menuName = resultset.getString("menu_name");
                System.out.println(String.format("menuId:%d, menuName:%s", menuId, menuName));
            }
        }
    }

    public static void insert() throws Exception {
        Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost/javalesson?user=root&password=pass");
        connection.setAutoCommit(false);

        String sql = "insert into person(name, age) values (?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, "nishi");
        statement.setInt(2, 20);

        int rows = statement.executeUpdate();

        connection.rollback();
        statement.close();
        connection.close();
    }
}
