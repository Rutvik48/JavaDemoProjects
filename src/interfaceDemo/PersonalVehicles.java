package interfaceDemo;

public class PersonalVehicles implements CarInterface, BikeInterface {

	private boolean carSelected = false;
	private boolean bikeSelected = false;
	
	private static PersonalVehicles shared = null;
	
	public PersonalVehicles(String selection) {
		// TODO Auto-generated constructor stub
		
		if (selection.equals("Car")) {
			carSelected = true;
			bikeSelected = false;
		} else {
			carSelected = false;
			bikeSelected = true;
		}
		
		//System.out.println(selection +" is selected.");
	}
	
	public static PersonalVehicles getSingleton(String selection) {
		
		if (shared == null)
			shared = new PersonalVehicles(selection);
		
		return shared;
	}


	@Override
	public int getPassengerCapacity() {
		// TODO Auto-generated method stub
		
		//carSelected ? return BikeInterface.super.getPassengerCapacity() : return BikeInterface.super.getPassengerCapacity();
		
		if (carSelected) {
			return CarInterface.super.getPassengerCapacity();
		} else {
			return BikeInterface.super.getPassengerCapacity();
		}
		
	}


	@Override
	public int getMaxSpeed() {
		// TODO Auto-generated method stub
		
		if (carSelected) {
			return CarInterface.super.getMaxSpeed();
		} else {
			return BikeInterface.super.getMaxSpeed();
		}
	}


	@Override
	public int getNumberOfTyre() {
		// TODO Auto-generated method stub
		
		if (carSelected) {
			return CarInterface.super.getNumberOfTyre();
		} else {
			return BikeInterface.super.getNumberOfTyre();
		}
	}	
	
}
