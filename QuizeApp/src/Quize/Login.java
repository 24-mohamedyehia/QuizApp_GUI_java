/*
 * Import necessary packages for Swing components, graphics, and event handling
 */
package Quize;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Create a class for the login window,
 * implement ActionListener for handling button clicks
 */
public class Login extends JFrame implements ActionListener {

  // Declare buttons and text field for login
  JButton rules, Exit;
  JTextField tfname;

  // Constructor for initializing the login window
  public Login() {

    // Set background color and layout to null for manual component positioning
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    // Load login image
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/login.jpeg"));

    // Create and configure label to display the login image
    JLabel image = new JLabel(i1);
    image.setBounds(0, 0, 600, 500);
    add(image);

    // Create and configure heading label
    JLabel heading = new JLabel("Simple Minds");
    heading.setBounds(750, 60, 300, 45);
    heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
    heading.setForeground(new Color(30, 144, 254));
    add(heading);

    // Create and configure label for entering name
    JLabel name = new JLabel("Enter your name");
    name.setBounds(810, 150, 300, 20);
    name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
    name.setForeground(new Color(30, 144, 254));
    add(name);

    // Create and configure text field for entering name
    tfname = new JTextField();
    tfname.setBounds(735, 200, 300, 25);
    tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
    add(tfname);

    // Create and configure button for displaying rules
    rules = new JButton("Rules");
    rules.setBounds(735, 270, 120, 25);
    rules.setBackground(new Color(30, 144, 254));
    rules.setForeground(Color.WHITE);
    rules.addActionListener(this);
    add(rules);

    // Create and configure button for going back
    Exit = new JButton("Exit");
    Exit.setBounds(915, 270, 120, 25);
    Exit.setBackground(new Color(30, 144, 254));
    Exit.setForeground(Color.WHITE);
    Exit.addActionListener(this);
    add(Exit);

    // Set window title, size, location, visibility, and close operation
    setTitle("Quize App"); 
    setSize(1200, 500);
    setLocation(100, 150);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  // Method to handle button clicks
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == rules) {
      // Get name from text field, hide login window, and show rules window
      String name = tfname.getText();
      setVisible(false);
      new Rules(name);
    } 
    else if (e.getSource() == Exit) {
      dispose();
    }
  }
}
