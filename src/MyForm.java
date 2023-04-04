import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MyForm extends JFrame implements ActionListener {
    private JTextField firstNameField, lastNameField, birthDateField, emailField;
    private JComboBox<String> sexField;
    private JButton submitButton;
    private JTextArea displayArea;
    private ArrayList<String> submissions;

    public MyForm() {
        // Set up the UI components
        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        birthDateField = new JTextField(20);
        emailField = new JTextField(20);
        sexField = new JComboBox<>(new String[] { "Male", "Female" });
        submitButton = new JButton("Submit");
        displayArea = new JTextArea(10, 30);
        submissions = new ArrayList<>();

        // Add the components to the UI
        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(new JLabel("First Name:"));
        panel.add(firstNameField);
        panel.add(new JLabel("Last Name:"));
        panel.add(lastNameField);
        panel.add(new JLabel("Birth Date:"));
        panel.add(birthDateField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Sex:"));
        panel.add(sexField);
        panel.add(submitButton);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        panel.add(scrollPane);

        // Set up the window
        setContentPane(panel);
        pack();
        setVisible(true);

        // Add event listener for the submit button
        submitButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // Check that all required fields are filled in
        if (firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty()
                || birthDateField.getText().isEmpty() || emailField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all required fields.");
            return;
        }

        // Get the values from the form
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String birthDate = birthDateField.getText();
        String email = emailField.getText();
        String sex = (String) sexField.getSelectedItem();

        // Create the submission text and add it to the list of submissions
        String submission = String.format("%s %s (%s)\nBorn on %s\n%s\n", firstName, lastName, sex, birthDate, email);
        submissions.add(submission);

        // Update the display area with the updated submissions
        displayArea.setText(String.join("\n\n", submissions));

        // Clear the form fields for the next submission
        firstNameField.setText("");
        lastNameField.setText("");
        birthDateField.setText("");
        emailField.setText("");
    }

    public static void main(String[] args) {
        new MyForm();
    }
}