package Task13;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class SimpleCalculatorWithJFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 500);

        frame.getContentPane().setBackground(Color.decode("#1e1e1e"));

        // Set panel layout to GridBagLayout
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Create a panel to hold the result field
        JPanel panelResultField = new JPanel();
        panelResultField.setLayout(new BorderLayout());

        // Create result text field
        JTextField resultTextField = new JTextField();
        resultTextField.setEditable(false);
        resultTextField.setHorizontalAlignment(JTextField.RIGHT);
        panelResultField.add(resultTextField, BorderLayout.CENTER);

        panelResultField.setBackground(Color.decode("#1e1e1e")); 
        resultTextField.setBackground(Color.decode("#2e2e2e")); 

        Border lineBorder = BorderFactory.createLineBorder(Color.decode("#696969"), 1);
        Border paddingBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        resultTextField.setBorder(BorderFactory.createCompoundBorder(lineBorder, paddingBorder));
        resultTextField.setForeground(Color.decode("#D9D9D9")); 
        resultTextField.setCaretColor(Color.decode("#D9D9D9")); 

        resultTextField.setFont(new Font("Arial", Font.BOLD, 24));

        // Configure constraints for the result panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0; 
        gbc.weighty = 0.25;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1; // Explicitly set gridwidth to 1
        frame.add(panelResultField, gbc);

        // Add clear button (next to result field)
        JButton clearButton = new JButton("C");
        clearButton.setFont(new Font("Arial", Font.BOLD, 18)); 
        clearButton.addActionListener(e -> resultTextField.setText("")); // Clear action
        gbc.gridx = 1; // means it will be next to the result field
        gbc.gridy = 0; 
        gbc.weightx = 0.1; 
        gbc.weighty = 0.1; 
        gbc.fill = GridBagConstraints.BOTH; // Fill to take up its cell space
        gbc.gridwidth = 1; // Explicitly set gridwidth to 1
        frame.add(clearButton, gbc);

        clearButton.setBackground(Color.decode("#3e3e3e")); 
        clearButton.setForeground(Color.decode("#D9D9D9")); 

        // Add empty cell (optional spacer row)
        gbc.gridx = 0;
        gbc.gridy = 1; 
        gbc.weightx = 0.0;
        gbc.weighty = 0.1; 
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 2; // Make the empty cell span both columns
        frame.add(new JLabel(), gbc); 

        // Make panel to hold buttons
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(4, 4, 5, 5));
        panelButtons.setBackground(Color.decode("#1e1e1e")); 

        String[] buttonLabels = {
                "7", "8", "9", "÷",
                "4", "5", "6", "×",
                "1", "2", "3", "-",
                "Exit", "0", "=", "+"
        };

        // Add listeners to the buttons
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(e -> {
                String command = e.getActionCommand();
                String currentText = resultTextField.getText();

                switch (command) {
                    case "Exit":
                        System.exit(0);
                    case "=":
                        resultTextField.setText("= " + currentText);
                        break;
                    default:
                        resultTextField.setText(currentText + command);
                        break;
                }
            });

            // Set default button colors
            button.setBackground(Color.decode("#3e3e3e"));
            button.setForeground(Color.decode("#D9D9D9"));

            // Specifically color the "Exit" button
            if (label.equals("Exit")) {
                button.setBackground(Color.decode("#FF5733")); 
            }

            panelButtons.add(button);
        }

        // Configure constraints for the button panel
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0; 
        gbc.weighty = 1.0; 
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2; 
        frame.add(panelButtons, gbc);

        // Add listeners to the result text field (for Enter key)
        resultTextField.addActionListener(e -> {
            String expression = resultTextField.getText();
            resultTextField.setText("= " + expression);
        });

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        ((JPanel) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }
}