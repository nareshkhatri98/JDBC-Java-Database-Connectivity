import javax.swing.*;
import java.sql.*;

public class FormOne {
    JFrame f;
    JLabel labelid, labelusername, labelpassword;
    JTextField textfieldid, textfieldusername;
    JPasswordField passwordfield;
    JButton btninsert;

    FormOne() {
        f = new JFrame("Login Form");

        // For ID
        labelid = new JLabel("ID:");
        labelid.setBounds(50, 50, 100, 30);
        textfieldid = new JTextField();
        textfieldid.setBounds(200, 50, 150, 30);

        // For Username
        labelusername = new JLabel("Username:");
        labelusername.setBounds(50, 100, 100, 30);
        textfieldusername = new JTextField();
        textfieldusername.setBounds(200, 100, 150, 30);

        // For Password
        labelpassword = new JLabel("Password:");
        labelpassword.setBounds(50, 150, 100, 30);
        passwordfield = new JPasswordField();
        passwordfield.setBounds(200, 150, 150, 30);

        // For Button
        btninsert = new JButton("Insert");
        btninsert.setBounds(200, 200, 100, 30);

        // Add all components to JFrame
        f.add(labelid);
        f.add(textfieldid);
        f.add(labelusername);
        f.add(textfieldusername);
        f.add(labelpassword);
        f.add(passwordfield);
        f.add(btninsert);

        // Database Connection
        try {
            // Step 1: Register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Create the connection
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String username = "root";
            String pass = "";
            Connection con = DriverManager.getConnection(url, username, pass);

            // Handle the event for the button btninsert
            btninsert.addActionListener(e -> {
                try {
                    int id = Integer.parseInt(textfieldid.getText());
                    String name = textfieldusername.getText();
                    String Password = new String(passwordfield.getPassword());

                    // Insert Query
                    String insertQuery = "INSERT INTO employee(id, username, password) VALUES(?,?,?)";
                    PreparedStatement pstmt = con.prepareStatement(insertQuery);
                    pstmt.setInt(1, id);
                    pstmt.setString(2, name);
                    pstmt.setString(3, Password);

                    // Execute the prepared statement
                    int rowsInserted = pstmt.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("A new employee was inserted successfully!");
                    }

                } catch (Exception ex) {
                    System.out.println(e);
                }
            });

        } catch (Exception e) {
            System.out.println(e);
        }

        // Set the size of the frame
        f.setSize(1000, 1000);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new FormOne();
    }
}
