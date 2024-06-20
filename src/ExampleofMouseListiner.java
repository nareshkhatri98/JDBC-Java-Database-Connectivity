/*using Mouse Adapter.
Wap using swing /awt to find the addition of two number when the button is pressed and
calculated the difference of two number when the button is released from input 1, input 2 and result */



import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ExampleofMouseListiner implements MouseListener {
    JFrame f;
    JLabel Input1, Input2, Result;
    JTextField Input1field, Input2field, Resultfield;
    JButton Calculate;

    public ExampleofMouseListiner() {
        f = new JFrame("Calculation ");
        Input1 = new JLabel("Input1:");
        Input1.setBounds(50, 50, 100, 30);
        Input1field = new JTextField();
        Input1field.setBounds(200, 50, 150, 30);

        Input2 = new JLabel("Input2:");
        Input2.setBounds(50, 100, 100, 30);
        Input2field = new JTextField();
        Input2field.setBounds(200, 100, 150, 30);

        Result = new JLabel("Result:");
        Result.setBounds(50, 150, 100, 30);
        Resultfield = new JTextField();
        Resultfield.setBounds(200, 150, 150, 30);
        Resultfield.setEditable(false);

        Calculate = new JButton("Calculate");
        Calculate.setBounds(200, 200, 100, 30);

        f.add(Input1);
        f.add(Input1field);
        f.add(Input2);
        f.add(Input2field);
        f.add(Calculate);
        f.add(Result);
        f.add(Resultfield);
        Calculate.addMouseListener(this);


        f.setSize(400, 300);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    @Override
    public void mouseClicked (MouseEvent e){
        int number1 = Integer.parseInt(Input1field.getText());
        int number2 = Integer.parseInt(Input2field.getText());
        int sum = number1 + number2;

        Resultfield.setText(Integer.toString(sum));
    }


    @Override
    public void mouseEntered (MouseEvent e){
    }

    @Override
    public void mouseExited (MouseEvent e){
        int number1 = Integer.parseInt(Input1field.getText());
        int number2 = Integer.parseInt(Input2field.getText());
        int diff = number1 - number2;
        Resultfield.setText(Integer.toString(diff));
    }

    @Override
    public void mouseReleased (MouseEvent e){
    }

    @Override
    public void mousePressed (MouseEvent e){
    }


    public static void main(String[] args) {
        new ExampleofMouseListiner();
    }
}


