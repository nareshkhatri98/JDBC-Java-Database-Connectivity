
import java.sql.*;
public class SetResult {
    public static void main(String[] args)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Create the connection
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String username = "root";
            String pass = "";
            Connection con = DriverManager.getConnection(url, username, pass);

            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs =  stmt.executeQuery("select *from demo");
            rs.absolute(9);
            rs.updateString(3, "Surkhet");
            rs.updateRow();

            System.out.println(rs.getInt(1)+ " " + rs.getString(2)+ " " + rs.getString(3) );
            con.close();

        }catch (Exception e)

        {
            System.out.println(e);

        }

    }
}
