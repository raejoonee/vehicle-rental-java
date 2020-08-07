package vehicle_rental;

import java.util.Date;

public class Car {
	protected String numberPlate;
	protected int initialFee; // 처음 대여 가격 
	protected int additionalFee; // 1분마다 붙는 가격 
	protected double discountRatio;
	protected Date registeredDate;
	
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
	public double getDiscountRatio() {
		return discountRatio;
	}

	public void setDiscountRatio(double discountRatio) {
		this.discountRatio = discountRatio;
	}

	@Override
	public String toString() {
		return "Car [numberPlate=" + numberPlate + ", initialFee=" + initialFee + ", additionalFee=" + additionalFee
				+ ", discountRatio=" + discountRatio + "]";
	}

	
	
	
	

}
