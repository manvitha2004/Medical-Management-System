import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

class Patient {
    String name;
    String address;
    String phoneNumber;

    public Patient(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}

class MedicalManagementSystem extends JFrame implements ActionListener {
    ArrayList<Patient> patients = new ArrayList<>();

    JLabel nameLabel, addressLabel, phoneLabel;
    JTextField nameField, addressField, phoneField;
    JButton addButton, displayButton;

    public MedicalManagementSystem() {
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 20, 80, 20);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(100, 20, 200, 20);
        add(nameField);

        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(20, 50, 80, 20);
        add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(100, 50, 200, 20);
        add(addressField);

        phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(20, 80, 80, 20);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(100, 80, 200, 20);
        add(phoneField);

        addButton = new JButton("Add Patient");
        addButton.setBounds(20, 120, 120, 30);
        addButton.addActionListener(this);
        add(addButton);

        displayButton = new JButton("Display Patients");
        displayButton.setBounds(150, 120, 150, 30);
        displayButton.addActionListener(this);
        add(displayButton);

        setSize(350, 200);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String name = nameField.getText();
            String address = addressField.getText();
            String phone = phoneField.getText();
            Patient patient = new Patient(name, address, phone);
            patients.add(patient);
            JOptionPane.showMessageDialog(this, "Patient added successfully.");
            clearFields();
        } else if (e.getSource() == displayButton) {
            StringBuilder sb = new StringBuilder();
            for (Patient patient : patients) {
                sb.append("Name: ").append(patient.name).append(", Address: ").append(patient.address)
                        .append(", Phone: ").append(patient.phoneNumber).append("\n");
            }
            JOptionPane.showMessageDialog(this, sb.toString(), "Patients List", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void clearFields() {
        nameField.setText("");
        addressField.setText("");
        phoneField.setText("");
    }

    public static void main(String[] args) {
        new MedicalManagementSystem();
    }
}
