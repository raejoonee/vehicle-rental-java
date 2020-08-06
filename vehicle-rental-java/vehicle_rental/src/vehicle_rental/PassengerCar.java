package vehicle_rental;

public class PassengerCar extends Car{
	
	public PassengerCar() {
		
	}
	public PassengerCar(String numberplate) {
		super();
		initialFee = 16000;
		additionalFee = 150;
		discountRatio = 0.15;
	}
	

}
