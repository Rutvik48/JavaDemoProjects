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
	
	private String getQuestion() {
		
		System.out.println("Enter Question: ");
		question = input.next();
		return question;
	}

	private String getAns() {
		
		System.out.println("Enter Ans: ");
		ans = input.next();
		
		return ans;
	}
	
	private String getOp1() {
		
		System.out.println("Enter option 1.");
		op1 = input.next();
		
		return op1;
	}
	
	private String getOp2() {
		
		System.out.println("Enter option 2.");
		op2 = input.next();
		
		return op2;
	}
	
	private String getOp3() {
		
		System.out.println("Enter option 3.");
		op3 = input.next();
		return op3;
	}
	
	private String getOp4() {
		
		System.out.println("Enter option 4.");
		op4 = input.next();
		
		return op4;
	}
	
	//This method gets reuired data.
	private void addQuestion() {
		
		//These methods will get required information and set it to global variable of this 'Admin' class
		getQuestion(); 
		getAns(); 
		getOp1(); 
		getOp2(); 
		getOp3(); 
		getOp4();
		
		//Adding new question set in the QuestionDatabase
		new QuestionDatabase(question, ans, op1, op2, op3, op4);
	}
	
	
	public static void run() {
		Admin admin = new Admin();
		//loopCond is true. 
		while(loopCond) {
			admin.getUserChoice();
		}
		
		//closing the scanner object.
		input.close();
	}
}
