import javax.swing.*;
import java.awt.*;

public class example extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.fillRect(50, 50, 100, 50);
        g2d.setColor(Color.GREEN);
        g2d.fillOval(300, 50, 100, 100);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("2D Object Display");
        example obj = new example();
        f.add(obj);
        f.setSize(500, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
