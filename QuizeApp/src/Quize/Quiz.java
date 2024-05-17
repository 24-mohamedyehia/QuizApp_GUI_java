package Quize;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends Frames implements ActionListener {

    String[] questions = {
            "what is the capital of France?",
            "what is largest animal on Earth?",
            "Who wrote Romeo and Juliet?",
            "Which is the largest planet in our solar system?",
            "Which keyword is used for accessing the features of a package?",
    };

    String[][] options = {
            {"Berlin", "London", "Roma", "Paris"},
            {"Elephant", "Giraffe", "Blue Whale", "Line"},
            {"Shakespeare", "Hemingway", "Tolstoy", "Dickens"},
            {"Saturn", "Jupiter", "Neptune", "Mars"},
            {"package", "extends", "import", "export"},
    };

    String[] correntAnswers = {"Paris", "Blue Whale", "Shakespeare", "Jupiter", "import"};

    String[] userAnswers = new String[correntAnswers.length];
    String name;

    int currentQuestionIndex = 0;
    int timeLeft = 30;
    int score;
    int numOfQuestions;


    Timer timer;

    ImageIcon i1;
    JLabel  image, questionLabel, timerLable, errorChoose;
    JRadioButton option1, option2, option3, option4;
    ButtonGroup group;
    JButton previousButton, nextButton;

    // Constructor for initializing the quiz window with the player's name
    Quiz(String name,int numOfQuestions) {
        super();
        this.name = name;
        this.numOfQuestions = numOfQuestions;

        

        // Load quiz image
        i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/question.gif"));
        Image image = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon resizedIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setBounds(800, 150, 400, 400);
        add(imageLabel);


        questionLabel = new JLabel("1 - " + questions[currentQuestionIndex]);
        questionLabel.setBounds(150, 50, 900, 30);
        questionLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(questionLabel);

        option1 = new JRadioButton(options[currentQuestionIndex][0]);
        option1.setBounds(170, 90, 700, 30);
        option1.setFont(new Font("Dialog", Font.PLAIN, 20));
        option1.setBackground(Color.decode("#ffffff"));
        add(option1);

        option2 = new JRadioButton(options[currentQuestionIndex][1]);
        option2.setBounds(170, 130, 700, 30);
        option2.setFont(new Font("Dialog", Font.PLAIN, 20));
        option2.setBackground(Color.decode("#ffffff"));
        add(option2);

        option3 = new JRadioButton(options[currentQuestionIndex][2]);
        option3.setBounds(170, 170, 700, 30);
        option3.setFont(new Font("Dialog", Font.PLAIN, 20));
        option3.setBackground(Color.decode("#ffffff"));
        add(option3);

        option4 = new JRadioButton(options[currentQuestionIndex][3]);
        option4.setBounds(170, 210, 700, 30);
        option4.setFont(new Font("Dialog", Font.PLAIN, 20));
        option4.setBackground(Color.decode("#ffffff"));
        add(option4);

        group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);
        group.add(option4);

        timerLable = new JLabel("Time left: " + timeLeft + "s");
        timerLable.setBounds(170, 420, 200, 50);
        timerLable.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(timerLable);
        timer = new Timer(1000, this);
        timer.start();

        previousButton = new JButton("Previous");
        previousButton.setBounds(170, 530, 200, 50);
        previousButton.setBackground(Color.decode("#99e6ff"));
        previousButton.setForeground(Color.BLACK);
        previousButton.setFont(new Font("Arial", Font.BOLD, 14));
        add(previousButton);
        previousButton.addActionListener(this);

        nextButton = new JButton("Next");
        nextButton.setBounds(170, 470, 200, 50);
        nextButton.setBackground(Color.decode("#99e6ff"));
        nextButton.setForeground(Color.BLACK);
        nextButton.setFont(new Font("Arial", Font.BOLD, 14));
        add(nextButton);
        nextButton.addActionListener(this);

        errorChoose = new JLabel("Please select an answer");
        errorChoose.setBounds(170, 240, 300, 50);
        errorChoose.setFont(new Font("Dialog", Font.BOLD, 18));
        errorChoose.setForeground(Color.RED);
        errorChoose.setVisible(false);
        add(errorChoose);

        // Configure key bindings
        configureKeyBindings();

    }

    private void configureKeyBindings() {
        // InputMap and ActionMap for key bindings
        InputMap inputMap = nextButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = nextButton.getActionMap();

        // Bind the Enter key to the "next" button's action
        inputMap.put(KeyStroke.getKeyStroke("ENTER"), "nextButtonAction");
        actionMap.put("nextButtonAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleNextClick();
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == previousButton){
            handlePrevClick();
        }
        if (e.getSource() == nextButton) {
            handleNextClick();
        }
        if (e.getSource() == timer) {
            count();
        }
    }

//---------------- Methods ----------------

    private void count() {
        timeLeft--;
        timerLable.setText("Time left: " + timeLeft + "s");

        if (timeLeft <= 5)
            timerLable.setForeground(Color.red);
        if (timeLeft == 0) {
            timer.stop();
            score = calculateScore();
            new Score(name, score);
        }
    }

    private void handlePrevClick() {
        errorChoose.setVisible(false);
        if (currentQuestionIndex > 0) {
            currentQuestionIndex--;
            questionLabel.setText(currentQuestionIndex+1 + " - " + questions[currentQuestionIndex]);
            option1.setText(options[currentQuestionIndex][0]);
            option2.setText(options[currentQuestionIndex][1]);
            option3.setText(options[currentQuestionIndex][2]);
            option4.setText(options[currentQuestionIndex][3]);
            if (userAnswers[currentQuestionIndex] != null) {
                if (userAnswers[currentQuestionIndex].equals(options[currentQuestionIndex][0]))
                    option1.setSelected(true);
                else if (userAnswers[currentQuestionIndex].equals(options[currentQuestionIndex][1]))
                    option2.setSelected(true);
                else if (userAnswers[currentQuestionIndex].equals(options[currentQuestionIndex][2]))
                    option3.setSelected(true);
                else if (userAnswers[currentQuestionIndex].equals(options[currentQuestionIndex][3]))
                    option4.setSelected(true);
            }
        }
    }

    private void handleNextClick() {
        errorChoose.setVisible(false);
        if (currentQuestionIndex < questions.length) {
            if (option1.isSelected()) {
                userAnswers[currentQuestionIndex] = option1.getText();
            } else if (option2.isSelected()) {
                userAnswers[currentQuestionIndex] = option2.getText();
            } else if (option3.isSelected()) {
                userAnswers[currentQuestionIndex] = option3.getText();
            } else if (option4.isSelected()) {
                userAnswers[currentQuestionIndex] = option4.getText();
            } else {
                errorChoose.setVisible(true);
                return;
            }

            currentQuestionIndex++;

            if (currentQuestionIndex < questions.length) {
                questionLabel.setText(currentQuestionIndex+1 + " - " +  questions[currentQuestionIndex]);
                option1.setText(options[currentQuestionIndex][0]);
                option2.setText(options[currentQuestionIndex][1]);
                option3.setText(options[currentQuestionIndex][2]);
                option4.setText(options[currentQuestionIndex][3]);
                group.clearSelection();
            } else {
                timer.stop();
                score = calculateScore();
                new Score(name, score);
            }
        }
    }

    private int calculateScore() {
        score = 0;
        for (int i = 0; i < correntAnswers.length; i++) {
            if (userAnswers[i] != null && userAnswers[i].equals(correntAnswers[i])) {
                score++;
            }
        }
        return score;
    }
}