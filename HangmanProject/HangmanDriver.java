/**
 * Allows for game to be played
 * 
 * 5/10/17
 */
public class HangmanDriver 
{
    /**
     * This is the main method which makes use of Hangman interface
     * Pre: None
     * Parameters: None
     * Post: None
     * return: None
     */
    public static void main(String args[])
    { 
        Hangman play = new PlayHangman();
        play.startGame();
    } // ends the main method
} // HangmanDriver class
