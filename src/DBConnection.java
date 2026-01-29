import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb?useSSL=false&serverTimezone=UTC",
                "root",
                "KARTHIK@1108"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}