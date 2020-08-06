package vehicle_rental;

public class SUVCar extends Car {
	
	public SUVCar() {
		
	}
	public SUVCar(String numberplate) {
		super();
		initialFee = 20000;
		additionalFee = 180;
		discountRatio = 0.1;
	}
	
}
