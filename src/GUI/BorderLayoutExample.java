package GUI;

import java.awt.*;

public class BorderLayoutExample {
    BorderLayoutExample() {
        Frame f = new Frame("Border Layout");
        f.setSize(400, 300); // Increased size for better visibility of buttons
        f.setLayout(new BorderLayout());
        f.setVisible(true);

        f.add(new Button("North"), BorderLayout.NORTH);
        f.add(new Button("South"), BorderLayout.SOUTH);
        f.add(new Button("East"), BorderLayout.EAST);
        f.add(new Button("West"), BorderLayout.WEST);
        f.add(new Button("Center"), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new BorderLayoutExample();
    }
}
