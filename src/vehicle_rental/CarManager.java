package vehicle_rental;

import java.io.*;
import java.util.*;

public class CarManager {
	
	private static CarManager instance = new CarManager();
	
	private CarManager() {
		// TODO Auto-generated constructor stub
	}
	
	public static HashSet<Car> cm = new HashSet<>(); // 빌릴수 있는 차량들
	
	public void showList() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(RentalSystem.carListPath)));
		System.out.println("---- " + br.readLine());
		String line = "";
		int i = 1;
		while (true){
			if(line != null){
				line = br.readLine();
				if(line == null) break;
				System.out.printf("%03d: %s\n", i, line);
				i++;
			}else{
				break;
			}
		}
	}
	
	
	public static CarManager getInstance() {
		if(instance == null) instance = new CarManager();
		return instance;
	}

}
