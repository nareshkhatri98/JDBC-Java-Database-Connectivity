package GUI;
import  javax.swing.*;
import java.awt.*;

public class GridLayoutEG {

    public GridLayoutEG(){
        JFrame f = new JFrame("Grid layout");
        f.setVisible(true);
        f.setLayout(new GridLayout(1,2));
        f.add(new Button("Ok"));
        f.add(new Button("Cancle"));
        f.setSize(200,300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
 new GridLayoutEG();
    }
}
