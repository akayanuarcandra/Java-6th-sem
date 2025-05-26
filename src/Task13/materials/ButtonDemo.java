package Task13.materials;

import javax.swing.*;
public class ButtonDemo {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Button Example");
        frame.setSize(400, 300);
        frame.setLayout(null); // absolute positioning
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Click Me!");
        button.setBounds(150, 100, 100, 40); //setBounds(x, y, width, height)
        frame.add(button);       
        frame.setVisible(true);
    }
}