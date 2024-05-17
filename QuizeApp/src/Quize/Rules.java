package Quize;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Rules extends Frames implements ActionListener{
  // Declare variables for player name, start button, and back button
  String name;
  JButton startButton, exitButton, BackButton;
  JLabel heading, chooseCategoryLabel, numOfQuestionsLabel;
  private JComboBox categoriesMenu;
  private JTextField numOfQuestionsTextField;

  // Constructor for initializing the Rules window with the player's name
  Rules(String name) {
    super();
    this.name = name;
    addGuiComponents();
  }
  
  private void addGuiComponents(){

    // title label
    heading = new JLabel("Welcome " + name + " to Simple Minds");
    heading.setBounds(500, 20, 700, 30);
    heading.setFont(new Font("Cascadia Code Light", Font.BOLD, 28));
    heading.setForeground(new Color(30, 144, 254));
    add(heading);

    // choose the right answer
    chooseCategoryLabel = new JLabel("Choose a Category");
    chooseCategoryLabel.setFont(new Font("Arial", Font.BOLD, 16));
    chooseCategoryLabel.setBounds(300, 70, 700, 30);
    chooseCategoryLabel.setHorizontalAlignment(SwingConstants.CENTER);
    add(chooseCategoryLabel);

    // category drop down menu
    String[]CA=new String[]{"JAVA"};
    categoriesMenu = new JComboBox(CA);
    categoriesMenu.setBounds(500, 100, 337, 45);
    add(categoriesMenu);

    // num of questions label
    numOfQuestionsLabel = new JLabel("Number of Questions: ");
    numOfQuestionsLabel.setFont(new Font("Arial", Font.BOLD, 16));
    numOfQuestionsLabel.setBounds(500, 160, 172, 20);
    numOfQuestionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
    add(numOfQuestionsLabel);

    // num of questions text input field
    numOfQuestionsTextField = new JTextField("5");
    numOfQuestionsTextField.setFont(new Font("Arial", Font.BOLD, 16));
    numOfQuestionsTextField.setBounds(680, 160, 148, 26);
    add(numOfQuestionsTextField);

    // start button
    startButton = new JButton("Start");
    startButton.setFont(new Font("Arial", Font.BOLD, 16));
    startButton.setBounds(100, 500, 200, 40);
    startButton.addActionListener(this);
    add(startButton);


    // exit button
    exitButton = new JButton("Exit");
    exitButton.setFont(new Font("Arial", Font.BOLD, 16));
    exitButton.setBounds(890, 500, 200, 40);
    exitButton.addActionListener(this);
    add(exitButton);


    BackButton = new JButton("Go Back");
    BackButton.setFont(new Font("Arial", Font.BOLD, 16));
    BackButton.setBounds(500, 500, 200, 40);
    BackButton.setHorizontalAlignment(SwingConstants.CENTER);
    BackButton.addActionListener(this);
    add(BackButton);
  }

  private boolean validateInput(){
    // num of questions field must not be empty
    if (numOfQuestionsTextField.getText().replaceAll(" ", "").length() <= 0) return false;
    // no category is chosen
    return categoriesMenu.getSelectedItem() != null;
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == startButton) {
      if(validateInput()){
        int numOfQuestions = Integer.parseInt(numOfQuestionsTextField.getText());
        JOptionPane.showMessageDialog(this, "Number of Questions: " + numOfQuestions, "Number of Questions", JOptionPane.INFORMATION_MESSAGE);
        // invalid category
        Quiz quizScreenGui = new Quiz("java");
        quizScreenGui.setLocationRelativeTo(Rules.this);
          // dispose of this screen
          Rules.this.dispose();
          // display quiz screen
        quizScreenGui.setVisible(true);}
      else{
        JOptionPane.showMessageDialog(Rules.this, "Please enter valid input.", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
    else if (e.getSource() == exitButton) {
      // dispose of this screen
      Rules.this.dispose();
    }

    else if (e.getSource() == BackButton) {
      // display title screen
      Login titleScreenGui = new Login();
      titleScreenGui.setLocationRelativeTo(Rules.this);
      // dispose of this screen
      Rules.this.dispose();

      // make title screen visible
      titleScreenGui.setVisible(true);
    }
  }

}






