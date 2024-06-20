package StdView;
import stdContoller.Controller;

import javax.swing.*;

public class View {
    JFrame f;
    JLabel labelid, labelusername, labelpassword;
    JTextField textfieldid, textfieldusername;
    JPasswordField passwordfield;
    JButton btninsert;


    public  View(){
       Controller cu =new Controller();
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

        // For Button insert button.
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

        btninsert.addActionListener(e->{
            int id = Integer.parseInt(textfieldid.getText());
            String username = textfieldusername.getText();
            String password = passwordfield.getText();
            cu.addUser(id,username,password);
         JOptionPane.showMessageDialog(btninsert,"Inserted Sucessfully");
        });

        f.setSize(1000, 1000);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new View();
    }
}
