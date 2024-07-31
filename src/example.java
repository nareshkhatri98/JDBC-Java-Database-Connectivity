import javax.swing.*;
import java.awt.*;

public class example extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(300, 50, 100, 100);
        String text = "I am java developer";
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getHeight();
        int x = 300 + (100 - textWidth) / 2;
        int y = 50 + ((100 - textHeight) / 2) + fm.getAscent();
        g2d.setColor(Color.WHITE);
        g2d.drawString(text, x, y);
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
