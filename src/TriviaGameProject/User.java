package TriviaGameProject;

import java.util.Scanner;

public class User {
	
	private String userName = "";
	private int totalPoints = 0;
	static Scanner userInput = new Scanner(System.in);
	
	
	// Gets user's choice and calls 'performChoice' method to
		private static void getUserChoice() {

			System.out.println("Press 1 to play it again. \n" + "Press 3 to go main menu.");
			performChoice(userInput.nextInt());
		}

		static void performChoice(int choice) {

			switch (choice) {
			case 1:
				run();
				break;
			case 2:
				Main.main(null);
				// Start GameClass instance
				// loopCond = false;
				break;
			default:
				System.err.println("Wrong input. Try again!");
				break;
			}

		}
	
	

	public static void run() {
		System.out.println("User is open");
		
		if (QuestionDatabase.questionDatabase.isEmpty()){
			
			new QuestionDatabase("Q1", "ANS1", "Op11", "Op12", "Op13", "Op14");
			new QuestionDatabase("Q2", "ANS2", "Op21", "Op22", "Op23", "Op24");
			new QuestionDatabase("Q3", "ANS3", "Op31", "Op32", "Op33", "Op34");
			new QuestionDatabase("Q4", "ANS4", "Op41", "Op42", "Op43", "Op44");
			new QuestionDatabase("Q5", "ANS5", "Op51", "Op52", "Op53", "Op54");
			
		}

		
		
		TriviaGame.run();
		
		getUserChoice();
		
		

	}

}
