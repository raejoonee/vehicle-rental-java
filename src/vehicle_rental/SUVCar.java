package vehicle_rental;

public class SUVCar extends Car {
	
	public static int initialFee = 20000; // 처음 대여 가격 
	public static int additionalFee = 180; // 1분마다 붙는 가격 
	public static double discountRatio = 0.1;
	
	
	public SUVCar() {
		
	}
	public SUVCar(String numberplate) {
		super(numberplate);
	}
	
	@Override
	public String toString() {
		return "SUV: [numberPlate=" + numberPlate + ", registeredDate= " + registeredDate + ", rentalStatus = " + rentalStatus + "]";
	}
	
	
	
}
