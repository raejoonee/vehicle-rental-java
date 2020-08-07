package vehicle_rental;

public class CompactCar extends Car {
	public static int initialFee = 13000; // 처음 대여 가격 
	public static int additionalFee = 130; // 1분마다 붙는 가격 
	public static double discountRatio = 0.2;
	
	public CompactCar() {
		
	}
	public CompactCar(String numberplate) {
		super(numberplate);
		
	}
	@Override
	public String toString() {
		return "Compact: [numberPlate=" + numberPlate + ", registeredDate= " + registeredDate + ", rentalStatus = " + rentalStatus + "]";
	}
	
	
	
}
