package interfaceDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	private static void getInput() {
		
		Scanner scanner = new Scanner(System.in);
		String name = "";
		String vehicle = "";
		
		System.out.println("Receiving details from test.txt\n");
		
		//creating File instance to reference text file in Java
        File text = new File("C:\\Users\\Rajan\\ivr-workspace\\Training Demo Projects\\src\\interfaceDemo\\test.txt");
     
        //Creating Scanner instnace to read File in Java
        Scanner scnr;
		try {
			scnr = new Scanner(text);
			
			//Reading each line of file using Scanner class
	        int lineNumber = 1;
	        while(scnr.hasNextLine() && lineNumber < 3){
	            String line = scnr.nextLine().trim();
	            String temp = (lineNumber%2) != 0 ? "Name" : "Vehicle";
	            System.out.println(temp + " :" + line);
	            lineNumber++;
	            
	            if (lineNumber%2 == 0) {
	            	name = line;
	            } else if (lineNumber%2 != 0) {
	            	vehicle = line;
	            }
	        } 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Traveller traveller = new Traveller(name, vehicle);
     
        
	}
	
	public static void main(String[] args) {
		
		
		getInput();
		//Traveller traveller = new Traveller(travellerName, travellerChoice)
	}
}
