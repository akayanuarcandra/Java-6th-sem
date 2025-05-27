package meWhenBored.minecraft;

import javax.swing.JFrame;

public class SimpleMinecraft {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple 2D Minecraft");
        GamePanel gamePanel = new GamePanel();

        frame.add(gamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack(); // Sizes the frame to the GamePanel's preferred size
        frame.setLocationRelativeTo(null); // Center on screen
        frame.setVisible(true);
    }
}
