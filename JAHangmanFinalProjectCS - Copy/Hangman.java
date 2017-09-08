/**
 * Interface is implemented to the rest of the program
 * 
 * 5/10/17
 */
public interface Hangman
{
    /**
     * method that is constucted for another class. starts the game up
     * Pre: None
     * Parameters: None
     * Post: None
     * return: None 
     */
    public void startGame();

    /**
     *  method that sets the word into strings of "_" (replace)
     * Pre: None
     * Parameters: None
     * Post: None
     * return: None
     */
    public void setWord(); 

    /**
     * method that draws the letter at the "_" for each index depending on the where the letter was found
     * Pre: None
     * Parameters: None
     * Post: None
     * return: None
     */
    public String drawWord();

    /**
     * method that sets the letter in the spot where the letter is found
     * Pre: None
     * Parameters: None
     * Post: None
     * return: None
     */
    public void updateWord(String letter);

    /**
     * method that is constucted for another class. gets the randomWord from the list
     * Pre: None
     * Parameters: None
     * Post: None
     * return: None
     */
    public String getWord();

    /**
     * method that is constucted for another class. adds words to the ArrayList
     * Pre: None
     * Parameters: None
     * Post: None
     * return: None 
     */
    public void addWords();

    /**
     * method that checks if the specific letter is in the word
     * Pre: None
     * Parameters: None
     * Post: None
     * return: None
     */
    public boolean hasLetter(String letter);
} // ends interface
