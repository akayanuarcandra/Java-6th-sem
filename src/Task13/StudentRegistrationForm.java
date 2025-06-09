package Task13;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.*;

public class StudentRegistrationForm extends JFrame implements ActionListener {

    JTextField tfStudentId, tfName, tfBirthday, tfEmail, tfPhone;
    JPasswordField pfPassword, pfConfirmPassword;
    JRadioButton rbMale, rbFemale;
    ButtonGroup genderGroup;
    JComboBox<String> cbCountry;
    JCheckBox chbReading, chbSports, chbMusic, chbCoding;
    JTextArea taProfile;
    JButton btnSubmit, btnQuit;

    JLabel lblStudentId, lblName, lblPassword, lblConfirmPassword, lblGender,
           lblBirthday, lblEmail, lblPhone, lblCountry, lblHobbies, lblProfile;

    public StudentRegistrationForm() {
        setTitle("Student Club Registration");
        setSize(700, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout()); // Main layout

        // --- Input Panel (GridLayout) ---
        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 10, 10)); // rows, 2 cols, hgap, vgap
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding

        // Student ID
        lblStudentId = new JLabel("Student ID:");
        tfStudentId = new JTextField(20);
        inputPanel.add(lblStudentId);
        inputPanel.add(tfStudentId);

        // Name
        lblName = new JLabel("Name:");
        tfName = new JTextField(20);
        inputPanel.add(lblName);
        inputPanel.add(tfName);

        // Password
        lblPassword = new JLabel("Password (min. 9 chars):");
        pfPassword = new JPasswordField(20);
        inputPanel.add(lblPassword);
        inputPanel.add(pfPassword);

        // Confirm Password
        lblConfirmPassword = new JLabel("Confirm Password:");
        pfConfirmPassword = new JPasswordField(20);
        inputPanel.add(lblConfirmPassword);
        inputPanel.add(pfConfirmPassword);

        // Gender
        lblGender = new JLabel("Gender:");
        rbMale = new JRadioButton("Male");
        rbFemale = new JRadioButton("Female");
        rbMale.setActionCommand("Male"); // Important for retrieving value
        rbFemale.setActionCommand("Female");
        genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPanel.add(rbMale);
        genderPanel.add(rbFemale);
        inputPanel.add(lblGender);
        inputPanel.add(genderPanel);

        // Birthday
        lblBirthday = new JLabel("Birthday (YYYY-MM-DD):");
        tfBirthday = new JTextField(20);
        inputPanel.add(lblBirthday);
        inputPanel.add(tfBirthday);

        // Email
        lblEmail = new JLabel("Email:");
        tfEmail = new JTextField(20);
        inputPanel.add(lblEmail);
        inputPanel.add(tfEmail);

        // Phone
        lblPhone = new JLabel("Phone Number:");
        tfPhone = new JTextField(20);
        inputPanel.add(lblPhone);
        inputPanel.add(tfPhone);

        // Country
        lblCountry = new JLabel("Country:");
        String[] countries = {"--Select Country--", "USA", "Canada", "UK", "Germany", "India", "China", "Indonesia", "Other"};
        cbCountry = new JComboBox<>(countries);
        inputPanel.add(lblCountry);
        inputPanel.add(cbCountry);

        // Hobbies
        lblHobbies = new JLabel("Hobbies:");
        chbReading = new JCheckBox("Reading");
        chbSports = new JCheckBox("Sports");
        chbMusic = new JCheckBox("Music");
        chbCoding = new JCheckBox("Coding");
        JPanel hobbiesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        hobbiesPanel.add(chbReading);
        hobbiesPanel.add(chbSports);
        hobbiesPanel.add(chbMusic);
        hobbiesPanel.add(chbCoding);
        inputPanel.add(lblHobbies);
        inputPanel.add(hobbiesPanel);

        // Personal Profile
        lblProfile = new JLabel("Personal Profile:");
        taProfile = new JTextArea(5, 20);
        JScrollPane profileScrollPane = new JScrollPane(taProfile);
        inputPanel.add(lblProfile);
        inputPanel.add(profileScrollPane);


        // --- Button Panel (FlowLayout) ---
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnSubmit = new JButton("Submit");
        btnQuit = new JButton("Quit");
        btnSubmit.addActionListener(this);
        btnQuit.addActionListener(this);
        buttonPanel.add(btnSubmit);
        buttonPanel.add(btnQuit);

        // Add panels to frame
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            handleSubmit();
        } else if (e.getSource() == btnQuit) {
            System.exit(0);
        }
    }

    private void handleSubmit() {
        // Get data from fields
        String studentId = tfStudentId.getText().trim();
        String name = tfName.getText().trim();
        String password = new String(pfPassword.getPassword());
        String confirmPassword = new String(pfConfirmPassword.getPassword());
        String birthday = tfBirthday.getText().trim();
        String email = tfEmail.getText().trim();
        String phone = tfPhone.getText().trim();
        String country = cbCountry.getSelectedItem() != null ? cbCountry.getSelectedItem().toString() : "";
        String profile = taProfile.getText().trim();

        String gender = "";
        if (genderGroup.getSelection() != null) {
            gender = genderGroup.getSelection().getActionCommand();
        }

        List<String> hobbiesList = new ArrayList<>();
        if (chbReading.isSelected()) hobbiesList.add("Reading");
        if (chbSports.isSelected()) hobbiesList.add("Sports");
        if (chbMusic.isSelected()) hobbiesList.add("Music");
        if (chbCoding.isSelected()) hobbiesList.add("Coding");
        String hobbies = String.join(", ", hobbiesList);
        if (hobbies.isEmpty()) hobbies = "None"; // Or make it mandatory

        // Validation
        if (studentId.isEmpty() || name.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() ||
            gender.isEmpty() || birthday.isEmpty() || email.isEmpty() || phone.isEmpty() ||
            country.equals("--Select Country--") || country.isEmpty() || profile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required (except hobbies can be none).", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (password.length() <= 8) {
            JOptionPane.showMessageDialog(this, "Password length must be greater than 8.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Password and Confirmed Password do not match.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Mobile phone validation (simple: 10-15 digits)
        if (!Pattern.matches("\\d{10,15}", phone)) {
            JOptionPane.showMessageDialog(this, "Invalid phone number format (must be 10-15 digits).", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Birthday validation (YYYY-MM-DD)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false); // Don't allow invalid dates
        try {
            sdf.parse(birthday);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Invalid birthday format (must be YYYY-MM-DD).", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Email validation (simple: contains @ and .)
        if (!Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email)) {
            JOptionPane.showMessageDialog(this, "Invalid email format.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }


        // If all validations pass, display information
        StringBuilder info = new StringBuilder();
        info.append("Registration Successful!\n\n");
        info.append("Student ID: ").append(studentId).append("\n");
        info.append("Name: ").append(name).append("\n");
        info.append("Gender: ").append(gender).append("\n");
        info.append("Birthday: ").append(birthday).append("\n");
        info.append("Email: ").append(email).append("\n");
        info.append("Phone: ").append(phone).append("\n");
        info.append("Country: ").append(country).append("\n");
        info.append("Hobbies: ").append(hobbies).append("\n");
        info.append("Profile: ").append(profile).append("\n");

        JOptionPane.showMessageDialog(this, info.toString(), "Registration Details", JOptionPane.INFORMATION_MESSAGE);

        clearFields();
    }

    private void clearFields() {
        tfStudentId.setText("");
        tfName.setText("");
        pfPassword.setText("");
        pfConfirmPassword.setText("");
        genderGroup.clearSelection();
        tfBirthday.setText("");
        tfEmail.setText("");
        tfPhone.setText("");
        cbCountry.setSelectedIndex(0);
        chbReading.setSelected(false);
        chbSports.setSelected(false);
        chbMusic.setSelected(false);
        chbCoding.setSelected(false);
        taProfile.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentRegistrationForm();
            }
        });
    }
}
