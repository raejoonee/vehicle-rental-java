package vehicle_rental;

import java.util.Iterator;
import java.util.regex.Matcher;

public class Admin extends Member {
	public Admin(String id, String pw, int age){
		super();
		this.id = id;
		this.pw = pw;
		this.age = age;
	}
	
	public void registerCar(Car car) {
		CarManager.cm.add(car);
	}
	
	public void showMember() {
		Iterator<Member> iter = MemberService.mb.iterator();
		int cnt = 1;
		while(iter.hasNext()) {
			System.out.printf("%03d ", cnt++);
			System.out.println(iter.next().toString());
		}
	}
	
//	public void deleteCar(Car car) {
//		Iterator<>
//		
//		
//	}
	
	public static void main(String[] args) {
		MemberService mb = new MemberService();
		mb.regist("id", "pw", 100);
		mb.regist("asdf", "asdf", 50);
		Admin admin = new Admin("admin", "admin", 120);
		admin.showMember();
		
	}
	
	
}
