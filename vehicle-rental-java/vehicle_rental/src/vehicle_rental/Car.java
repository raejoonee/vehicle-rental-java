package vehicle_rental;

public class Car {
	private String numberPlate;
	private int initialFee;
	private int additionalFee;
	
	public Car() {
		
	}

	public Car(String numberPlate, int initialFee, int additionalFee) {
		super();
		this.numberPlate = numberPlate;
		this.initialFee = initialFee;
		this.additionalFee = additionalFee;
	}

	public String getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

	public int getInitialFee() {
		return initialFee;
	}

	public void setInitialFee(int initialFee) {
		this.initialFee = initialFee;
	}

	public int getAdditionalFee() {
		return additionalFee;
	}

	public void setAdditionalFee(int additionalFee) {
		this.additionalFee = additionalFee;
	}

	@Override
	public String toString() {
		return "Car [numberPlate=" + numberPlate + ", initialFee=" + initialFee + ", additionalFee=" + additionalFee
				+ "]";
	}
	
	
	

}
