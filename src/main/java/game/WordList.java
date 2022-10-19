//Package name
package game;

/**********************************************************
 * Program Name   : WordList
 * Author         : Dimitar Gjorgievski
 * Date Revised   : September 14, 2021
 * Program Description: This program creates an array of Strings
 * and populates it with words used to be decrypted in hangman.
 *
 *
 * Methods:
 * -------
 *  - Constructor   - Populates a list of Strings with words for hangman
 *  - getRandomWord - Returns a random word from the array of Strings
 *
**********************************************************/
import java.util.Random;

public class WordList
{
	//local constants
	private final int NUM_WORDS = 40;

	//local variables
	private String[] words;					//List of words randomly selected for hangman

    /**********************************************************
    * Method Name    : Constructor
    * Author         : Dimitar Gjorgievski
    * Date Revised   : September 14, 2021
    * Program Description: The constructor fills the array with
    * words to be guessed in hangman.
 	*
    *
    * BEGIN Constructor
    *    Instantiate a temp array with words
    *    Populate word array with words from temp array
    * END Constructor
    **********************************************************/
	public WordList()
	{
		//local constants

		//local variables
		String[] tempWords = {"Avenue", "Awkward", "Building", "Business", "Challenge", "Customer",
							  "Development", "Doctor", "Economy", "Evolution", "Future",
							  "Follower", "Generation", "Germany", "Hospital", "Hawaii", "Individual",
							  "India", "Justice", "Jordan", "Knowledge", "Keys", "Language", "Laughter",
							  "Manager", "Message", "Majority", "Nationalist", "Newspaper", "Organize",
							  "Participant", "Relatives", "Scientist", "Technology", "Tradition",
					  		  "Unionize", "Wealth", "Window", "Young", "Zombie"};

		/****************** Start Constructor ********************/

		//Populate word array with words from temp array
		words = tempWords;

	}//end Constructor

    /**********************************************************
    * Method Name    : getRandomWord
    * Author         : Dimitar Gjorgievski
    * Date Revised   : September 14, 2021
    * Program Description: This method returns a random word from
    * the array of words
 	*
    *
    * BEGIN methodName
    *    Get a random number from 0 to num words in word array
    *    Return a random word from the word array
    * END methodName
    **********************************************************/
	public String getRandomWord()
	{
		//local constants

		//local variables
		Random obj = new Random();		//Random object that will select a random word
		int randomInt;					//A random number from 0 to num words in word array

		/**************** Start getRandomWord *******************/

		//Get a random number from 0 to num words in word array
		randomInt = obj.nextInt(NUM_WORDS);

		//Return a random word from the word array
		return words[randomInt];

	} //end getRandomWord

} //end WordList
