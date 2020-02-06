package interfaceDemo;

public interface BikeInterface {
	
	default int getPassengerCapacity() {
		System.out.println("Passenger Capacity: 2");
		return 2;
	}
	
	default int getNumberOfTyre() {
		System.out.println("Number of tyre: 2");
		return 2;
	}
	
	default int getMaxSpeed() {
		System.out.println("Max speed: 20");
		return 20;
	}
}
