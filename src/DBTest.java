import java.sql.Connection;
import java.sql.DriverManager;

public class DBTest {

    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb?useSSL=false&serverTimezone=UTC",
                "root",
                "KARTHIK@1108"
            );

            System.out.println("✅ MySQL connected successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}