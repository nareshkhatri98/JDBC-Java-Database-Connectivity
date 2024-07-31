package GUI;
import  javax.swing.*;
import java.awt.*;

public class FlowLayoutEG {
    public FlowLayoutEG()
    {
        JFrame f = new JFrame("flowlayout");
        f.setSize(400,300);
        f.setLayout(new FlowLayout());
        f.add(new Button("OK"));
        f.add(new Button("Cancle"));
        f.add(new Button("NAresh"));
        f.setVisible(true);

//
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
      new FlowLayoutEG();
    }
}
