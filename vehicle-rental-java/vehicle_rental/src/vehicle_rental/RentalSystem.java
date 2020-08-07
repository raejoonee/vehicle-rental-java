package vehicle_rental;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class RentalSystem {

	static final String carListPath = "carList.csv";
	public SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private static RentalSystem instance = new RentalSystem();
	
	private RentalSystem() {
		// TODO Auto-generated constructor stub
	}
	
	public void showList() {
		Iterator<Car> iterator = CarManager.cm.iterator();
		int count = 1;
		while(iterator.hasNext()) {
			System.out.printf("%03d ", count++);
			System.out.println(iterator.next().toString());
		}
	}
	
	public void registerCar(Car car) throws IOException {
		String now = sdf.format(new Date());
		try {
	        FileWriter fw = new FileWriter(carListPath, true);
	       
	        if (car instanceof SUVCar){
	        	System.out.println("asdjflksadjf");
	        	fw.write("\nSUV, " + car.numberPlate + ", " + now + ", false");
	        	CarManager.cm.add(car);
	        } else if (car instanceof CompactCar){
	        	System.out.println("asdklfjksladfj");
	        	fw.write("\ncompactCar, " + car.numberPlate + ", " + now + ", false");
	        	CarManager.cm.add(car);
	        } else {
	        	fw.write("\npassengerCar, " + car.numberPlate + ", " + now + ", false");
	        	CarManager.cm.add(car);
	        }
	        fw.flush();
	        fw.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public static RentalSystem getInstance() {
		if(instance == null) instance = new RentalSystem();
		return instance;
	}

}
