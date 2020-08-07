package vehicle_rental;

public class SUVCar extends Car {
	
	public SUVCar() {
		
	}
	public SUVCar(String numberplate) {
		super(numberplate);
		initialFee = 20000;
		additionalFee = 180;
		discountRatio = 0.1;
	}
	@Override
	public String toString() {
		return "SUV: [numberPlate=" + numberPlate + ", initialFee=" + initialFee + ", additionalFee=" + additionalFee
				+ ", discountRatio=" + discountRatio + "]";
	}
	
	
	
}
