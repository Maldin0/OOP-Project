import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsernameInput {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/username";
        String username = "root";
        String password = "sunna1972";
        String insertSql = "INSERT INTO username (user) VALUES (?)";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
            pstmt.setString(1, "John");
            pstmt.executeUpdate();
            System.out.println("Data inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting data: " + e.getMessage());
        }
    }
}
