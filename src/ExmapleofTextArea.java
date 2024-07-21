import  javax.swing.*;
public class ExmapleofTextArea {
    public  ExmapleofTextArea(){
        JFrame f = new JFrame("Example of  JTextArea");
        JTextArea A;
        A = new JTextArea("Enter the text");
        A.setBounds(50, 100, 100 ,30);
        f.add(A);
        f.setSize(400,300);
        f.setVisible(true);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        new ExmapleofTextArea();
    }
}
