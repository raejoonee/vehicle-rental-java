package vehicle_rental;

public class PassengerCar extends Car{
	
	public PassengerCar() {
		
	}
	public PassengerCar(String numberplate) {
		super(numberplate);
		initialFee = 16000;
		additionalFee = 150;
		discountRatio = 0.15;
	}
	@Override
	public String toString() {
		return "PassengerCar: [numberPlate=" + numberPlate + ", initialFee=" + initialFee + ", additionalFee="
				+ additionalFee + ", discountRatio=" + discountRatio + "]";
	}

}
