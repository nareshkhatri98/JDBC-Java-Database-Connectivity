import  javax.swing.*;

public class ExampleofJtextField {
    public ExampleofJtextField(){
        JTextField t1;
        JFrame f = new JFrame("JTextFiled Example ");
        t1 = new JTextField();
        t1.setBounds(50, 100, 100, 30);
        f.add(t1);
        f.setSize(400, 300);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new ExampleofJtextField();
    }
}
