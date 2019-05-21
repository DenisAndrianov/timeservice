package dbmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    public static Connection db = null;
    public DBconnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка загрузки драйвера");
            e.printStackTrace();
        }
        try {
            db = DriverManager.getConnection("jdbc:postgresql://localhost:5432/timeservice","timeuser", "123321");
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к бд");
            e.printStackTrace();
        }
        System.out.println("Успешное подключение к бд");
    }
}
