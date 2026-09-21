import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static String URL = "jdbc:mariadb://localhost:3306/shop";
    private static String USER = "root";
    private static String PASSWORD = "Pinsolle40!";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }
}
