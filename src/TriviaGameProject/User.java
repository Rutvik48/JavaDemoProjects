package TriviaGameProject;

import java.util.Scanner;

public class User {

	// Creating a new instance of a user and Trivia Game
	User curUser = this;
	TriviaGame game = new TriviaGame(curUser);

	// private String userName = "";
	public boolean didUserPlay = false;
	public User currentUser;
	Scanner userInput = new Scanner(System.in);
	
	User(){
		curUser = this;
		
	}

	// Gets user's choice and calls 'performChoice' method to
	private void getUserChoice() {

		System.out.println("\n\n\n\nPress 1 to play it again. \n" + "Press 3 to go main menu.");
		performChoice(userInput.nextInt());
	}

	void performChoice(int choice) {

		switch (choice) {
		case 1:
			// Playing the game again
			game.startGame();
			break;
		case 2:

			// Going to main menu.
			Main.main(null);
			// Start GameClass instance
			// loopCond = false;
			break;
		default:
			System.err.println("Wrong input. Try again!");
			break;
		}
	}

	private void checkIfWantToPlayAgain() {

		try {
			getUserChoice();
		} catch (Exception e) {
			System.out.println("Some unexpected error has occured. Restarting the game...");
			playGame();
		} finally {
			checkIfWantToPlayAgain();
		}
	}

	public void playGame() {

		// Running the game
		game.run();

		// 'didUserPlay' will be true if there are questions in the QuestionDatabase
		// text file.
		if (curUser.didUserPlay) {
			// Show and reset score
			System.out.println("****************************************************************************\n\n"
					+ "Thank You for playing.\n" + "Your score is: " + game.curPoints +
					"\n\n****************************************************************************");
		}

		// Asking user if he/she wants to play the game again
		checkIfWantToPlayAgain();

	}

}
