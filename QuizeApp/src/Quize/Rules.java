/*
 * Import necessary packages for Swing components, graphics, and event handling
 */
package Quize;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Create a class for displaying rules of the quiz,
 * implement ActionListener for handling button clicks
 */
public class Rules extends Frames implements ActionListener{

  // Declare variables for player name, start button, and back button
  String name;
  JButton start, back;
  
  // Constructor for initializing the Rules window with the player's name
  Rules(String name) {
    super();

    this.name = name;
    
    // Create and configure heading label
    JLabel heading = new JLabel("Welcome " + name + " to Simple Minds");
    heading.setBounds(50, 20, 700, 30);
    heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
    heading.setForeground(new Color(30, 144, 254));
    add(heading);
    
    // Create and configure rules label with HTML content
    JLabel rules = new JLabel();
    rules.setBounds(20, 90, 700, 350);
    rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
    rules.setText(
        "<html>"+ 
            "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
            "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>" +
            "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
            "4. Crying is allowed but please do so quietly." + "<br><br>" +
            "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
            "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di" + "<br><br>" +
            "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
            "8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
        "<html>"
    );
    add(rules);
    
    // Create and configure back button
    back = new JButton("Back");
    back.setBounds(250, 500, 100, 30);
    back.setBackground(new Color(30, 144, 254));
    back.setForeground(Color.WHITE);
    back.addActionListener(this);
    add(back);
    
    // Create and configure start button
    start = new JButton("Start");
    start.setBounds(400, 500, 100, 30);
    start.setBackground(new Color(30, 144, 254));
    start.setForeground(Color.WHITE);
    start.addActionListener(this);
    add(start);
    
  }
  
  // Method to handle button clicks
  public void actionPerformed(ActionEvent ae) {
  
  if (ae.getSource() == start) {
    // Start the quiz
    new Quiz(name);
    setVisible(false);
  } 
  else {
    // Go back to the login window
    new Login();
    setVisible(false);
  }
  }
}
