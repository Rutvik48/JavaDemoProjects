package TriviaGameProject;

import java.util.Scanner;

public class Main {

	//private int userInput = -1;
	static Scanner input = new Scanner(System.in);

	// Gets user's choice and calls 'performChoice' method to
	private void getUserChoice() {

		System.out.println("\n\n\nPress 1 for Admin. \n" + "Press 2 for User.");
		performChoice();
	}

	void performChoice() {
		
		switch (input.nextInt()) {
		case 1:
			Admin.run();
			break;
		case 2:
			User.run();
			// Start GameClass instance
			// loopCond = false;
			break;
		default:
			System.out.println("****Wrong input. Try again!****");
			getUserChoice();
			break;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Main main = new Main();
		
		main.getUserChoice();
		input.close();
		System.exit(0);
	}

}
