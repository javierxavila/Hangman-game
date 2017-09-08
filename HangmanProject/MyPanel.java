/**
 * Gui. This class sets up the panel in the game where the man getting hanged is set.
 * 
 * 
 * 4/24/17
 */
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;
class MyPanel extends JPanel 
{
    // initializes badGuessess to zero 
    int badGuesses = 0;
    /**
     * This is the constructor which sets the border for the panel
     * Pre: None
     * Parameters: None
     * Post: None
     * return: None
     */
    public MyPanel() 
    {
        setBorder(BorderFactory.createLineBorder(Color.black));
    } // ends the myPanel constructor

    /**
     * method that gets my preferred size of the panel dimension
     * Pre: None
     * Parameters: None
     * Post: None
     * return: The dimension of the panel
     */
    public Dimension getPreferredSize() 
    {
        return new Dimension(1200,1000);
    } // ends the getPreferredSize method

    /**
     * method that add to badGuesses everytime it is called
     * Pre: None
     * Parameters: None
     * Post: None
     * return: None
     */
    public void addBadGuess()
    {
        badGuesses++;
    } // ends the addBadGuess method

    /**
     * method that returns badGuesses
     * Pre: None
     * Parameters: None
     * Post: None
     * return: The badGuesses in the game that is shown
     */
    public int getBadGuess()
    {
        return badGuesses;
    } // ends the getBadGuess method

    /**
     * method that resets the badGuess integer in the program
     * Pre: None
     * Parameters: None
     * Post: None
     * return: None
     */
    public void resetBadGuess()
    {
        badGuesses = 0;
    } // ends the resetBadGuess method

    /**
     * method that is used to call the repaint method
     * Pre: None
     * Parameters: None
     * Post: None
     * return: None
     */
    public void redraw()
    {
        repaint(); //  It controls and updates the paint cycle. 
    } // ends the redraw method

    /**
     * method that creates the frame for paintcomponent
     * Pre: None
     * Parameters: graphics g
     * Post: None
     * return: None
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);   

        switch(badGuesses)
        {
            case 0: // no case 

            break; 

            case 1:
            // draw head
            g.setColor(Color.RED);
            g.drawOval(250, 20, 100, 100);
            g.fillOval(250, 20, 100, 100);
            g.setColor(Color.BLUE);

            break;

            case 2: 
            // draw head
            g.setColor(Color.RED);
            g.drawOval(250, 20, 100, 100);
            g.fillOval(250, 20, 100, 100);
            g.setColor(Color.BLUE);
            // draw body-line
            g.drawLine(300, 70, 300, 300);

            break;

            case 3:
            // draw head
            g.setColor(Color.RED);
            g.drawOval(250, 20, 100, 100);
            g.fillOval(250, 20, 100, 100);
            g.setColor(Color.BLUE);
            // draw body-line
            g.drawLine(300, 70, 300, 300);
            // left arm
            g.drawLine(300, 150, 100, 120);

            break;

            case 4:
            // draw head
            g.setColor(Color.RED);
            g.drawOval(250, 20, 100, 100);
            g.fillOval(250, 20, 100, 100);
            g.setColor(Color.BLUE);
            // draw body-line
            g.drawLine(300, 70, 300, 300);
            // left arm
            g.drawLine(300, 150, 100, 120);
            // right arm
            g.drawLine(300, 150, 500, 120);

            break;

            case 5:
            // draw head
            g.setColor(Color.RED);
            g.drawOval(250, 20, 100, 100);
            g.fillOval(250, 20, 100, 100);
            g.setColor(Color.BLUE);
            // draw body-line
            g.drawLine(300, 70, 300, 300);
            // left arm
            g.drawLine(300, 150, 100, 120);
            // right arm
            g.drawLine(300, 150, 500, 120);
            // left foot 
            g.drawLine(300, 300, -1000, 700);

            break;

            case 6:
            // draw head
            g.setColor(Color.RED);
            g.drawOval(250, 20, 100, 100);
            g.fillOval(250, 20, 100, 100);
            g.setColor(Color.BLUE);
            // draw body-line
            g.drawLine(300, 70, 300, 300);
            // left arm
            g.drawLine(300, 150, 100, 120);
            // right arm
            g.drawLine(300, 150, 500, 120);
            // left foot 
            g.drawLine(300, 300, -1000, 700);
            // right foot
            g.drawLine(300, 300, 2000, 800);

            JOptionPane.showMessageDialog(null, "You Lose! PLayer is dead :( ", "Frame", JOptionPane.INFORMATION_MESSAGE);
            break;

            default:
            // draw head
            g.setColor(Color.RED);
            g.drawOval(250, 20, 100, 100);
            g.fillOval(250, 20, 100, 100);
            g.setColor(Color.BLUE);
            // draw body-line
            g.drawLine(300, 70, 300, 300);
            // left arm
            g.drawLine(300, 150, 100, 120);
            // right arm
            g.drawLine(300, 150, 500, 120);
            // left foot 
            g.drawLine(300, 300, -1000, 700);
            // right foot
            g.drawLine(300, 300, 2000, 800);

            JOptionPane.showMessageDialog(null, "You Lose! PLayer is dead :( ", "Frame", JOptionPane.INFORMATION_MESSAGE);
        } // ends case-switch statement
        repaint(); //  It controls and updates the paint cycle. 
    }  // ends paintComponent method
} // ends myPanel class