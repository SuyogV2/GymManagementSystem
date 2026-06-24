import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GymGUI extends JFrame {
    JFrame frame;
    JTextField tfId, tfName, tfPhone, tfEmail, tfLocation, tfLoyalty, tfAttendance, tfTrainer;
    JComboBox<String> cbDay, cbMonth, cbYear;
    private JRadioButton rbMale, rbFemale;
    private JCheckBox cbMarkAttendance;
    private JTextArea displayArea;
    private ButtonGroup genderGroup;
    private JButton btnClear, btnCalculateDiscount, btnAddRegular, btnAddPremium, btnDeactivate, btnActivate, btnPayDue, btnUpgradePlan, btnSaveFile, btnReadFile, btnDisplay, btnRevertPlan;

    private ArrayList<String> dummyMembers = new ArrayList<>();

    public GymGUI() {
        frame = new JFrame("suyog  Gym");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        tfId = new JTextField(10);
        tfName = new JTextField(10);
        tfPhone = new JTextField(10);
        tfEmail = new JTextField(10);
        tfLocation = new JTextField(10);
        tfLoyalty = new JTextField(10);
        tfAttendance = new JTextField(10);
        tfTrainer = new JTextField(10);

        cbDay = new JComboBox<>(generateNumbers(1, 31));
        cbMonth = new JComboBox<>(generateNumbers(1, 12));
        cbYear = new JComboBox<>(generateNumbers(1950, 2025));

        rbMale = new JRadioButton("Male");
        rbFemale = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);

        cbMarkAttendance = new JCheckBox("Mark Attendance");

        displayArea = new JTextArea(10, 40);
        displayArea.setEditable(false);

        btnClear = new JButton("Clear");
        btnCalculateDiscount = new JButton("Calculate Discount");
        btnAddRegular = new JButton("Add Regular Member");
        btnAddPremium = new JButton("Add Premium Member");
        btnDeactivate = new JButton("Deactivate Membership");
        btnActivate = new JButton("Activate Membership");
        btnPayDue = new JButton("Pay Due Amount");
        btnUpgradePlan = new JButton("Upgrade Plan");
        btnSaveFile = new JButton("Save the File");
        btnReadFile = new JButton("Read from File");
        btnDisplay = new JButton("Display");
        btnRevertPlan = new JButton("Revert Plan");

        addComponent(gbc, new JLabel("suyog Gym", JLabel.CENTER), 0, 0, 4);
        addComponent(gbc, btnClear, 0, 1, 1);
        addComponent(gbc, new JLabel("ID:"), 0, 2, 1);
        addComponent(gbc, tfId, 1, 2, 1);
        addComponent(gbc, new JLabel("Location:"), 2, 2, 1);
        addComponent(gbc, tfLocation, 3, 2, 1);
        addComponent(gbc, new JLabel("Name:"), 0, 3, 1);
        addComponent(gbc, tfName, 1, 3, 1);
        addComponent(gbc, new JLabel("Loyalty Points:"), 2, 3, 1);
        addComponent(gbc, tfLoyalty, 3, 3, 1);
        addComponent(gbc, new JLabel("Phone:"), 0, 4, 1);
        addComponent(gbc, tfPhone, 1, 4, 1);
        addComponent(gbc, new JLabel("Attendance:"), 2, 4, 1);
        addComponent(gbc, tfAttendance, 3, 4, 1);
        addComponent(gbc, new JLabel("Email:"), 0, 5, 1);
        addComponent(gbc, tfEmail, 1, 5, 1);
        addComponent(gbc, new JLabel("Trainer:"), 2, 5, 1);
        addComponent(gbc, tfTrainer, 3, 5, 1);
        addComponent(gbc, new JLabel("DOB:"), 0, 6, 1);
        JPanel dobPanel = new JPanel();
        dobPanel.add(cbDay);
        dobPanel.add(cbMonth);
        dobPanel.add(cbYear);
        addComponent(gbc, dobPanel, 1, 6, 3);
        addComponent(gbc, new JLabel("Gender:"), 0, 7, 1);
        JPanel genderPanel = new JPanel();
        genderPanel.add(rbMale);
        genderPanel.add(rbFemale);
        addComponent(gbc, genderPanel, 1, 7, 3);
        addComponent(gbc, cbMarkAttendance, 0, 8, 2);
        addComponent(gbc, btnCalculateDiscount, 2, 8, 2);
        // Add Membership Buttons
        addComponent(gbc, btnAddRegular, 0, 9, 1);
        addComponent(gbc, btnAddPremium, 1, 9, 1);
        addComponent(gbc, btnDeactivate, 2, 9, 1);
        addComponent(gbc, btnActivate, 3, 9, 1);

        // Plan and Payment Buttons
        addComponent(gbc, btnPayDue, 0, 10, 1);
        addComponent(gbc, btnUpgradePlan, 1, 10, 1);
        addComponent(gbc, btnSaveFile, 2, 10, 1);
        addComponent(gbc, btnReadFile, 3, 10, 1);
        addComponent(gbc, btnDisplay, 0, 11, 2);
        addComponent(gbc, btnRevertPlan, 2, 11, 2);

        // displayArea
        addComponent(gbc, new JScrollPane(displayArea), 0, 12, 4);

        // ----------------- ACTION LISTENERS -----------------//

        btnClear.addActionListener(e -> {
            tfId.setText("");
            tfName.setText("");
            tfPhone.setText("");
            tfEmail.setText("");
            tfLocation.setText("");
            tfLoyalty.setText("");
            tfAttendance.setText("");
            tfTrainer.setText("");
            cbDay.setSelectedIndex(0);
            cbMonth.setSelectedIndex(0);
            cbYear.setSelectedIndex(0);
            genderGroup.clearSelection();
            cbMarkAttendance.setSelected(false);
            displayArea.setText("");
        });

        btnAddRegular.addActionListener(e -> {
            String memberInfo = "Regular Member: " + tfName.getText();
            dummyMembers.add(memberInfo);
            displayArea.setText("Added Regular Member\n" + memberInfo);
        });

        btnAddPremium.addActionListener(e -> {
            String memberInfo = "Premium Member: " + tfName.getText();
            dummyMembers.add(memberInfo);
            displayArea.setText("Added Premium Member\n" + memberInfo);
        });

        btnDeactivate.addActionListener(e -> {
            displayArea.setText("Membership Deactivated for ID: " + tfId.getText());
        });

        btnActivate.addActionListener(e -> {
            displayArea.setText("Membership Activated for ID: " + tfId.getText());
        });

        btnPayDue.addActionListener(e -> {
            displayArea.setText("Amount Due is for: " + tfName.getText());
        });

        btnUpgradePlan.addActionListener(e -> {
            displayArea.setText("GL;BAy;CBBM:ACLGBN-1o: " + tfName.getText());
        });

        btnRevertPlan.addActionListener(e -> {
            displayArea.setText("Revertez Plan for: " + tfName.getText());
        });

        btnCalculateDiscount.addActionListener(e -> {
            try {
                int loyalty = Integer.parseInt(tfLoyalty.getText());
                int discount = loyalty > 50 ? 20 : 10;
                displayArea.setText("Discount for " + tfName.getText() + ": " + discount + "%");
            } catch (NumberFormatException ex) {
                displayArea.setText("Invalid loyalty point value.");
            }
        });

        btnSaveFile.addActionListener(e -> displayArea.setText("Data saved to file (dummy simulation)."));

        btnReadFile.addActionListener(e -> displayArea.setText("Data read from file (pretend data)...\n" + dummyMembers));

        btnDisplay.addActionListener(e -> displayArea.setText("All Members:\n" + dummyMembers));

        frame.pack();
        frame.setVisible(true);
    }

    private void addComponent(GridBagConstraints gbc, Component comp, int x, int y, int width) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        frame.add(comp, gbc);
    }

    private String[] generateNumbers(int start, int end) {
        String[] nums = new String[end - start + 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = String.valueOf(start + i);
        }
        return nums;
    }

    public static void main(String[] args) {
        new GymGUI();
    }
}