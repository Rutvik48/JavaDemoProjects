package TriviaGameProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class QuestionDatabase {

	private final String QUESTION;
	private final String ANS;
	private final String OP1;
	private final String OP2;
	private final String OP3;
	private final String OP4;

	// This is the pattern used to separate data such as:
	// ""QUESTION/*~*/ANS/*~*/OP1/*~*/OP2/*~*/OP3/*~*/OP4"
	private final String DEVISER = "//~//";

	// File name of the text file where questions will be stored
	private final static String FILE_NAME = "QuestionDatabase.txt";

	// This list will save Objects of QuestionDatabase, which will be created when
	// Admin adds a new question
	private static List<QuestionDatabase> questionDatabaseObjectList = new ArrayList<>();
	
	public static List<String> questionDBList = new ArrayList<>();

	public QuestionDatabase() {
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
	
	public void createThreadToAddIntoFile(String que, String ans, String op1, String op2, String op3, String op4) {
		
		Thread thread = new Thread() {
			public void run() {

				// Formatting the user input to save in a text file.
				// Which can be used later to retrieve data
				String formatedString = formatData(que, ans.trim().toLowerCase(), op1, op2, op3, op4);

				try {
					// Saving formatted string into a file.
					addQuestionToFile(formatedString);
				} catch (IOException e) {
					e.printStackTrace();
				}
			};
		};

		thread.start();
		
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
		return (questionDatabaseObjectList.size() - 1);
	}

	private void addRefToList(QuestionDatabase ref) {
		questionDatabaseObjectList.add(ref);
	}

	public static QuestionDatabase getDatabaseRef(int queNum) {
		
		if(questionDatabaseObjectList.size()>0) 
			return questionDatabaseObjectList.get(queNum);
		else
			return new QuestionDatabase();
	}

	public boolean checkAns(String ans) {

		ans = ans.trim().toLowerCase();
		if (ans.equals(this.ANS)) {
			return true;
		} else {
			return false;
		}
	}

	private static void addQuestionToFile(String text) throws IOException {

		File file = new File(FILE_NAME);
		FileWriter fr = new FileWriter(file, true);
		BufferedWriter br = new BufferedWriter(fr);
		PrintWriter pr = new PrintWriter(br);
		pr.println(text);
		pr.close();
		br.close();
		fr.close();

	}

	private String formatData(String ques, String ans, String op1, String op2, String op3, String op4) {

		String formattedStr = "";

		formattedStr = ques + DEVISER + ans + DEVISER + op1 + DEVISER + op2 + DEVISER + op3 + DEVISER + op4;

		return formattedStr;
	}

	void retrieveDataFromTextFile() {

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(FILE_NAME));
			
			//Reading the file using readLine() method
			String contentLine = br.readLine();
			
			while (contentLine != null) {
				String[] str = contentLine.split(DEVISER);
				//System.out.println(contentLine);
				new QuestionDatabase(str[0], str[1], str[2], str[3], str[4], str[5]);
				questionDBList.add(contentLine);
				contentLine = br.readLine();
			}
			
			 br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
