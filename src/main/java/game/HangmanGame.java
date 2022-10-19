//Package name
package game;

/**********************************************************
 * Program Name   : HangmanGame
 * Author         : Dimitar Gjorgievski
 * Date Revised   : September 22, 2021
 * Program Description: This program represents a single
 * hangman game, guessing one encrypted word.
 *
 *
 * Methods:
 * -------
 *  - Constructor        - Initializes instance data to begin a game
 *  - encryptWord        - Hides current word drawn at random for player to guess
 *  - encryptedToDisplay - Turns the encrypted word into a String for display
 *  - guess              - Guesses if letter at parameter is in the word, returns true if it is
 *  - isGameWon          - Checks if the player has guessed all letters of the word
 *  - isGameLost         - Checks if the player has used up all of their allowed mistakes
 *  - resetGame          - Resets the instance data so that a new game can begin
 *  - decryptWord        - Decrypts the hidden word for display after player has lost
 *
**********************************************************/
public class HangmanGame
{
	//local constants
	private final int MAX_WRONG_GUESSES = 6;
	private final char ENCRYPTED_LETTER = '_';

	//local variables
	private WordList randomWords;		//Variable used to draw random words from a list
	private int numWrongGuesses;		//Num of times the player has guessed a wrong letter
	private String currWord;			//The current word to be encrypted
	private char[] encryptedWord;		//The current word in its current encrypted form

    /**********************************************************
    * Method Name    : Constructor
    * Author         : Dimitar Gjorgievski
    * Date Revised   : September 22, 2021
    * Program Description: The constructor initializes data
    * in order to begin a game of hangman.
 	*
    *
    * BEGIN Constructor
    *    Instantiate a word list object
    *    Initialize instance data
    * END Constructor
    **********************************************************/
	public HangmanGame()
	{
		//local constants

		//local variables

		/******************** Start Constructor *****************/

		//Instantiate a word list object
		randomWords = new WordList();

		//Initialize instance data
		numWrongGuesses   = 0;
		currWord          = randomWords.getRandomWord();
		currWord          = currWord.toUpperCase();
		encryptedWord     = encryptWord(currWord);

	} //end Constructor

    /**********************************************************
    * Method Name    : encryptWord
    * Author         : Dimitar Gjorgievski
    * Date Revised   : September 22, 2021
    * Program Description: This method encrypts the current word
    * that has been drawn for the player to guess during hangman.
 	*
    *
    * BEGIN encryptWord
    *    Calculate the length of the encrypted word
    *    Make array for each encrypted letter
    *    FOR(the length of the encrypted word)
    *       IF(index is 0 or even)
    *          Add underscore to encrypted word
    *       ELSE
    *          Add blank space to encrypted word
    *       END IF
    *    END FOR
    *    Returned encrypted word as array
    * END encryptWord
    **********************************************************/
	public char[] encryptWord(String word)
	{
		//local constants

		//local variables
		int encryptedWordLength;		//How big the encrypted word array is
		char[] encrypted;				//The encrypted word for player to guess

		/******************** Start encryptWord *****************/

		//Calculate the length of the encrypted word
		encryptedWordLength = (word.length() * 2) - 1;

		//Make array for each encrypted letter
		encrypted = new char[encryptedWordLength];

		//FOR(the length of the encrypted word)
		for(int count = 0; count < encryptedWordLength; count++)
		{
			//IF(index is 0 or even)
			if(count == 0 || count % 2 == 0)

				//Encrypt letter
				encrypted[count] = ENCRYPTED_LETTER;

			//ELSE
			else

				//Add blank space to encrypted word
				encrypted[count] = ' ';

			//END IF

		}//END FOR

		//Returned encrypted word as array
		return encrypted;

	} //end encryptWord

    /**********************************************************
    * Method Name    : encryptedToDisplay
    * Author         : Dimitar Gjorgievski
    * Date Revised   : September 22, 2021
    * Program Description: This method turns the encrypted word
    * array into a String for display
 	*
    *
    * BEGIN encryptedToDisplay
    *    FOR(the length of the encrypted word)
    *       Add Letter to string variable
    *    END FOR
    *    Return encrypted word as a string variable
    * END encryptedToDisplay
    **********************************************************/
	public String encryptedToDisplay()
	{
		//local constants

		//local variables
		String displayedWord = "";		//The encrypted word as a string

		/******************** Start encryptedToDisplay *****************/

		//FOR(the length of the encrypted word)
		for(int count = 0; count < encryptedWord.length; count++)

			//Add letter to string variable
			displayedWord += encryptedWord[count];

		//END FOR

		//Return encrypted word as a string variable
		return displayedWord;

	} //end encryptedToDisplay

    /**********************************************************
    * Method Name    : guess
    * Author         : Dimitar Gjorgievski
    * Date Revised   : September 22, 2021
    * Program Description: This method checks if the letter
    * at parameter is included in the current word and updates
    * the encrypted word if it is.
 	*
    *
    * BEGIN guess
    *    Set guessed letter to uppercase
    *    IF(letter is included in the word)
    *       FOR(all the letters in the word)
    *          IF(the current letter is the guessed letter
    *             Increment num of correct guesses
    *             Add leter to encrypted word
    *             Set output to true
    *          END IF
    *       END FOR
    *    ELSE
    *       Increment number of wrong guesses
    *    END IF
    *    Return output
    * END guess
    **********************************************************/
	public boolean guess(char letter)
	{
		//local constants
		final int INCORRECT_LETTER = -1;

		//local variables
		boolean output = false;			//Returns true if letter is included in the word

		/******************** Start guess *****************/

		//Set guessed letter to uppercase
		letter = Character.toUpperCase(letter);

		//IF(letter is included in the word)
		if(currWord.indexOf(letter) != INCORRECT_LETTER)
		{
			//FOR(all the letters in the word)
			for(int count = 0; count < currWord.length(); count++)
			{
				//IF(the current letter is the guessed letter
				if(currWord.charAt(count) == letter)
				{
					//Add letter to encrypted word
					encryptedWord[count * 2] = letter;

					//Set output to true
					output = true;

				}//END IF

			}//END FOR
		}
		//ELSE
		else

			//Increment num of wrong guesses
			numWrongGuesses++;

		//END IF

		//Return output
		return output;

	} //end guess

    /**********************************************************
    * Method Name    : isGameWon
    * Author         : Dimitar Gjorgievski
    * Date Revised   : September 22, 2021
    * Program Description: This method checks to see if the
    * current hangman game is won.
 	*
    *
    * BEGIN isGameWon
    *    FOR(the length of the encrypted word)
    *       IF(the character has not been decrypted)
    *          Set output to false
    *       END IF
    *    END FOR
         Return output
    * END isGameWon
    **********************************************************/
	public boolean isGameWon()
	{
		//local constants

		//local variables
		boolean output = true;				//Returns true if the game is won

		/******************** Start isGameWon *****************/

		//FOR(the length of the encrypted word)
		for(int count = 0; count < encryptedWord.length; count++)
		{
			//IF(the character has not been decrypted)
			if(encryptedWord[count] == ENCRYPTED_LETTER)

				//Set output to false
				output = false;

			//END IF

		}//END FOR

		//Return output
		return output;

	} //end isGameWon

    /**********************************************************
    * Method Name    : isGameLost
    * Author         : Dimitar Gjorgievski
    * Date Revised   : September 22, 2021
    * Program Description: This method checks to see if the
    * current hangman game is won.
 	*
    *
    * BEGIN isGameLost
    *    IF(num of wrong guesses has exceeded limit)
    *       Set output to true
    *    END IF
    *    Return  output
    * END isGameLost
    **********************************************************/
	public boolean isGameLost()
	{
		//local constants

		//local variables
		boolean output = false;				//Returns true if game is lost

		/******************** Start isGameLost *****************/

			//IF(num of wrong gueses has exceeded limit)
			if(numWrongGuesses == MAX_WRONG_GUESSES)

				//Set output to true
				output = true;

			//END IF

		//Return output
		return output;

	} //end isGameLost

    /**********************************************************
    * Method Name    : resetGame
    * Author         : Dimitar Gjorgievski
    * Date Revised   : September 22, 2021
    * Program Description: This method resets the game and
    * sets up the variables to be ready for the next game of
    * hangman.
 	*
    *
    * BEGIN resetGame
    *    Reset instance data
    *    Get new random word
    *    Encrypt new word
    * END resetGame
    **********************************************************/
	public void resetGame()
	{
		//local constants

		//local variables

		/******************** Start resetGame *****************/

		//Reset instance data
		numWrongGuesses   = 0;

		//Get new random word
		currWord = randomWords.getRandomWord();
		currWord = currWord.toUpperCase();

		//Encrypt new word
		encryptedWord = encryptWord(currWord);

	}//end resetGame

    /**********************************************************
    * Method Name    : decryptWord
    * Author         : Dimitar Gjorgievski
    * Date Revised   : September 22, 2021
    * Program Description: This method decrypts the word
    * that was encrypted after the hangman game has been lost.
 	*
    *
    * BEGIN decryptWord
    *    FOR(all the letters in the current word)
    *       Set letter to encryted word index
    *    END FOR
    * END decryptWord
    **********************************************************/
	public void decryptWord()
	{
		//local constants

		//local variables

		/******************** Start decryptWord *****************/

		//FOR(all the letters in the current word)
		for(int count = 0; count < currWord.length(); count++)
		{
			//Set letter to encrypted word index
			encryptedWord[count * 2] = currWord.charAt(count);

		}//END FOR

	}//end decryptWord

} //end HangmanGame