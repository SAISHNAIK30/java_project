//package universitymanagementsystem;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//
//public class deleteRecords extends JFrame implements ActionListener {
//
//    JLabel labelrollno;
//    JButton delete;
//
//    deleteRecords() {
//        setSize(900, 700);
//        setLocation(350, 50);
//        setLayout(null);
//
//        JLabel heading = new JLabel("Delete Student Details");
//        heading.setBounds(310, 30, 500, 50);
//        heading.setFont(new Font("serif", Font.BOLD, 30));
//        add(heading);
//
//        JLabel lblrollno = new JLabel("Roll Number");
//        lblrollno.setBounds(50, 200, 200, 30);
//        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
//        add(lblrollno);
//
//        labelrollno = new JLabel("1533");
//        labelrollno.setBounds(200, 200, 200, 30);
//        labelrollno.setFont(new Font("serif", Font.BOLD, 20));
//        add(labelrollno);
//
//        // Add a Delete button
//        delete = new JButton("Delete");
//        delete.setBounds(650, 550, 120, 30);
//        delete.setBackground(Color.BLACK);
//        delete.setForeground(Color.WHITE);
//        delete.addActionListener(this);
//        delete.setFont(new Font("Tahoma", Font.BOLD, 15));
//        add(delete);
//
//        setVisible(true);
//    }
//
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == delete) {
//            // Handle delete button action
//            String rollNumberToDelete = labelrollno.getText();
//
//            try {
//                String deleteQuery = "DELETE FROM student WHERE rollno = '" + rollNumberToDelete + "'";
//
//                Conn con = new Conn();
//                con.s.executeUpdate(deleteQuery);
//
//                JOptionPane.showMessageDialog(null, "Student Record Deleted Successfully");
//                setVisible(false);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else {
//            setVisible(false);
//        }
//    }
//
//    public static void main(String[] args) {
//        new deleteRecords();
//    }
//}

package universitymanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class deleteRecords extends JFrame implements ActionListener {

    JComboBox<String> rollNumberDropdown;
    JButton delete;

    public deleteRecords() {
        setSize(900, 700);
        setLocation(350, 50);
        setLayout(null);

        JLabel heading = new JLabel("Delete Student Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel lblrollno = new JLabel("Select Roll Number");
        lblrollno.setBounds(50, 200, 200, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollno);

        // Load existing roll numbers into the dropdown
        rollNumberDropdown = new JComboBox<>();
        rollNumberDropdown.setBounds(250, 200, 150, 30);
        addRollNumbersToDropdown(); // Method to load existing roll numbers
        add(rollNumberDropdown);

        // Add a Delete button
        delete = new JButton("Delete");
        delete.setBounds(650, 550, 120, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        delete.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(delete);

        setVisible(true);
    }

    private void addRollNumbersToDropdown() {
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT rollno FROM student");

            while (rs.next()) {
                rollNumberDropdown.addItem(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            // Handle delete button action
            String rollNumberToDelete = (String) rollNumberDropdown.getSelectedItem();

            try {
                String deleteQuery = "DELETE FROM student WHERE rollno = '" + rollNumberToDelete + "'";

                Conn con = new Conn();
                con.s.executeUpdate(deleteQuery);

                JOptionPane.showMessageDialog(null, "Student Record Deleted Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new deleteRecords();
    }
}
