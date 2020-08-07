package vehicle_rental;

import java.util.Date;

public class Car {
	protected String numberPlate;
	protected Date registeredDate;
	protected boolean rentalStatus;
	
	public Car() {
		
	}
	
	public Car(String numberPlate) {
		this.numberPlate = numberPlate;
		
	}

	public String getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

	@Override
	public String toString() {
		return "Car [numberPlate=" + numberPlate + ", registeredDate= " + registeredDate + ", rentalStatus = " + rentalStatus + "]";
	}

	
	
	
	

}
