package GUI;
import java.sql.*;
import javax.swing.*;

public class formGui {
    JFrame f;
    JLabel labelid, labelusername, labelpassword;
    JTextField textfieldid, textfieldusername;
    JPasswordField passwordfield;
    JButton btninsert, btnupdate, btndelete, btnDisplay;

    public formGui() {
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

        // For Buttons
        btninsert = new JButton("Insert");
        btninsert.setBounds(200, 200, 100, 30);
        btnDisplay = new JButton("Display");
        btnDisplay.setBounds(200, 250, 100, 30);
        btndelete = new JButton("Delete");
        btndelete.setBounds(200, 300, 100, 30);
        btnupdate = new JButton("Update");
        btnupdate.setBounds(200, 350, 100, 30);

        // Add all components to JFrame
        f.add(labelid);
        f.add(textfieldid);
        f.add(labelusername);
        f.add(textfieldusername);
        f.add(labelpassword);
        f.add(passwordfield);
        f.add(btninsert);
        f.add(btnDisplay);
        f.add(btndelete);
        f.add(btnupdate);

        f.setSize(1000, 1000);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Database connection
        try {
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String username = "root";
            String pass = "";
            Connection con = DriverManager.getConnection(url, username, pass);

            // Insert button action listener
            btninsert.addActionListener(e -> {
                try {
                    int id = Integer.parseInt(textfieldid.getText());
                    String name = textfieldusername.getText();
                    String pas = new String(passwordfield.getPassword());
                    // SQL query
                    String SqlQuery = "insert into employee(id, username, password) VALUES(?,?,?)";
                    PreparedStatement pstmt = con.prepareStatement(SqlQuery);
                    pstmt.setInt(1, id);
                    pstmt.setString(2, name);
                    pstmt.setString(3, pas);
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(btninsert, "Data are inserted");
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            });

            // Delete button action listener
            btndelete.addActionListener(e -> {
                try {
                    int id = Integer.parseInt(textfieldid.getText());
                    String SqlDelete = "delete from employee where id=?";
                    PreparedStatement pstmt = con.prepareStatement(SqlDelete);
                    pstmt.setInt(1, id);
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(btndelete, "Data are deleted");
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            });

            // Update button action listener
            btnupdate.addActionListener(e -> {
                try {
                    int id = Integer.parseInt(textfieldid.getText());
                    String name = textfieldusername.getText();
                    String pas = new String(passwordfield.getPassword());
                    String SqlUpdate = "update employee set username=?, password=? where id=?";
                    PreparedStatement pstmt = con.prepareStatement(SqlUpdate);
                    pstmt.setString(1, name);
                    pstmt.setString(2, pas);
                    pstmt.setInt(3, id);
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(btnupdate, "Data are updated");
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            });

            // Display button action listener
            btnDisplay.addActionListener(e -> {
                try {
                    String SqlDisplay = "select * from employee";
                    PreparedStatement pstmt = con.prepareStatement(SqlDisplay);
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString("username");
                        String password = rs.getString("password");
                        System.out.println("ID: " + id + ", Username: " + name + ", Password: " + password);
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            });

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        new formGui();
    }
}
