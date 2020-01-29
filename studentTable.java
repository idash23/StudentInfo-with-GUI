import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class studentTable {
    private JPanel mainPanel;
    private JButton addNewButton;
    private JButton saveButton;
    private JTextField nameTextField;
    private JTextField emailtextField;
    private JSpinner yearSpinner;
    private JRadioButton yesRadioButton;
    private JRadioButton noRadioButton;
    private JTable table1;
    private JLabel emailLabel;
    private JLabel yearLabel;
    private JLabel nameLabel;
    private JLabel fulltimeLabel;
    private JComboBox yearComboBox;


    public <record> studentTable () {
        DefaultTableModel model = new DefaultTableModel();


        String[] column = {" Name", "Email Address ", " Year", "Status"};
        table1.setShowGrid(true);
        table1.setGridColor(Color.BLACK);
        table1.setModel(model);

        model.setColumnIdentifiers(column);


        Object[] record = new Object[4];
        record[0] = " ";
        record[1] = " ";
        record[2] = " ";
        record[3] = " ";

        model.addRow(record);

        Object[] record2 = new Object[4];
        record2[0] = " ";
        record2[1] = " ";
        record2[2] = " ";
        record2[3] = " ";

        model.addRow(record2);

        table1.setGridColor(Color.BLACK);

        table1.setModel(model);

        DefaultComboBoxModel model1 = new DefaultComboBoxModel();
        model1.addElement("0");
        model1.addElement("1");
        model1.addElement("2");
        model1.addElement("3");
        model1.addElement("4");

        yearComboBox.setModel(model1);





        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = table1.getSelectedRow();

                String nameLabel  = (String) model.getValueAt(0,0);
                String emailLabel = (String) model.getValueAt(0,1);

                // JM NOTES - Since you are using a combo box for years you
                // you can store the value as a string in the table
                String  StudentYear = (String) model.getValueAt(0, 2);
                yearComboBox.setSelectedItem(StudentYear);

                nameTextField.setText(nameLabel);
                emailtextField.setText(emailLabel);

                // JM NOTES - First you have to make sure both Radio buttons are pointing to
                // the same ButtonGroup in the UI editor.
                // Next you can read the value from the table in as a boolean
                // then set both the Yes and No radio buttons
                boolean isFulltime = (boolean) model.getValueAt( 0, 3);
                yesRadioButton.setSelected(isFulltime);
                noRadioButton.setSelected(!isFulltime);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table1.getSelectedRow();
                model.setValueAt(nameTextField.getText(),row, 0);
                model.setValueAt(emailtextField.getText(),row, 1);

                // JM NOTES - for Combo boxes you use getSelectedItem to get the value
                model.setValueAt(yearComboBox.getSelectedItem().toString(), row, 2);

                // JM NOTES - for Radio buttons you use isSelected to get the value
                model.setValueAt(yesRadioButton.isSelected(), row, 3);
            }
        });
        addNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                record [] newRow;
                newRow = (record[]) new Object[4];
                newRow[0] = (record) " ";
                newRow[1] = (record) " ";
                newRow[2] = (record) " ";
                newRow[3] = (record) " ";
                model.addRow(newRow);
                nameTextField.setText(" ");
                emailtextField.setText(" ");
                yearSpinner.setValue(0);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Information");
        frame.setContentPane(new studentTable().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
