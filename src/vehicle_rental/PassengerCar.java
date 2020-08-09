package vehicle_rental;

public class PassengerCar extends Car{
	
	public static int initialFee = 16000; // 처음 대여 가격 
	public static int additionalFee = 150; // 1분마다 붙는 가격 
	public static double discountRatio = 0.15;
	
	
	public PassengerCar() {
		
	}
	public PassengerCar(String numberplate) {
		super(numberplate);
	}
	
	@Override
	public String toString() {
		return "PassengerCar: [numberPlate=" + numberPlate + ", registeredDate= " + registeredDate + ", rentalStatus = " + rentalStatus + "]";
	}
	
	

}
