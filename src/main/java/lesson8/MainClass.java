package lesson8;

import java.sql.*;

public class MainClass {
    private static Connection connection;
    private static Statement stmt;

    public static void main(String[] args) {
        connect();
        clearTablePogoda();
        createTablePogoda();
        fillTablePogoda();
        showPogoda();
        disconnect();
    }
    public static void showPogoda() {
        System.out.println("showPogoda");
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM pogoda;");
            while (rs.next()) {
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+
                        rs.getInt(3)+" "+rs.getString(4)+" "+rs.getString(5));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

       public static void clearTablePogoda(){
        try {
            stmt.executeUpdate("DELETE FROM `pogoda`;");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void createTablePogoda(){
        try {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS `pogoda` (`id` INT(5) NOT NULL AUTO_INCREMENT, `city` VARCHAR(15), `localDate` VARCHAR(4), `weatherText` VARCHAR(40),float(5) 'temperature', PRIMARY KEY (`id`));");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void fillTablePogoda(){
        String[] pogodalist = {"Vladimir 22.02.2022 weatherText, 22"};
                String[] items;
        try {
            connection.setAutoCommit(false);
            for (String str: pogodalist) {
                items = str.split(" ");
                stmt.executeUpdate("INSERT INTO `pogoda` (`city`, `localDate`, `weatherText`, 'temperature') VALUES ('"+
                        items[0] + "',"+items[1]+",'"+items[2]+""+items[3]+"');");

            }
            connection.setAutoCommit(true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
}

        public static void connect() {
        // opening database connection to MySQL server
        try {
            // Строка ?serverTimezone=Europe/Moscow нужна для устранения ошибки TimeZone
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqltest?serverTimezone=Europe/Moscow",
                    "root", "root");
            stmt = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to connect to database");
        }
    }

    public static void disconnect() {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}