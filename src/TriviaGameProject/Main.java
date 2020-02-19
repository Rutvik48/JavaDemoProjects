package TriviaGameProject;

import java.util.Scanner;

public class Main {

	private int userInput = -1;
	static Scanner input = new Scanner(System.in);

	// Gets user's choice and calls 'performChoice' method to
	private void getUserChoice() {

		System.out.println("Press 1 for Admin. \n" + "Press 2 for User.");
		performChoice(input.nextInt());
	}

	void performChoice(int choice) {

		switch (choice) {
		case 1:
			Admin.run();
			break;
		case 2:
			// Start GameClass instance
			// loopCond = false;
			break;
		default:
			System.err.println("Wrong input. Try again!");
			break;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Main main = new Main();
		
		main.getUserChoice();
		input.close();
	}

}
