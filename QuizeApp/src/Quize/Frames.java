package Quize;

import java.awt.Color;
import java.awt.Image;
import javax.swing.*;

// Parent class for setting common properties of frames
public class Frames extends JFrame {
  
  // Constructor to initialize common frame properties
  public Frames() {

    setTitle("Quize App"); 
    setLocation(20,20);
    setSize(1300, 700);
    setVisible(true);
    setResizable(true);
    Image i2 = new ImageIcon(this.getClass().getResource("../icons/quiz.png")).getImage();
    this.setIconImage(i2);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Set default close operation

    // Set background color and layout to null for manual component positioning
    getContentPane().setBackground(Color.decode("#ffffff"));
    setLayout(null);
  }
}
