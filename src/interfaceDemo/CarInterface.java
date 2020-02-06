package interfaceDemo;

public interface CarInterface {

	default int getPassengerCapacity() {
		System.out.println("Passenger Capacity: 5");
		return 5;
	}
	
	default int getNumberOfTyre() {
		System.out.println("Number of tyre: 4");
		return 4;
	}
	
	default int getMaxSpeed() {
		System.out.println("Car's max speed is 80");
		
		return 80;
	}
	
}
