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
  JButton Login, signUp;
  JTextField userEmail, userName;
  JPasswordField userPassword;
  JLabel errorMessageLabel, heading, emaiLabel, passwordLabel, nameLabel, errorMassageEmpty, image;



  // Constructor for initializing the login window
  public Login() {
    super();

    iconWorld(true);
    
    

    // ####################################################
    // Create and configure heading label
    heading = new JLabel("Quize App");
    heading.setBounds(900, 60, 300, 45);
    heading.setFont(new Font("Mongolian Baiti", Font.BOLD, 40));
    heading.setForeground(Color.decode("#0099cc"));
    add(heading);

    // ####################################################
    // Create and configure label for entering name
    nameLabel = new JLabel("Enter Your Name");
    nameLabel.setBounds(850, 150, 300, 20);
    nameLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
    nameLabel.setForeground(Color.BLACK);
    nameLabel.setVisible(false); // Initially hidden
    add(nameLabel);

    // Create and configure text field for entering name
    userName = new JTextField();
    userName.setBounds(850, 180, 300, 40);
    userName.setFont(new Font("Times New Roman", Font.BOLD, 20));
    userName.setVisible(false); // Initially hidden
    add(userName);

    // ####################################################

    // Create and configure label for entering name
    emaiLabel = new JLabel("Enter Your Email");
    emaiLabel.setBounds(850, 250, 300, 20);
    emaiLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
    emaiLabel.setForeground(Color.BLACK);
    add(emaiLabel);

    // Create and configure text field for entering name
    userEmail = new JTextField();
    userEmail.setBounds(850, 280, 300, 40);
    userEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
    add(userEmail);

    // ####################################################

    passwordLabel = new JLabel("Enter Your Password");
    passwordLabel.setBounds(850, 350, 300, 20);
    passwordLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
    passwordLabel.setForeground(Color.BLACK);
    add(passwordLabel);

    // Create and configure text field for entering password
    userPassword = new JPasswordField();
    userPassword.setBounds(850, 380, 300, 40);
    userPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
    add(userPassword);

    // ####################################################

    // Create and configure button for displaying rules
    Login = new JButton("Login");
    Login.setBounds(850, 500, 120, 40);
    Login.setBackground(Color.decode("#99e6ff"));
    Login.setForeground(Color.BLACK);
    Login.addActionListener(this);
    add(Login);

    // ####################################################

    // Create and configure button for going back
    signUp = new JButton("sign up");
    signUp.setBounds(1030, 500, 120, 40);
    signUp.setBackground(Color.decode("#99e6ff"));
    signUp.setForeground(Color.BLACK);
    signUp.setVisible(true); // Initially hidden
    signUp.addActionListener(this);
    add(signUp);

    // ####################################################

    // Create and configure error message label (initially hidden)
    errorMessageLabel = new JLabel("Invalid email or password. Please try again.");
    errorMessageLabel.setBounds(850, 450, 400, 20);
    errorMessageLabel.setFont(new Font("Arial", Font.BOLD, 14));
    errorMessageLabel.setForeground(Color.RED);
    errorMessageLabel.setVisible(false); // Initially hidden
    add(errorMessageLabel);

    // ####################################################
    errorMassageEmpty = new JLabel("Please fill all the fields");
    errorMassageEmpty.setBounds(850, 450, 400, 20);
    errorMassageEmpty.setFont(new Font("Arial", Font.BOLD, 14));
    errorMassageEmpty.setForeground(Color.RED);
    errorMassageEmpty.setVisible(false); // Initially hidden
    add(errorMassageEmpty);

  }

  // ########################## Events ##########################################
    // Method to handle button clicks
  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == Login) {
      isEqualLogin();
    } 
    else if (e.getSource() == signUp) {
      
      String buttonText = signUp.getText();
      if (buttonText.equals("sign up")){
        isEqualSinUp();
      } 
      else if (buttonText.equals("submit")){
        isEqualSubmit();
      }
    }
  
  }

  // ######################## Methods ############################################

  private void iconWorld(boolean status){
    ImageIcon shieldIcon = new ImageIcon(getClass().getResource("/icons/world-creativity-and-innovation-day.gif"));
    JLabel shieldLabel = new JLabel(shieldIcon);
    shieldLabel.setSize(shieldIcon.getIconWidth() , shieldIcon.getIconHeight());
    shieldLabel.setBounds(0, 0, 700, 700);
    add(shieldLabel);
    validate(); // Ensure the new component is displayed
    shieldLabel.setVisible(status);
  }

  

  // Method to validate email and password 
  private boolean isValidUser(String email, String password) {
      // Hardcoded email and password for demonstration
      String validEmail = "1";
      String validPassword = "1";

      // Validate email and password
      return email.equals(validEmail) && password.equals(validPassword);
  }


  private void isEqualSubmit() {
    String name = userName.getText();
    String email = userEmail.getText();
    String password = new String(userPassword.getPassword());

    if (email.isEmpty() || password.isEmpty() || name.isEmpty()) {
      errorMassageEmpty.setVisible(true);
    } 
    else {
      new Rules(name);
      this.setVisible(false);
    }
  }


  private void isEqualSinUp(){
    userEmail.setText(""); // Clear text fields
    userPassword.setText(""); // Clear password fields
    userName.setText("");
    heading.setText("Create Your Account");
    heading.setBounds(800, 60, 400, 45);
    userName.setVisible(true);
    nameLabel.setVisible(true);
    errorMessageLabel.setVisible(false);
    errorMassageEmpty.setVisible(false);
    Login.setVisible(true);
    signUp.setText("submit");
  }


  private void isEqualLogin(){
    // Get email and password from text fields
    String email = userEmail.getText();
    String password = new String(userPassword.getPassword());

    heading.setText("Quize App");
    heading.setBounds(900, 60, 300, 45);
    userName.setVisible(false);
    nameLabel.setVisible(false);
    userEmail.setText(""); // Clear text fields
    userPassword.setText(""); // Clear password fields
    errorMessageLabel.setVisible(false);
    signUp.setText("sign up");
    errorMassageEmpty.setVisible(false);

    // Check if email and password are empty
    if (email.isEmpty() || password.isEmpty()) {
      errorMassageEmpty.setVisible(true);
    } 
    else {
      
      // Dummy validation (replace with your actual validation logic)
      if (isValidUser(email, password)) {

        iconWorld(false);

        // If email and password are valid, proceed to rules window
        new Rules(email);
        setVisible(false);
    
      } 
      else {
        // If email and password are not valid, show error message
        userEmail.setText(""); // Clear text fields
        userPassword.setText(""); // Clear password fields
        errorMessageLabel.setVisible(true); // Show error message
      }
    }
  }



}