package interfaceDemo;

public class Traveller {
	
	private final String TRAVELLER_NAME;
	
	public void startTravelling(String travellerChoice) {
		System.out.println("\nTurning on the " + travellerChoice + "...");
		PersonalVehicles personalVehicles = new PersonalVehicles(travellerChoice);
		
		//personalVehicles.getMaxSpeed();
	}
	
	public Traveller(String travellerName, String travellerChoice) {
		// TODO Auto-generated constructor stub
		TRAVELLER_NAME = travellerName;

		startTravelling(travellerChoice);
	}

}
