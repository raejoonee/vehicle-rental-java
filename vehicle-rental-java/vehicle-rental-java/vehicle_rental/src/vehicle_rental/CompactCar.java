package vehicle_rental;

public class CompactCar extends Car {
	
	public CompactCar() {
		
	}
	public CompactCar(String numberplate) {
		super(numberplate);
		initialFee = 13000;
		additionalFee = 130;
		discountRatio = 0.2;
	}
	@Override
	public String toString() {
		return "Compact: [numberPlate=" + numberPlate + ", initialFee=" + initialFee + ", additionalFee="
				+ additionalFee + ", discountRatio=" + discountRatio + "]";
	}
	
	
	
}
