//Package name
package game;

/**********************************************************
 * Program Name   : HangmanMain
 * Author         : Dimitar Gjorgievski
 * Date Revised   : September 24, 2021
 * Program Description: Allows user to run a frame
 * with appropriate hangman panels to play the game hangman.
 *
 *
**********************************************************/
import javax.swing.JFrame;

public class HangmanMain
{
    /**********************************************************
    * Method Name    : main
    * Author         : Dimitar Gjorgievski
    * Date Revised   : September 24, 2021
    * Program Description: Adds main hangman panel to the frame
    * and sets frame visible to play the game hangman.
 	*
    *
    * BEGIN main
    *    Create title for frame
    *    Add panel to frame
    *    Make frame visible
    * END main
    **********************************************************/
	public static void main(String[] args)
	{
		//local constants

		//local variables
		JFrame frame;			//Frame in which hangman panel is added

		/******************** Start main ***********************/

		//Create title for frame
		frame = new JFrame("Hangman");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Add panel to frame
		frame.getContentPane().add(new HangmanPanel());

		//Make frame visible
		frame.pack();
		frame.setVisible(true);

	}//end main

}//end HangmanMain
