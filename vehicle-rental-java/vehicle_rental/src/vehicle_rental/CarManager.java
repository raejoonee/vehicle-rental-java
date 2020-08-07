package vehicle_rental;

import java.util.HashSet;
import java.util.Iterator;

public class CarManager {
	
	private static CarManager instance = new CarManager();
	
	private CarManager() {
		// TODO Auto-generated constructor stub
	}
	
	public static HashSet<Car> cm = new HashSet<>(); // 빌릴수 있는 차량들
	
	public void showList() {
		Iterator<Car> iterator = cm.iterator();
		int count = 1;
		while(iterator.hasNext()) {
			System.out.printf("%03d ", count++);
			System.out.println(iterator.next().toString());
		}
	}
	
	
	public static CarManager getInstance() {
		if(instance == null) instance = new CarManager();
		return instance;
	}

}
