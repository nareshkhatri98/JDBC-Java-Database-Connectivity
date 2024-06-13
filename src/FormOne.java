import javax.swing.*;

public class FormOne {
    JFrame f;
    JLabel labelid, labelusername, labelpassword;
    JTextField textfieldid, textfieldusername;
    JPasswordField passwordfield;
    JButton btninsert;

    FormOne() {
        f = new JFrame("Login form");

        labelid = new JLabel("ID:");
        labelid.setBounds(50, 50, 100, 30);
        textfieldid = new JTextField();
        textfieldid.setBounds(200, 50, 100, 30);

        labelusername = new JLabel("Username:");
        labelusername.setBounds(50, 100, 100, 30);
        textfieldusername = new JTextField();
        textfieldusername.setBounds(200, 100, 100, 30);

        labelpassword = new JLabel("Password:");
        labelpassword.setBounds(50, 150, 100, 30);
        passwordfield = new JPasswordField();
        passwordfield.setBounds(200, 150, 100, 30);

        btninsert = new JButton("Login");
        btninsert.setBounds(150, 200, 100, 30);

        f.add(labelid);
        f.add(textfieldid);
        f.add(labelusername);
        f.add(textfieldusername);
        f.add(labelpassword);
        f.add(passwordfield);
        f.add(btninsert);

        btninsert.addActionListener(e-> {

            int id = Integer.parseInt(textfieldid.getText());
            String  username =  textfieldusername.getText();
            String pss = passwordfield.getText();

            System.out.println("ID: "+id);
            System.out.println("Username: " +username);
            System.out.println("Password: " +pss);
            

        });

        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new FormOne();
    }
}
