package TriviaGameProject;

import java.util.Scanner;

class TriviaGame {

	int curPoints = 0;
	private int bonusPointCounter = 0;
	// This will be initialized in main by calling
	// QuestionDatabase.getNumberOfQuestion()
	private int totalNumOfQuestion = 0;
	private User currentUser;
	Scanner gameInput = new Scanner(System.in);
	
	// Bonus points will be given when user answers 3 questions correctly consecutively
	private static final int BONUS_POINTS = 10;
	private static final int BONUS_POINTS_AT = 3;

	private static QuestionDatabase quesDbRef = null;

	
	TriviaGame(User userRef){
		this.currentUser = userRef; 
	}
	
	private void showQuestionAndOptions() {

		System.out.println("QUESTION: " + quesDbRef.getQUESTION());
		System.out.println(quesDbRef.getOP1());
		System.out.println(quesDbRef.getOP2());
		System.out.println(quesDbRef.getOP3());
		System.out.println(quesDbRef.getOP4());

		checkAnswer();
	}

	private void checkAnswer() {
		
		System.out.print("\n\n Write the answere here: ");

		boolean ansCheck = quesDbRef.checkAns(gameInput.next());
		
		System.out.println("Answer Check: " + (ansCheck ? "Right Answer!" : "Wrong Answer."));

		if (ansCheck) {
			bonusPointCounter++;
			
			if(bonusPointCounter == BONUS_POINTS_AT) {
				System.out.println("Bonus points added.");
				curPoints += BONUS_POINTS;
				bonusPointCounter = 0;
			} else 
				curPoints++;
		}
		System.out.println("Current Points: " + curPoints);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void startGame() {

		int totalQ = totalNumOfQuestion < 11 ? totalNumOfQuestion : 10;
		for (int i = 0; i < totalQ; i++) {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\nQuestion No: " + (i + 1));
			quesDbRef = QuestionDatabase.getDatabaseRef(i);
			showQuestionAndOptions();
		}
		
	}

	@SuppressWarnings("static-access")
	public void run() {

		QuestionDatabase qesDB = new QuestionDatabase();
		
		qesDB.retrieveDataFromTextFile();
		totalNumOfQuestion = qesDB.getTotalNumberOfQuestions();

		if (totalNumOfQuestion < 1) {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\nAdmin needs to add questions.");
		} else {

			//'didUserPlay' is a boolean variable of User class, which keeps track of if user answered any question. 
			//It is used to show total points at the end of each round.
			currentUser.didUserPlay = true;
			startGame();
		}

		System.out.println("Game Ended!");

	}

}
