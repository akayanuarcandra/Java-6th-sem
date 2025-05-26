package Task13.materials;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickDemo{
    public static void main(String[] args) {

        JFrame frame = new JFrame("Button Click Example");
        JButton button = new JButton("Click Me!");       
        button.setBounds(150, 100, 100, 40);      
        button.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Clicked!");
            }
        });       
        frame.add(button);
        
        frame.setSize(400, 300);
        frame.setLayout(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
