//Package name
package game;

/**********************************************************
 * Program Name   : HangmanPanel
 * Author         : Dimitar Gjorgievski
 * Date Revised   : September 28, 2021
 * Program Description: This program sets up the panels and labels
 * for players to play hangman.
 *
 *
 * Methods:
 * -------
 *  - Constructor            - Sets up appropriate panels and labels for hangman
 *  - Class: ButtonListener  - Class for button listeners to respond to commands
 *  - actionPerformed        - Listens for button presses in panels and responds accordingly
 *  - restart				 - Resets the game data to start a new game
 *  - enableAlphabet		 - Enables the alphabet buttons
 *  - disableAlphabet        - Disables the alphabet buttons
 *  - gameDesc               - Returns the game description as a string
 *
**********************************************************/
import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HangmanPanel extends JPanel
{
	//class constants
	private final int ALPHABET_LENGTH   = 26;
	private final int CURRENT_WORD_SIZE = 50;
	private final int TITLE_SIZE        = 20;
	private final int MAIN_MENU_X       = 100;
	private final int MAIN_MENU_Y       = 400;
	private final int GAME_MENU_DIM     = 1000;
	private final int GRID_Y            = 4;
	private final int GRID_X            = 8;
	private final int ALPHABET_PANEL_X  = 700;
	private final int ALPHABET_PANEL_Y  = 250;
	private final int GAMEPLAY_BUTTON_X = 350;
	private final int GAMEPLAY_BUTTON_Y = 40;
	private final int END_MESSAGE_SIZE  = 65;

	//class variables
	private JPanel mainMenu;			//Main menu panel. Displayed at start of game
	private JPanel gameMenu;			//Game menu panel. Displayed during gameplay
	private JPanel alphabetPanel;		//Panel containing all alphabet buttons
	private JLabel title;				//Label for hangman title
	private JLabel currentWord;			//The encrypted current word being guessed
	private JLabel endMessage;			//End message after player wins/loses
	private JLabel gallowsLabel;		//Label showing how much of hangman is hanged
	private JButton[] allLetters;		//Array of all alphabet letters as buttons
	private JButton newGame;			//Button to start a new game from main menu
	private JButton description;		//Button to view description from main menu
	private JButton quit;				//Button to quit game from main menu
	private JButton restartGame;		//Button to restart game during gameplay
	private JButton quitGame;			//Button to quit game during gameplay
	private JButton midDescription;		//Button to view description during gameplay
	private HangmanGame game;			//Hangman object with methods to play the game
	private AlphabetButtons alphabet;	//Alphabet object containing the alphabet as labels
	private Gallows currentGallows;		//Gallows object add body parts/reset the hangman

    /**********************************************************
    * Method Name    : Constructor
    * Author         : Dimitar Gjorgievski
    * Date Revised   : September 28, 2021
    * Program Description: The constructor sets up and adds all the
    * panels, labels, buttons, and listeners to run a game of hangman.
    *
    *
    * BEGIN Constructor
    *    Instantiate a hangman game object
    *    Instantiate main menu panel
    *    Instantiate game menu panel
    *    Instantiate alphabet panel
    *    Set up title label
    *    Set up new game button
    *    Set up quit button
    *    Set up description button
    *    Add components to main menu panel
    *    Set up current encrypted word to guess
    *    Instantiate a gallows object
    *    Set up gallows label to appropriate state
    *    Instantiate alphabet obj and retreive alphabet as buttons
    *    FOR(all the letters in the alphabet)
    *       Set up button listener for letter
    *       Add letter to alphabet panel
    *    END FOR
    *    Set up button to restart game
    *    Set up a button to see game desc mid game
    *    Set up button to quit during game
    *    Set up end message label when game is won/lost
    *    Add components to game menu panel
    *    Make game menu panel not visible
    *    Add both menu panels to hangman panel
    *    Set hangman panel size
 	* END Constructor
    **********************************************************/
	public HangmanPanel()
	{
		//local constants

		//local variables

		/******************** Start Constructor ***********************/

		//Instantiate a hangman game object
		game = new HangmanGame();

		//Instantiate main menu panel
		mainMenu = new JPanel();
		mainMenu.setPreferredSize(new Dimension(MAIN_MENU_X, MAIN_MENU_Y));

		//Instantiate game menu panel
		gameMenu = new JPanel();
		gameMenu.setBackground(Color.white);
		gameMenu.setPreferredSize(new Dimension(GAME_MENU_DIM, GAME_MENU_DIM));

		//Instantiate alphabet panel
		alphabetPanel  = new JPanel();
		alphabetPanel.setLayout(new GridLayout(GRID_Y, GRID_X));
		alphabetPanel.setPreferredSize(new Dimension(ALPHABET_PANEL_X, ALPHABET_PANEL_Y));

		//Set up title label
		title = new JLabel("Hangman");
		title.setFont(new Font("Calibri", Font.PLAIN, TITLE_SIZE));

		//Set up new game button
		newGame = new JButton("New Game");
		newGame.addActionListener(new ButtonListener());

		//Set up quit button
		quit = new JButton("Quit");
		quit.addActionListener(new ButtonListener());

		//Set up description button
		description = new JButton("Description");
		description.addActionListener(new ButtonListener());

		//Add components to main menu panel
		mainMenu.add(title);
		mainMenu.add(newGame);
		mainMenu.add(description);
		mainMenu.add(quit);

		//Set up current encrypted word to guess
		currentWord = new JLabel(game.encryptedToDisplay());
		currentWord.setFont(new Font("Calibri", Font.PLAIN, CURRENT_WORD_SIZE));

		//Instantiate a gallows object
		currentGallows = new Gallows();

		//Set up gallows label to appropriate state
		gallowsLabel = new JLabel();
		gallowsLabel.setIcon(currentGallows.getCurrentState());

		//Instantiate alphabet obj and retrieve alphabet as buttons
		alphabet = new AlphabetButtons();
		allLetters = alphabet.getAlphabet();

		//FOR(all the letters in the alphabet)
		for(int count = 0; count < ALPHABET_LENGTH; count++)
		{
			//Set up button listener for letter
			allLetters[count].addActionListener(new ButtonListener());

			//Add letter to alphabet panel
			alphabetPanel.add(allLetters[count]);

		}//END FOR

		//Set up button to restart game
		restartGame = new JButton("New Game");
		restartGame.setPreferredSize(new Dimension(GAMEPLAY_BUTTON_X, GAMEPLAY_BUTTON_Y));
		restartGame.addActionListener(new ButtonListener());

		//Set up a button to see game desc mid game
		midDescription = new JButton("Description");
		midDescription.setPreferredSize(new Dimension(GAMEPLAY_BUTTON_X, GAMEPLAY_BUTTON_Y));
		midDescription.addActionListener(new ButtonListener());

		//Set up button to quit during game
		quitGame = new JButton("Quit");
		quitGame.setPreferredSize(new Dimension(GAMEPLAY_BUTTON_X, GAMEPLAY_BUTTON_Y));
		quitGame.addActionListener(new ButtonListener());

		//Set up end message label when game is won/lost
		endMessage = new JLabel();
		endMessage.setFont(new Font("Calibri", Font.PLAIN, END_MESSAGE_SIZE));
		endMessage.setVisible(false);

		//Add components to game menu panel
		gameMenu.add(currentWord);
		gameMenu.add(gallowsLabel);
		gameMenu.add(endMessage);
		gameMenu.add(alphabetPanel);
		gameMenu.add(restartGame);
		gameMenu.add(midDescription);
		gameMenu.add(quitGame);

		//Make game menu not visible
		gameMenu.setVisible(false);

		//Add both menu panels to hangman panel
		add(gameMenu);
		add(mainMenu);

		//Set hangman panel size
		setPreferredSize(new Dimension(GAME_MENU_DIM, GAME_MENU_DIM));

	}//end Constructor

	/**********************************************************
	 * Class Name     : ButtonListener
	 * Author         : Dimitar Gjorgievski
	 * Date Revised   : September 28, 2021
	 * Program Description: Class listening for buttons being
	 * pressed at any part during hangman, with appropriate
	 * responses.
	 *
	 *
	 * Methods:
	 * -------
	 *  - actionPerformed - Responds to button presses accordingly
	 *
	**********************************************************/
	public class ButtonListener implements ActionListener
	{
		//local constants

		//local variables

		/**********************************************************
		* Method Name    : actionPerformed
		* Author         : Dimitar Gjorgievski
		* Date Revised   : September 28, 2021
		* Program Description: This method reacts a button being
		* pressed, and responds accordingly.
		*
		*
		* BEGIN actionPerformed
		*    IF(player decided to start new game)
		*       Make main menu not visible
		*       Make game menu visible
		*    END IF
		*    IF(Player decides to quit)
		*       Quit the frame altogether
		*    END IF
		*    IF(Player decides to view game description)
		*       Show game description
		*    END IF
		*    IF(Player decides to restart game)
		*       Call method to restart game
		*    END IF
		*    FOR(All the letters in the alphabet)
		*       IF(Player has clicked on an alphabet button
		*          Disable clicked letter
		*          Get guessed letter as a char
		*          IF(player has guessed a letter in the word)
		*             Update encrypted word
		*             IF(Game is won)
		*                Display win message
		*                Call method to disable alphabet buttons
		*             END IF
		*          ELSE
		*             Add body part to gallows panel
		*             IF(Game is lost)
		*                Display lost message
		*                Call method to disable alphabet buttons
		*                Show encrypted word
		*             END IF
		*          END IF
		*       END IF
		*    END FOR
		* END actionPerformed
		**********************************************************/
		public void actionPerformed(ActionEvent event)
		{
			//local constants

			//local variables
			String guessedLetter = "_";			//Letter player has guessed as string
			char guessedChar = '_';				//The guessed letter as a char

			/*************** Start actionPerformed *****************/

			//IF(player decided to start new game)
			if(event.getSource() == newGame)
			{
				//Make main menu not visible
				mainMenu.setVisible(false);

				//Make game menu visible
				gameMenu.setVisible(true);

			}//END IF

			//IF(Player decides to quit)
			if(event.getSource() == quit || event.getSource() == quitGame)

				//Quit the frame altogether
				System.exit(0);

			//END IF

			//IF(Player decides to view game description)
			if(event.getSource() == description || event.getSource() == midDescription)

				//Show game description
				JOptionPane.showMessageDialog(null, gameDesc());

			//END IF

			//IF(Player decides to restart game)
			if(event.getSource() == restartGame)

				//Call method to restart game
				restart();

			//END IF

			//FOR(All letters in the alphabet)
			for(int count = 0; count < ALPHABET_LENGTH; count++)
			{
				//IF(Player has clicked on an alphabet button)
				if(event.getSource() == allLetters[count])
				{
					//Disable clicked letter
					allLetters[count].setEnabled(false);
					allLetters[count].setBackground(Color.RED);

					//Get guessed letter as a char
					guessedLetter = allLetters[count].getText();
					guessedChar = guessedLetter.charAt(0);

					//IF(Player has guessed a letter in the word)
					if(game.guess(guessedChar))
					{
						//Update encrypted word
						currentWord.setText(game.encryptedToDisplay());


						allLetters[count].setBackground(Color.GREEN);

						//IF(Game is won)
						if(game.isGameWon())
						{
							//Display win message
							endMessage.setText("You've won!");
							endMessage.setVisible(true);

							//Call method to disable alphabet buttons
							disableAlphabet();

						}//END IF
					}
					//ELSE
					else
					{
						//Add body part to gallows panel
						currentGallows.updateCurrent();
						gallowsLabel.setIcon(currentGallows.getCurrentState());

						//IF(Game is lost)
						if(game.isGameLost())
						{
							//Display lost message
							endMessage.setText("You've lost...");
							endMessage.setVisible(true);

							//Call method to disable alphabet buttons
							disableAlphabet();

							//Show encrypted word
							game.decryptWord();
							currentWord.setText(game.encryptedToDisplay());

						}//END IF

					}//END IF

				}//END IF

			}//END FOR

		}//end actionPerformed

	}//end ButtonListener

    /**********************************************************
    * Method Name    : restart
    * Author         : Dimitar Gjorgievski
    * Date Revised   : September 28, 2021
    * Program Description: This method sets up a new game of
    * hangman after the previous one has finished, resetting
    * all the necessary variables.
 	*
    *
    * BEGIN restart
    *    Reset game values
    *    Set current word panel to new word
    *    Remove end message
    *    Reset gallows state and panel
    *    Enable alphabet buttons
    * END restart
    **********************************************************/
	public void restart()
	{
		//local constants

		//local variables

		/******************** Start restart *****************/

		//Reset game values
		game.resetGame();

		//Set current word panel to new word
		currentWord.setText(game.encryptedToDisplay());
		currentWord.setFont(new Font("Calibri", Font.PLAIN, CURRENT_WORD_SIZE));

		//Remove end message
		endMessage.setVisible(false);

		//Reset gallows state and panel
		currentGallows.resetGallows();
		gallowsLabel.setIcon(currentGallows.getCurrentState());

		//Enable alphabet buttons
		enableAlphabet();

	}//end restart

    /**********************************************************
    * Method Name    : enableAlphabet
    * Author         : Dimitar Gjorgievski
    * Date Revised   : September 28, 2021
    * Program Description: This method enables all of the
    * buttons from the alphabet, setting them up for a new game
 	*
    *
    * BEGIN enableAlphabet
    *    FOR(all the letters in the alphabet)
    *       Enable button at letter
    *    END FOR
    * END enableAlphabet
    **********************************************************/
	public void enableAlphabet()
	{
		//local constants

		//local variables

		/******************** Start enableAlphabet *****************/

		//FOR(all the letters in the alphabet)
		for(int count = 0; count < ALPHABET_LENGTH; count++)
		{
			//Enable button at letter
			allLetters[count].setBackground(null);
			allLetters[count].setEnabled(true);

		}//END FOR

	}//end enableAlphabet

    /**********************************************************
    * Method Name    : disableAlphabet
    * Author         : Dimitar Gjorgievski
    * Date Revised   : September 28, 2021
    * Program Description: This method disables all of the
    * buttons from the alphabet.
 	*
    *
    * BEGIN disableAlphabet
    *    FOR(all the letters in the alphabet)
    *       Disable button at letter
    *    END FOR
    * END disableAlphabet
    **********************************************************/
	public void disableAlphabet()
	{
		//local constants

		//local variables

		/******************** Start disableAlphabet *****************/

		//FOR(all the letters in the alphabet)
		for(int count = 0; count < ALPHABET_LENGTH; count++)
		{
			//Disable button at letter
			allLetters[count].setBackground(Color.RED);
			allLetters[count].setEnabled(false);

		}//END FOR

	}//end disableAlphabet

    /**********************************************************
    * Method Name    : gameDesc
    * Author         : Dimitar Gjorgievski
    * Date Revised   : September 28, 2021
    * Program Description: This method returns the game description
    * of hangman as a single string.
 	*
    *
    * BEGIN gameDesc
    *    Add game desc to output
    *    Return game description
    * END
    **********************************************************/
	public static String gameDesc()
	{
		//local constants

		//local variables
		String desc;			//Game description, to be returned

		/******************** Start gameDesc *****************/

		//Add game desc to output
		desc = "Hangman is a guessing game in which a random hidden word is"     + "\n" +
		       "selected from a list, showing only the number of letters"   	 + "\n" +
		       "it consists of. An empty gallows for a hangman to be hanged is"  + "\n" +
		       "displayed. The player uncovers the word by clicking on letters," + "\n" +
		       "but has only six tries until the hangman is hanged which"  		 + "\n" +
		       "would make the player lose the game. Clicking Play Again"    	 + "\n" +
		       "restars the game and starts a new game with a new word."         + "\n" +
		       "Quit exits the game altogether.";

		//Return game description
		return desc;

	}//end gameDesc

}//end HangmanPanel