package stdUntil;
import java.sql.*;

import stdEcp.Encp;

import static java.sql.DriverManager.getConnection;

public class Util {
    private Connection connection;
    private Statement stmt;

    public Util() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Create the connection
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String username = "root";
            String pass = "";
            this.connection = getConnection(url, username, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUsertoDB(Encp ep) {
        try {
            String insertQuery = "INSERT INTO employee(id, username, password) VALUES(?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery);
            stmt.setInt(1, ep.getId());
            stmt.setString(2, ep.getUsername());
            stmt.setString(3, ep.getPassword());

            // Execute the query
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
