import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 * Hangman Game
 * 
 * 5/8/17
 */
public class PlayHangman extends Carrier implements Hangman 
{ 
    private ArrayList <String> words = new ArrayList <String>();  // ArrayList holds the words from the file 
    ArrayList <String> newWord = new ArrayList <String>();
    Random rand = new Random();
    private int count;
    private String randWord;
    JFrame frame;
    JPanel panel;
    JLabel guessLetter;
    MyPanel manPanel = new MyPanel();
    private String term = "";
    private int tries = 0;
    JButton button;
    JButton randWordButton;
    JButton endGame;
    JButton letterA, letterB, letterC, letterD, letterE, letterF, letterG, letterH, letterI, letterJ, 
    letterK, letterL, letterM, letterN, letterO, letterP, letterQ, letterR,letterS, letterT, letterU,
    letterV, letterW, letterX, letterY, letterZ;
    JLabel word;

    /**
     * constructor initializes instance variables for Hangman
     * Pre: None
     * Parameters: None
     * Post: None
     * return: None 
     */
    public PlayHangman()
    {
        frame = new JFrame();
        count = 0;
        addWords();
        frame.setTitle(" Hangman Frame");
        frame.setLayout(null);  //allows you to freely place anything anywhere
        frame.setVisible(true);
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();

        button = new JButton("Start Game");
        button.addActionListener(new ActionListener(){
                /**
                 * method that sets visibilty for buttons
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    randWordButton.setVisible(true);
                    button.setVisible(false);
                    word.setVisible(true);
                    endGame.setVisible(true);
                    endGame.setVisible(true);
                    letterA.setVisible(true);
                    letterB.setVisible(true);
                    letterC.setVisible(true);
                    letterD.setVisible(true); 
                    letterE.setVisible(true);
                    letterF.setVisible(true);
                    letterG.setVisible(true);
                    letterH.setVisible(true);
                    letterI.setVisible(true);
                    letterJ.setVisible(true);
                    letterK.setVisible(true);
                    letterL.setVisible(true);
                    letterM.setVisible(true); 
                    letterN.setVisible(true);
                    letterO.setVisible(true);
                    letterP.setVisible(true);
                    letterQ.setVisible(true);
                    letterR.setVisible(true);
                    letterS.setVisible(true);
                    letterT.setVisible(true); 
                    letterU.setVisible(true);
                    letterV.setVisible(true);
                    letterW.setVisible(true);
                    letterX.setVisible(true);
                    letterY.setVisible(true);
                    letterZ.setVisible(true);
                    frame.setVisible(true);
                    manPanel.setVisible(true);
                } // ends the actionPerformed method
            });
        randWordButton = new JButton("Change Word");
        randWordButton.addActionListener(new ActionListener(){
                /**
                 * method that sets visibilty and actions for buttons
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    randWord = getWord();
                    System.out.println("New Random Word (: " + randWord.toUpperCase());
                    setWord();
                    word.setText(drawWord());
                    letterA.setEnabled(true);
                    letterB.setEnabled(true);
                    letterC.setEnabled(true);
                    letterD.setEnabled(true); 
                    letterE.setEnabled(true);
                    letterF.setEnabled(true);
                    letterG.setEnabled(true);
                    letterH.setEnabled(true);
                    letterI.setEnabled(true);
                    letterJ.setEnabled(true);
                    letterK.setEnabled(true);
                    letterL.setEnabled(true);
                    letterM.setEnabled(true); 
                    letterN.setEnabled(true);
                    letterO.setEnabled(true); 
                    letterP.setEnabled(true);
                    letterQ.setEnabled(true);
                    letterR.setEnabled(true);
                    letterS.setEnabled(true);
                    letterT.setEnabled(true); 
                    letterU.setEnabled(true);
                    letterV.setEnabled(true);
                    letterW.setEnabled(true);
                    letterX.setEnabled(true);
                    letterY.setEnabled(true);
                    letterZ.setEnabled(true);
                    manPanel.redraw();
                    manPanel.resetBadGuess();
                    guessLetter.setText(Integer.toString(manPanel.getBadGuess()));
                } // ends the actionPerformed method
            });
        randWordButton.setBounds(300, 10, 125, 50);
        randWordButton.setVisible(false);
        frame.add(randWordButton);

        button.setBounds(300, 10, 125, 50);
        frame.add(button);

        endGame = new JButton("End Game");
        endGame.addActionListener(new ActionListener(){
                /**
                 * method that exits out of the game
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    System.exit(0);
                } // ends the actionPerformed method
            });
        endGame.setBounds(1000, 10, 125, 50);
        endGame.setVisible(false);
        frame.add(endGame);

        // creating panel
        manPanel.setVisible(false);
        manPanel.setSize(600, 500);
        manPanel.setLocation(0, 200);
        frame.add(manPanel);

        letterA = new JButton("A");
        letterA.addActionListener(new ActionListener(){
                /**
                 * method that checks for letter a
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    if(hasLetter("a") == false)
                    {
                        manPanel.addBadGuess();
                        System.out.println("letter not found *");
                        guessLetter.setText(Integer.toString(manPanel.getBadGuess()));
                    } // ends the if statement
                    else
                    {
                        updateWord("a");
                        word.setText(drawWord());
                    } // ends the else statement
                    letterA.setEnabled(false);
                    manPanel.redraw();
                } // ends the actionPerformed method
            });
        letterA.setBounds(800, 400, 50, 25);
        letterA.setVisible(false);
        frame.add(letterA);

        letterB = new JButton("B");
        letterB.addActionListener(new ActionListener(){
                /**
                 * method that checks for letter b
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    if(hasLetter("b") == false)
                    {
                        manPanel.addBadGuess();
                        System.out.println("letter not found *");
                        guessLetter.setText(Integer.toString(manPanel.getBadGuess()));
                    } // ends the if statement
                    else
                    {
                        updateWord("b");
                        word.setText(drawWord());
                    } // ends the else statement
                    letterB.setEnabled(false);
                    manPanel.redraw();
                } // ends the actionPerformed method
            });
        letterB.setBounds(850, 400, 50, 25);
        letterB.setVisible(false);
        frame.add(letterB);

        letterC = new JButton("C");
        letterC.addActionListener(new ActionListener(){
                /**
                 * method that checks for letter c
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    if(hasLetter("c") == false)
                    {
                        manPanel.addBadGuess();
                        System.out.println("letter not found *");
                        guessLetter.setText(Integer.toString(manPanel.getBadGuess()));
                    } // ends the if statement
                    else
                    {
                        updateWord("c");
                        word.setText(drawWord());
                    } // ends the else statement
                    letterC.setEnabled(false);
                    manPanel.redraw();
                } // ends the actionPerformed method
            });
        letterC.setBounds(900, 400, 50, 25);
        letterC.setVisible(false);
        frame.add(letterC);

        letterD = new JButton("D");
        letterD.addActionListener(new ActionListener(){
                /**
                 * method that checks for letter d
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    if(hasLetter("d") == false)
                    {
                        manPanel.addBadGuess();
                        System.out.println("letter not found *");
                        guessLetter.setText(Integer.toString(manPanel.getBadGuess()));
                    } // ends the if statement
                    else
                    {
                        updateWord("d");
                        word.setText(drawWord());
                    } // ends the else statement
                    letterD.setEnabled(false);
                    manPanel.redraw();
                } // ends the actionPerformed method
            });
        letterD.setBounds(950, 400, 50, 25);
        letterD.setVisible(false);
        frame.add(letterD);

        letterE = new JButton("E");
        letterE.addActionListener(new ActionListener(){
                /**
                 * method that checks for letter e
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    if(hasLetter("e") == false)
                    {
                        manPanel.addBadGuess();
                        System.out.println("letter not found *");
                        guessLetter.setText(Integer.toString(manPanel.getBadGuess())); // returns a String object representing the specified integer.
                    } // ends the if statement
                    else
                    {
                        updateWord("e");
                        word.setText(drawWord());
                    } // ends the else statement
                    letterE.setEnabled(false);
                    manPanel.redraw();
                } // ends the actionPerformed method
            });
        letterE.setBounds(1000, 400, 50, 25);
        letterE.setVisible(false);
        frame.add(letterE);

        letterF = new JButton("F");
        letterF.addActionListener(new ActionListener(){
                /**
                 * method that checks for letter f
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    if(hasLetter("f") == false)
                    {
                        manPanel.addBadGuess();
                        System.out.println("letter not found *");
                        guessLetter.setText(Integer.toString(manPanel.getBadGuess()));
                    } // ends the if statement
                    else
                    {
                        updateWord("f");
                        word.setText(drawWord());
                    } // ends the else statement
                    letterF.setEnabled(false);
                    manPanel.redraw();
                } // ends the actionPerformed method
            });
        letterF.setBounds(1050, 400, 50, 25);
        letterF.setVisible(false);
        frame.add(letterF);

        letterG = new JButton("G");
        letterG.addActionListener(new ActionListener(){
                /**
                 * method that checks for letter g
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    if(hasLetter("g") == false)
                    {
                        manPanel.addBadGuess();
                        System.out.println("letter not found *");
                        guessLetter.setText(Integer.toString(manPanel.getBadGuess()));
                    } // ends the if statement
                    else
                    {
                        updateWord("g");
                        word.setText(drawWord());
                    } // ends the else statement
                    letterG.setEnabled(false);
                    manPanel.redraw();
                } // ends the actionPerformed method 
            });
        letterG.setBounds(1100, 400, 50, 25);
        letterG.setVisible(false);
        frame.add(letterG);

        letterH = new JButton("H");
        letterH.addActionListener(new ActionListener(){
                /**
                 * method that checks for letter h
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    if(hasLetter("h") == false)
                    {
                        manPanel.addBadGuess();
                        System.out.println("letter not found *");
                        guessLetter.setText(Integer.toString(manPanel.getBadGuess()));
                    } // ends the if statement
                    else
                    {
                        updateWord("h");
                        word.setText(drawWord());
                    }  // ends the else statement
                    letterH.setEnabled(false);
                    manPanel.redraw();
                } // ends the actionPerformed method
            });
        letterH.setBounds(800, 425, 50, 25);
        letterH.setVisible(false);
        frame.add(letterH);

        letterI = new JButton("I");
        letterI.addActionListener(new ActionListener(){
                /**
                 * method that checks for letter i
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    if(hasLetter("i") == false)
                    {
                        manPanel.addBadGuess();
                        System.out.println("letter not found *");
                        guessLetter.setText(Integer.toString(manPanel.getBadGuess()));
                    } // ends the if statement
                    else
                    {
                        updateWord("i");
                        word.setText(drawWord());
                    }  // ends the else statement
                    letterI.setEnabled(false);
                    manPanel.redraw();
                } // ends the actionPerformed method
            });
        letterI.setBounds(850, 425, 50, 25);
        letterI.setVisible(false);
        frame.add(letterI);

        letterJ = new JButton("J");
        letterJ.addActionListener(new ActionListener(){
                /**
                 * method that checks for letter j
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    if(hasLetter("j") == false)
                    {
                        manPanel.addBadGuess();
                        System.out.println("letter not found *");
                        guessLetter.setText(Integer.toString(manPanel.getBadGuess()));
                    } // ends the if statement
                    else
                    {
                        updateWord("j");
                        word.setText(drawWord());
                    } // ends the else statement
                    letterJ.setEnabled(false);
                    manPanel.redraw();
                } // ends the actionPerformed method
            });
        letterJ.setBounds(900, 425, 50, 25);
        letterJ.setVisible(false);
        frame.add(letterJ);

        letterK = new JButton("K");
        letterK.addActionListener(new ActionListener(){
                /**
                 * method that checks for letter k
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    if(hasLetter("k") == false)
                    {
                        manPanel.addBadGuess();
                        System.out.println("letter not found *");
                        guessLetter.setText(Integer.toString(manPanel.getBadGuess()));
                    } // ends the if statement
                    else
                    {
                        updateWord("k");
                        word.setText(drawWord());
                    } // ends the else statement
                    letterK.setEnabled(false);
                    manPanel.redraw();
                } // ends the actionPerformed method
            });
        letterK.setBounds(950, 425, 50, 25);
        letterK.setVisible(false);
        frame.add(letterK);

        letterL = new JButton("L");
        letterL.addActionListener(new ActionListener(){
                /**
                 * method that checks for letter l
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    if(hasLetter("l") == false)
                    {
                        manPanel.addBadGuess();
                        System.out.println("letter not found *");
                        guessLetter.setText(Integer.toString(manPanel.getBadGuess()));
                    } // ends the if statement
                    else
                    {
                        updateWord("l");
                        word.setText(drawWord());
                    } // ends the else statement
                    letterL.setEnabled(false);
                    manPanel.redraw();
                } // ends the actionPerformed method
            });
        letterL.setBounds(1000, 425, 50, 25);
        letterL.setVisible(false);
        frame.add(letterL);

        letterM = new JButton("M");
        letterM.addActionListener(new ActionListener(){
                /**
                 * method that checks for letter m
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    if(hasLetter("m") == false)
                    {
                        manPanel.addBadGuess();
                        System.out.println("letter not found *");
                        guessLetter.setText(Integer.toString(manPanel.getBadGuess()));
                    } // ends the if statement
                    else
                    {
                        updateWord("m");
                        word.setText(drawWord());
                    } // ends the else statement
                    letterM.setEnabled(false);
                    manPanel.redraw();
                } // ends the actionPerformed method
            });
        letterM.setBounds(1050, 425, 50, 25);
        letterM.setVisible(false);
        frame.add(letterM);

        letterN = new JButton("N");
        letterN.addActionListener(new ActionListener(){
                /**
                 * method that checks for letter n
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    if(hasLetter("n") == false)
                    {
                        manPanel.addBadGuess();
                        System.out.println("letter not found *");
                        guessLetter.setText(Integer.toString(manPanel.getBadGuess()));
                    } // ends the if statement
                    else
                    {
                        updateWord("n");
                        word.setText(drawWord());
                    } // ends the else statement
                    letterN.setEnabled(false);
                    manPanel.redraw();
                } // ends the actionPerformed method
            });
        letterN.setBounds(1100, 425, 50, 25);
        letterN.setVisible(false);
        frame.add(letterN);

        letterO = new JButton("O");
        letterO.addActionListener(new ActionListener(){
                /**
                 * method that checks for letter o
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    if(hasLetter("o") == false)
                    {
                        manPanel.addBadGuess();
                        System.out.println("letter not found *");
                        guessLetter.setText(Integer.toString(manPanel.getBadGuess()));
                    } // ends the if statement
                    else
                    {
                        updateWord("o");
                        word.setText(drawWord());
                    } // ends the else statement
                    letterO.setEnabled(false);
                    manPanel.redraw();
                } // ends the actionPerformed method
            });
        letterO.setBounds(800, 450, 50, 25);
        letterO.setVisible(false);
        frame.add(letterO);

        letterP = new JButton("P");
        letterP.addActionListener(new ActionListener(){
                /**
                 * method that checks for letter p
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    if(hasLetter("p") == false)
                    {
                        manPanel.addBadGuess();
                        System.out.println("letter not found *");
                        guessLetter.setText(Integer.toString(manPanel.getBadGuess()));
                    } // ends the if statement
                    else
                    {
                        updateWord("p");
                        word.setText(drawWord());
                    } // ends the else statement
                    letterP.setEnabled(false);
                    manPanel.redraw();
                } // ends the actionPerformed method
            });
        letterP.setBounds(850, 450, 50, 25);
        letterP.setVisible(false);
        frame.add(letterP);

        letterQ = new JButton("Q");
        letterQ.addActionListener(new ActionListener(){
                /**
                 * method that checks for letter q
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    if(hasLetter("q") == false)
                    {
                        manPanel.addBadGuess();
                        System.out.println("letter not found *");
                        guessLetter.setText(Integer.toString(manPanel.getBadGuess()));
                    } // ends the if statement
                    else
                    {
                        updateWord("q");
                        word.setText(drawWord());
                    } // ends the else statement
                    letterQ.setEnabled(false);
                    manPanel.redraw();
                } // ends the actionPerformed method
            });
        letterQ.setBounds(900, 450, 50, 25);
        letterQ.setVisible(false);
        frame.add(letterQ);

        letterR = new JButton("R");
        letterR.addActionListener(new ActionListener(){
                /**
                 * method that checks for letter r
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    if(hasLetter("r") == false)
                    {
                        manPanel.addBadGuess();
                        System.out.println("letter not found *");
                        guessLetter.setText(Integer.toString(manPanel.getBadGuess()));
                    } // ends the if statement
                    else
                    {
                        updateWord("r");
                        word.setText(drawWord());
                    } // ends the else statement
                    letterR.setEnabled(false);
                    manPanel.redraw();
                } // ends the actionPerformed method 
            });
        letterR.setBounds(950, 450, 50, 25);
        letterR.setVisible(false);
        frame.add(letterR);

        letterS = new JButton("S");
        letterS.addActionListener(new ActionListener(){
                /**
                 * method that checks for letter s
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    if(hasLetter("s") == false)
                    {
                        manPanel.addBadGuess();
                        System.out.println("letter not found *");
                        guessLetter.setText(Integer.toString(manPanel.getBadGuess()));
                    } // ends the if statement
                    else
                    {
                        updateWord("s");
                        word.setText(drawWord());
                    } // ends the else statement
                    letterS.setEnabled(false);
                    manPanel.redraw();
                } // ends the actionPerformed method
            });
        letterS.setBounds(1000, 450, 50, 25);
        letterS.setVisible(false);
        frame.add(letterS);

        letterT = new JButton("T");
        letterT.addActionListener(new ActionListener(){
                /**
                 * method that checks for letter t
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    if(hasLetter("t") == false)
                    {
                        manPanel.addBadGuess();
                        System.out.println("letter not found *");
                        guessLetter.setText(Integer.toString(manPanel.getBadGuess()));
                    } // ends the if statement
                    else
                    {
                        updateWord("t");
                        word.setText(drawWord());
                    } // ends the else statement
                    letterT.setEnabled(false);
                    manPanel.redraw();
                } // ends the actionPerformed method
            });
        letterT.setBounds(1050, 450, 50, 25);
        letterT.setVisible(false);
        frame.add(letterT);

        letterU = new JButton("U");
        letterU.addActionListener(new ActionListener(){
                /**
                 * method that checks for letter u
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    if(hasLetter("u") == false)
                    {
                        manPanel.addBadGuess();
                        System.out.println("letter not found *");
                        guessLetter.setText(Integer.toString(manPanel.getBadGuess()));
                    } // ends the if statement 
                    else
                    {
                        updateWord("u");
                        word.setText(drawWord());
                    } // ends the else statement
                    letterU.setEnabled(false);
                    manPanel.redraw();
                } // ends the actionPerformed method
            });
        letterU.setBounds(1100, 450, 50, 25);
        letterU.setVisible(false);
        frame.add(letterU);

        letterV = new JButton("V");
        letterV.addActionListener(new ActionListener(){
                /**
                 * method that checks for letter v
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    if(hasLetter("v") == false)
                    {
                        manPanel.addBadGuess();
                        System.out.println("letter not found *");
                        guessLetter.setText(Integer.toString(manPanel.getBadGuess()));
                    } // ends the if statement
                    else
                    {
                        updateWord("v");
                        word.setText(drawWord());
                    } // ends the else statement
                    letterV.setEnabled(false);
                    manPanel.redraw();
                } // ends the actionPerformed method
            });
        letterV.setBounds(800, 475, 50, 25);
        letterV.setVisible(false);
        frame.add(letterV);

        letterW = new JButton("W");
        letterW.addActionListener(new ActionListener(){
                /**
                 * method that checks for letter w
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    if(hasLetter("w") == false)
                    {
                        manPanel.addBadGuess();
                        System.out.println("letter not found *");
                        guessLetter.setText(Integer.toString(manPanel.getBadGuess()));
                    } // ends the if statement
                    else 
                    {
                        updateWord("w");
                        word.setText(drawWord());
                    } // ends the else statement
                    letterW.setEnabled(false);
                    manPanel.redraw();
                } // ends the actionPerformed method
            });
        letterW.setBounds(850, 475, 50, 25);
        letterW.setVisible(false);
        frame.add(letterW);

        letterX = new JButton("X");
        letterX.addActionListener(new ActionListener(){
                /**
                 * method that checks for letter x
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    if(hasLetter("x") == false)
                    {
                        manPanel.addBadGuess();
                        System.out.println("letter not found *");
                        guessLetter.setText(Integer.toString(manPanel.getBadGuess()));
                    } // ends the if statement
                    else
                    {
                        updateWord("x");
                        word.setText(drawWord());
                    } // ends the else statement
                    letterX.setEnabled(false);
                    manPanel.redraw();
                } // ends the actionPerformed method
            });
        letterX.setBounds(900, 475, 50, 25);
        letterX.setVisible(false);
        frame.add(letterX);

        letterY = new JButton("Y");
        letterY.addActionListener(new ActionListener(){
                /**
                 * method that checks for letter y
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    if(hasLetter("y") == false)
                    {
                        manPanel.addBadGuess();
                        System.out.println("letter not found *");
                        guessLetter.setText(Integer.toString(manPanel.getBadGuess()));
                    } // ends the if statement
                    else
                    {
                        updateWord("y");
                        word.setText(drawWord());
                    } // ends the else statement
                    letterY.setEnabled(false);
                    manPanel.redraw();
                } // ends the actionPerformed method
            });
        letterY.setBounds(950, 475, 50, 25);
        letterY.setVisible(false);
        frame.add(letterY);

        letterZ = new JButton("Z");
        letterZ.addActionListener(new ActionListener(){
                /**
                 * method that checks for letter z
                 */
                public void actionPerformed(ActionEvent evt)
                {
                    if(hasLetter("z") == false)
                    {
                        manPanel.addBadGuess();
                        System.out.println("letter not found *");
                        guessLetter.setText(Integer.toString(manPanel.getBadGuess()));
                    } // ends the if statement
                    else
                    {
                        updateWord("z");
                        word.setText(drawWord());
                    } // ends the else statement
                    letterZ.setEnabled(false);
                    manPanel.redraw();
                } // ends the actionPerformed method
            });
        letterZ.setBounds(1000, 475, 50, 25);
        letterZ.setVisible(false);
        frame.add(letterZ);

        randWord = getWord();
        setWord();
        System.out.println(randWord.toUpperCase());

        word = new JLabel();
        word.setText(drawWord());
        word.setBounds(700, 150, 300, 50);
        word.setVisible(false);

        guessLetter = new JLabel();
        guessLetter.setBounds(700, 170, 300, 50);
        guessLetter.setText(Integer.toString(manPanel.getBadGuess()));
        frame.add(guessLetter);
        frame.add(word);
    } // ends the playHangman constructor 

    /**
     * method that sets frame visible when game is started
     * Pre: None
     * Parameters: None
     * Post: None
     * return: None
     */
    public void startGame()
    {
        frame.setVisible(true);
    } // ends the startGame method

    /**
     * method that sets the word into strings of "_" (replace)
     * Pre: None
     * Parameters: None
     * Post: None
     * return: None
     */
    public void setWord() 
    {
        newWord = new ArrayList <String>();
        String temp;
        for(int i = 0; i < randWord.length()-1; i++)
        {
            temp = randWord.substring(i, i+1);
            newWord.add("_ ");
        } // ends the for loop 
        temp = randWord.substring(randWord.length()-1);
        newWord.add("_ ");
    } // ends the setWord method

    /**
     * method that draws the letter at the "_" for each index depending on the where the letter was found
     * Pre: None
     * Parameters: None
     * Post: None
     * return: None
     */
    public String drawWord()
    {
        String wordSize = "";
        for(int i = 0; i < newWord.size(); i++)
        {
            wordSize += newWord.get(i);
        } // ends the for loop
        return wordSize;
    } // ends the drawWord method

    /**
     * method that sets the letter in the spot where the letter is found
     * Pre: None
     * Parameters: None
     * Post: None
     * return: None
     */
    public void updateWord(String letter)
    {
        String temp;
        for(int i = 0; i < randWord.length()-1; i++)
        {
            temp = randWord.substring(i, i+1);
            if(temp.equals(letter))
            {
                newWord.set(i, letter);
            } // ends the if statement
        } // ends the for loop
        temp = randWord.substring(randWord.length()-1);
        if(temp.equals(letter))
        {
            newWord.set(randWord.length()-1, letter);
        } // ends the if statement
    } // ends the updateWord method

    /**
     * method gets random word from list
     * Pre: None
     * Parameters: None
     * Post: None
     * return: term
     */
    public String getWord()
    {
        int r = rand.nextInt(words.size());
        while(r < 0 || r > words.size())
        {
            rand = new Random(r);
            r = rand.nextInt(words.size());
        } // ends the while loop 
        term = words.get(r);
        System.out.println("word chosen is " + r);

        return term;
    } // ends the getWord method

    /**
     * method that adds the words into the ArrayList words
     * Pre: None
     * Parameters: None
     * Post: None
     * return: None
     */
    public void addWords()
    {
        Scanner in;
        try{
            // reads file
            in = new Scanner(new File("SpanishWords.txt"));
            while(in.hasNext())
            {
                words.add(in.nextLine());     
                count++;                      // counts each word
            } // ends the while loop

            // Iterator goes through the ArrayList
            System.out.println("\n\nIterator:");
            int temp = 0;
            Iterator <String> iterator = words.iterator();
            while(iterator.hasNext())
            {
                iterator.next();
                temp++;
            } // while iterator
            JLabel wordCount = new JLabel(Integer.toString(temp));
            System.out.println(temp + "!!");
            wordCount.setBounds(100, 40, 100, 50);
            frame.setVisible(true);
            countWords();
        } // ends the try statement
        catch(IOException i)
        {
            System.out.println("Error: " + i.getMessage());
        } // ends the catch statement
    } // ends the addWords method

    /**
     * method that gets the amount of words in the list
     * Pre: None
     * Parameters: None
     * Post: None
     * return: None
     */
    public void countWords()
    {
        System.out.println("\nThere are " + count + " words in the list!");
    } // ends the countWords method

    /**
     * method that checks if the specific letter is in the word
     * Pre: None
     * Parameters: letter
     * Post: None
     * return: true or false if letter is present
     */
    public boolean hasLetter(String letter)
    {
        // check to see if letter is inside of randWord
        String temp;
        for(int i = 0; i <= randWord.length()-1; i++)
        {
            temp = randWord.substring(i, i+1);
            if(temp.equals(letter))
            {
                System.out.println("Returns true ");
                return true;
            } // ends the if statement
        } // ends the for loop
        temp = randWord.substring(randWord.length()-1);
        if(temp.equals(letter))
        {
            System.out.println("Returns true ");
            return true;
        } // ends the if statement
        System.out.println("Returns false ");
        return false;
    } // ends the hasLetter method
} // ends the PlayHangman class
