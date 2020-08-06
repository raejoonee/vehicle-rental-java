package vehicle_rental;

public class CompactCar extends Car {
	
	public CompactCar() {
		
	}
	public CompactCar(String numberplate) {
		super();
		initialFee = 13000;
		additionalFee = 130;
		discountRatio = 0.2;
	}

}
