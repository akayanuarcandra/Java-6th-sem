package Task13;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginWithGUI {
    public static void main(String[] args) {
        // create a new jframe
        JFrame frame = new JFrame("Login Form");

        // set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set the size of the frame
        frame.setSize(400, 300);

        // create a panel to hold the components
        JPanel panel = new javax.swing.JPanel();

        // set panel color
        panel.setBackground(Color.decode("#1e1e1e"));

        // set caret color
        UIManager.put("TextField.caretForeground", Color.decode("#D9D9D9"));
        UIManager.put("PasswordField.caretForeground", Color.decode("#D9D9D9"));

        // create a label for the username
        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(Color.decode("#D9D9D9"));

        // create a text field for the username
        JTextField userText = new JTextField(20);
        userText.setBackground(Color.decode("#2e2e2e"));
        userText.setForeground(Color.decode("#D9D9D9"));     
        userText.setBorder(BorderFactory.createLineBorder(Color.decode("#979797"), 1));

        // create a label for the password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.decode("#D9D9D9"));

        // create a password field for the password
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBackground(Color.decode("#2e2e2e"));
        passwordText.setForeground(Color.decode("#D9D9D9"));
        passwordText.setBorder(BorderFactory.createLineBorder(Color.decode("#979797"), 1));
        
        // create a button for login
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(Color.decode("#2e2e2e"));
        loginButton.setForeground(Color.decode("#D9D9D9"));

        // create a button to exit
        JButton exitButton = new JButton("Exit");
        exitButton.setBackground(Color.decode("#2e2e2e"));
        exitButton.setForeground(Color.decode("#D9D9D9"));

        // add an action listener to the login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());
                
                // login logic
                if (username.equals("admin") && password.equals("password")) {
                    JOptionPane.showMessageDialog(frame, "Login Successful!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Username or Password");
                }
            }
        });

        // add an action listener to the exit button
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // add components to the panel
        panel.add(userLabel);
        panel.add(userText);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(new JLabel()); // empty cell
        panel.add(loginButton);
        panel.add(exitButton);

        // add the panel to the frame
        frame.add(panel);

        // set the frame visibility
        frame.setVisible(true);

        // set the layout manager
        panel.setLayout(new GridLayout(7, 2));

        // grid layout add padding
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

        // set the frame to be resizable
        frame.setResizable(false);

        // center the frame on the screen
        frame.setLocationRelativeTo(null);
    }
}
