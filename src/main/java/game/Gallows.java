//Package name
package game;

/**********************************************************
 * Program Name   : Gallows
 * Author         : Dimitar Gjorgievski
 * Date Revised   : September 15, 2021
 * Program Description: This program draws the hangman being hanged
 * step by step through image icons and JLabels.
 *
 *
 * Methods:
 * -------
 *  - Constructor      - Insantiates and adds hangman parts to array
 *  - getCurrentState  - Returns the current state of hangman/gallows
 *  - updateCurrent    - Updates current state of gallows/adds body part
 *  - resetGallows     - Resets the gallows to empty
 *
**********************************************************/
import javax.swing.*;

public class Gallows
{
	//local constants
	final int GALLOWS_BLANK = 0;

	//local variables
	private ImageIcon emptyGallows;		//Image for empty gallows
	private ImageIcon head;				//Hangman's head
	private ImageIcon torso;			//Added torso to hangman
	private ImageIcon leftArm;			//Added arm to hangman
	private ImageIcon rightArm;			//Added right arm to hangman
	private ImageIcon leftLeg;			//Added left leg to hangman
	private ImageIcon rightLeg;			//Added right leg to hangman
	private int current;				//Current state of gallows/current body part
	private ImageIcon[] gallows;		//Array with all hangman states

    /**********************************************************
    * Method Name    : Constructor
    * Author         : Dimitar Gjorgievski
    * Date Revised   : September 15, 2021
    * Program Description: This method instantiates & adds all hangman
    * parts to an array of icons.
    *
    *
    * BEGIN Constructor
    *    Instantiate parts as icons w/ appropriate names
    *    Instantiate gallows array
    *	 Set current state to beggining
    *    Add all parts to gallows array
    * END Constructor
    **********************************************************/
	public Gallows()
	{
		//local constants
		final int NUM_HANGMAN_STATES = 7;

		//local variables

		/******************** Start Constructor *****************/

		//Instantiate parts as icons w/ appropriate images
		emptyGallows = new ImageIcon("src/main/java/images/emptyGallows(0).jpg");
		head = new ImageIcon("src/main/java/images/head(1).jpg");
		torso = new ImageIcon("src/main/java/images/torso(2).jpg");
		leftArm = new ImageIcon("src/main/java/images/leftArm(3).jpg");
		rightArm = new ImageIcon("src/main/java/images/rightArm(4).jpg");
		leftLeg = new ImageIcon("src/main/java/images/leftLeg(5).jpg");
		rightLeg = new ImageIcon("src/main/java/images/rightLeg(6).jpg");

		//Instantiate gallows array
		gallows = new ImageIcon[NUM_HANGMAN_STATES];

		//Set current state to beggining
		current = GALLOWS_BLANK;

		//Add all parts to gallows array
		gallows[0] = emptyGallows;
		gallows[1] = head;
		gallows[2] = torso;
		gallows[3] = leftArm;
		gallows[4] = rightArm;
		gallows[5] = leftLeg;
		gallows[6] = rightLeg;

	} //end Constructor

    /**********************************************************
    * Method Name    : getCurrentState
    * Author         : Dimitar Gjorgievski
    * Date Revised   : September 15, 2021
    * Program Description: Returns the gallows with the current
    * hangman state.
 	*
    *
    * BEGIN getCurrentState
    *    Return gallows' current state
    * END getCurrentState
    **********************************************************/
	public ImageIcon getCurrentState()
	{
		//local constants

		//local variables

		/******************** Start getCurrentState *****************/

		//Return gallows' current state
		return gallows[current];

	} //end getCurrentState

    /**********************************************************
    * Method Name    : updateCurrent
    * Author         : Dimitar Gjorgievski
    * Date Revised   : September 15, 2021
    * Program Description: This method updates the current state of
    * the gallows.
 	*
    *
    * BEGIN updateCurrent
    *    Update current state
    * END updateCurrent
    **********************************************************/
	public void updateCurrent()
	{
		//local constants

		//local variables

		/******************** Start updateCurrent *****************/

		//Update current state
		current++;

	} //end updateCurrent

    /**********************************************************
    * Method Name    : resetGallows
    * Author         : Dimitar Gjorgievski
    * Date Revised   : September 15, 2021
    * Program Description: This method resets the gallows to its
    * original blank state.
 	*
    *
    * BEGIN resetGallows
    *    Reset gallows to start
    * END resetGallows
    **********************************************************/
	public void resetGallows()
	{
		//local constants
		final int GALLOWS_BLANK = 0;

		//local variables

		/******************** Start resetGallows *****************/

		//Reset gallows to start
		current = GALLOWS_BLANK;

	} //end resetGallows

} //end Gallows