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
        insertMaterial(args[0], Double.parseDouble(args[1]));
        //selectMenu();
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

            statement.setString(1, name);

            ResultSet resultset = statement.executeQuery();

            while (resultset.next()) {
                int menuId = resultset.getInt("menu_id");
                String menuName = resultset.getString("menu_name");
                System.out.println(String.format("menuId:%d, menuName:%s", menuId, menuName));
            }
        }
    }

    public static void insertMaterial(String materialName, double cal) throws Exception {
        try (Connection connection = DriverManager.getConnection(
            "jdbc:mysql://mysql/mydatabase?user=root&password=root")) {

            connection.setAutoCommit(false);
            try {

                String sql = "insert into materials(material_name, cal) values (?, ?)";

                PreparedStatement statement = connection.prepareStatement(sql);

                statement.setString(1, materialName);
                statement.setDouble(2, cal);

                int rows = statement.executeUpdate();

                if (cal == 0) {
                    throw new RuntimeException("zero");
                }

                connection.commit();
            }
            catch (Exception e) {
                e.printStackTrace();
                connection.rollback();
            }
        }
    }
}
