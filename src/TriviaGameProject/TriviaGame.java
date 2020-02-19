package TriviaGameProject;

class TriviaGame extends QuestionDatabase {

	private int curPoints = 0;
	private int totalPoints = 0;
	private int numQesPlayed = 0;
	// This will be initialized in main by calling
	// QuestionDatabase.getNumberOfQuestion()
	private static int totalNumOfQuestion = 0;

	// Bonus points will be given when user answers 3 questions correctly
	// consecutively
	private final int BONUS_POINTS = 10;
	private final int BONUS_POINTS_AT = 3;

	private static QuestionDatabase quesDbRef = null;

	private static void showQuestionAndOptions() {

		System.out.println("QUESTION: " + quesDbRef.getQUESTION());
		System.out.println(quesDbRef.getOP1());
		System.out.println(quesDbRef.getOP2());
		System.out.println(quesDbRef.getOP3());
		System.out.println(quesDbRef.getOP4());

		System.out.print("\n\n Write the answere here: ");
	}

	private static void startGame() {

		for (int i = 0; i < totalNumOfQuestion; i++) {
			quesDbRef = questionDatabase.get(i);
			showQuestionAndOptions();
		}
	}

	public static void run() {
		totalNumOfQuestion = getTotalNumberOfQuestions();

		if (totalNumOfQuestion == 0) {
			System.out.println("There are 0 questions. Ask admin to add more questions.");
			Main.main(null);
		} else {
			startGame();
		}
	}

	private static void main(String[] args) {
		// TODO Auto-generated method stub

		run();

	}

}
