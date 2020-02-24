package TriviaGameProject;

import java.util.Scanner;

public class Admin {


	private String question = "";
	private String ans = "";
	private String op1 = "";
	private String op2 = "";
	private String op3 = "";
	private String op4 = "";
	static Scanner input = new Scanner(System.in);
	private static boolean loopCond = true;
	
	
	//Gets user's choice and calls 'performChoice' method to  
	private void getUserChoice() {
		
		System.out.println("Press 1 to add more question. \n"
				+ "Press 3 to go to main sccreen.");
		performChoice(input.nextInt());
	}
	
	private void performChoice(int choice) {
		
		switch (choice) {
		case 1:
			addQuestion();
			break;
		case 3:
			//Start GameClass instance
			loopCond = false;
			Main.main(null);
			break;
		default:
			System.err.println("Wrong input. Try again!");
			break;
		}
		
	}
	
	private void getQuestion() {
		
		System.out.println("Enter Question: ");
		question = input.next();
		
		getAns();
	}

	private void getAns() {
		
		System.out.println("Enter Ans: ");
		ans = input.next();
		
		getOp1();
	}
	
	private void getOp1() {
		
		System.out.println("Enter option 1.");
		op1 = input.next();
		
		getOp2();
	}
	
	private void getOp2() {
		
		System.out.println("Enter option 2.");
		op2 = input.next();
		getOp3();
	}
	
	private void getOp3() {
		
		System.out.println("Enter option 3.");
		op3 = input.next();
		
		getOp4();
	}
	
	private void getOp4() {
		
		System.out.println("Enter option 4.");
		op4 = input.next();
	}
	
	//This method gets reuired data.
	private void addQuestion() {
		
		//This method will get required information and set it to global variable of this 'Admin' class
		getQuestion();
		
		//Adding new question set in the QuestionDatabase
		QuestionDatabase dbRef = new QuestionDatabase(question, ans, op1, op2, op3, op4);
		
		//Method of QuestionDatabase class. Used to add data into text file using new Thread  
		dbRef.createThreadToAddIntoFile(question, ans, op1, op2, op3, op4);
	}
	
	
	public static void showAdminChoices() {
		Admin admin = new Admin();
		//loopCond is true. 
		while(loopCond) {
			admin.getUserChoice();
		}
		
		//closing the scanner object.
		input.close();
	}
}
