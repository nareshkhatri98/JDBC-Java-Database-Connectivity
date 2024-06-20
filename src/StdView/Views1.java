package StdView;
import javax.swing.*;


public class Views1 {
    JFrame f;
    JLabel l1,l2,l3;
    JTextField t1,t2,t3;
    
    JButton btn;
public Views1()
{
    JFrame f  = new JFrame("Insert the data");
    l1 = new JLabel("ID:");
    l1.setBounds(50,50,100,30);
    t1 = new JTextField();
    t1.setBounds(200,150,100,30);

    f.add(l1);
    f.add(t1);

    f.setLayout(null);
    f.setVisible(true);
    f.setSize(1000,1000);
}

    public static void main(String[] args) {
  new Views1();
    }
}
