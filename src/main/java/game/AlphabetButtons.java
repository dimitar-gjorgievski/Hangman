//Package name
package game;

/**********************************************************
 * Program Name   : AlphabetButtons
 * Author         : Dimitar Gjorgievski
 * Date Revised   : September 15, 2021
 * Program Description: This class adds all the letters of
 * the alphabet as buttons to an array.
 *
 *
 * Methods:
 * -------
 *  - Constructor - creates an array of letters as buttons
 *  - getAlphabet - returns the list of alphabet buttons
 *
**********************************************************/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AlphabetButtons
{
	// local constants
	private final int ALPHABET_SIZE = 26;

	// local variables
	private JButton[] alphabet;		//All of the letters as JButtons

	/**********************************************************
	 * Method Name    : Constructor
	 * Author 		  : Dimitar Gjorgievski
	 * Date Revised   : September 15, 2021
	 * Program Description: The constructor creates all the letters
	 * as buttons and adds them to an array.
	 *
	 *
	 * BEGIN Constructor
	 * Instantiate the alphabet as a list of buttons
	 * FOR(all the letters in the alphabet)
	 * Add the letter to the list of buttons
	 * END FOR
	 * END Constructor
	 **********************************************************/
	public AlphabetButtons()
	{
		// local constants
		final char FIRST_LETTER = 'A';
		final char LAST_LETTER = 'Z';

		// local variables
		int count = 0;		//Counter that goes through the entire alphabet

		/******************** Start Constructor *****************/

		// Instantiate the alphabet as a list of buttons
		alphabet = new JButton[ALPHABET_SIZE];

		// FOR(all the letters in the alphabet)
		for (char currLetter = FIRST_LETTER; currLetter <= LAST_LETTER; currLetter++, count++)

			// Add the letter to the list of buttons
			alphabet[count] = new JButton(currLetter + "");

		// END FOR

	} // end Constructor

	/**********************************************************
	 * Method Name    : getAlphabet
	 * Author 		  : Dimitar Gjorgievski
	 * Date Revised   : September 15, 2021
	 * Program Description: This method returns the full alphabet
	 * as an array of Jbuttons.
	 *
	 *
	 * BEGIN getAlphabet
	 * Return the button alphabet
	 * END getAlphabet
	 **********************************************************/
	public JButton[] getAlphabet()
	{
		// local constants

		// local variables

		/******************** Start getAlphabet *****************/

		// Return the button alphabet
		return alphabet;

	} // end getAlphabet

} // end AlphabetButtons