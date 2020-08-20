package vehicle_rental;

import java.util.Date;

public class Car {
	protected String numberPlate;
	protected String model;
	protected Date registeredDate;
	protected String rentalStatus;
	
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
	

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	

	public String getRentalStatus() {
		return rentalStatus;
	}

	public void setRentalStatus(String rentalStatus) {
		this.rentalStatus = rentalStatus;
	}
	
	

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	@Override
	public String toString() {
		return "Car [numberPlate=" + numberPlate + ", model=" + model + ", registeredDate=" + registeredDate
				+ ", rentalStatus=" + rentalStatus + "]";
	}

	

	
	
	
	

}
