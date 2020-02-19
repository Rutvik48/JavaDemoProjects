package TriviaGameProject;

import java.util.ArrayList;
import java.util.List;

public class QuestionDatabase {

	private final String QUESTION;
	private final String ANS;
	private final String OP1;
	private final String OP2;
	private final String OP3;
	private final String OP4;
	public static List<QuestionDatabase> questionDatabase = new ArrayList<>();

	public QuestionDatabase() {
		// TODO Auto-generated constructor stub
		this.QUESTION = "";
		this.ANS = "";
		this.OP1 = "";
		this.OP2 = "";
		this.OP3 = "";
		this.OP4 = "";
	}

	public QuestionDatabase(String que, String ans, String op1, String op2, String op3, String op4) {
		this.QUESTION = que;
		this.ANS = ans.trim().toLowerCase();
		this.OP1 = op1;
		this.OP2 = op2;
		this.OP3 = op3;
		this.OP4 = op4;
		addRefToList(this);
	}

	// Get Methods
	public String getQUESTION() {
		return QUESTION;
	}

	public String getANS() {
		return ANS;
	}

	public String getOP1() {
		return OP1;
	}

	public String getOP2() {
		return OP2;
	}

	public String getOP3() {
		return OP3;
	}

	public String getOP4() {
		return OP4;
	}

	public static double getRandomIntegerBetweenRange(double min, double max) {
		double x = (int) (Math.random() * ((max - min) + 1)) + min;
		return x;
	}

	public static int getTotalNumberOfQuestions() {
		return (questionDatabase.size() - 1);
	}

	private void addRefToList(QuestionDatabase ref) {
		questionDatabase.add(ref);
	}

	public QuestionDatabase getDatabaseRef(int queNum) {
		return questionDatabase.get(queNum);
	}

	public boolean checkAns(String ans) {

		ans = ans.trim().toLowerCase();
		if (ans.equals(this.ANS)) {
			return true;
		} else {
			return false;
		}
	}

}
