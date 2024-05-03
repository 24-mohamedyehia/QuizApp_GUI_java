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
public class Login extends Frames implements ActionListener {

  // Declare buttons and text field for login
  JButton rules, Exit;
  JTextField tf1;
  JPasswordField tp1;

  // Constructor for initializing the login window
  public Login() {
    super();

    // Load login image
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/login.jpg"));

    // Create and configure label to display the login image
    JLabel image = new JLabel(i1);
    image.setSize(600, 700);
    image.setBounds(0, 0, 700, 700);
    add(image);

    // Create and configure heading label
    JLabel heading = new JLabel("Quize App");
    heading.setBounds(900, 60, 300, 45);
    heading.setFont(new Font("Mongolian Baiti", Font.BOLD, 40));
    heading.setForeground(Color.BLACK);
    add(heading);

    // Create and configure label for entering name
    JLabel name = new JLabel("Enter your name");
    name.setBounds(850, 200, 300, 20);
    name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
    name.setForeground(Color.BLACK);
    add(name);

    // Create and configure text field for entering name
    tf1 = new JTextField();
    tf1.setBounds(850, 250, 300, 25);
    tf1.setFont(new Font("Times New Roman", Font.BOLD, 20));
    add(tf1);

    JLabel pass = new JLabel("Enter your Password");
    pass.setBounds(850, 300, 300, 20);
    pass.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
    pass.setForeground(Color.BLACK);
    add(pass);

    // Create and configure text field for entering password
    tp1 = new JPasswordField();
    tp1.setBounds(850, 350, 300, 25);
    tp1.setFont(new Font("Times New Roman", Font.BOLD, 20));
    add(tp1);

    // Create and configure button for displaying rules
    rules = new JButton("Rules");
    rules.setBounds(850, 500, 120, 40);
    rules.setBackground(Color.decode("#a4d82e"));
    rules.setForeground(Color.BLACK);
    rules.addActionListener(this);
    add(rules);

    // Create and configure button for going back
    Exit = new JButton("Exit");
    Exit.setBounds(1030, 500, 120, 40);
    Exit.setBackground(Color.decode("#a4d82e"));
    Exit.setForeground(Color.BLACK);
    Exit.addActionListener(this);
    add(Exit);
  }

  // Method to handle button clicks
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == rules) {
      // Get name from text field, hide login window, and show rules window
      String name = tf1.getText();
      setVisible(false);
      new Rules(name);
    } 
    else if (e.getSource() == Exit) {
      // Exit the program
      System.exit(0);
    }
  }
}
