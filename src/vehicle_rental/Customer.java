package vehicle_rental;

import java.io.*;
import java.util.*;

public class Customer extends Member {
	public static Vector<Customer> cl = new Vector<>();
	private int balance;
	private int mileage;
	private int totalFee;
	private String isRenting;
	private int position;
	
	Scanner sc = new Scanner(System.in);
	
	private void Customer() {
		// TODO Auto-generated method stub

	}
	public Customer(String id) {
		this.id = id;
	}
	
	
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int getMileage() {
		return mileage;
	}
	
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	public int getTotalFee() {
		return totalFee;
	}
	
	public void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}
	
	public String getIsRenting() {
		return isRenting;
	}
	
	public void setIsRenting(String isRenting) {
		this.isRenting = isRenting;
	}
	
	
	public void rentCar(int position) throws IOException {
		if (this.isRenting != null) {
			System.out.println("먼저 고객님이 반납하지 않은 차량 [" + this.isRenting + "]을 반납해주세요!");
			return ;
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(RentalSystem.carListPath))));
		String dummy = "";
		String line = "";
		try {
			for(int i = 0 ; i < position; i++) {
				line = br.readLine();
				dummy += (line +"\r\n");
			}
		} catch (NullPointerException e){
			System.out.println("목록에 있는 차량 번호를 입력해주세요.");
			br.close();
			return ;
		}
		String delData = br.readLine(); // 고객이 고른 차량 목록 번호 문자열
		String [] temp;
		try {
			temp = delData.split(",");
		} catch (NullPointerException e){
			System.out.println("목록에 있는 차량 번호를 입력해주세요.");
			br.close();
			return ;
		}
		if(temp[3].equals(" true")) {
			System.out.println("죄송합니다. 이미 렌트중인 차량은 이용하실 수 없습니다. ");
			br.close();
			return;
		}
		if(temp[0].equals("compactCar")){
			System.out.println("경차를 선택하셨습니다. 렌탈료로 잔고에서 13000원이 차감됩니다.");
			System.out.println("정말 [" + temp[0] + ", " + temp[1] + "] 차량을 렌탈하시겠습니까? (Y/N)");
			String sel = sc.nextLine();
			// sel을 대문자로 만들고(toUpperCase()), 공백을 제거하고(trim()), "Y"랑 같은지 본다.
			if (sel.toUpperCase().trim().equals("Y")){
				if (this.getBalance() < 13000){
					System.out.println("잔고가 부족합니다. 먼저 잔고를 충전해주세요.");
					br.close();
					return ;
				};
				this.setBalance(this.getBalance()-13000);
			} else if (sel.toUpperCase().trim().equals("N")){
				br.close();
				return ;
			} else {
				System.out.println("Y나 N을 입력해주세요.");
			}
		} else if (temp[0].equals("passengerCar")) {
			System.out.println("승용차를 선택하셨습니다. 렌탈료로 잔고에서 16000원이 차감됩니다.");
			System.out.println("정말 [" + temp[0] + ", " + temp[1] + "] 차량을 렌탈하시겠습니까? (Y/N)");
			String sel = sc.nextLine();
			// sel을 대문자로 만들고(toUpperCase()), 공백을 제거하고(trim()), "Y"랑 같은지 본다.
			if (sel.toUpperCase().trim().equals("Y")){
				if (this.getBalance() < 16000){
					System.out.println("잔고가 부족합니다. 먼저 잔고를 충전해주세요.");
					br.close();
					return ;
				};
				this.setBalance(this.getBalance()-16000);
			} else if (sel.toUpperCase().trim().equals("N")){
				br.close();
				return ;
			} else {
				System.out.println("Y나 N을 입력해주세요.");
			}
		} else if (temp[0].equals("SUV")) {
			System.out.println("SUV를 선택하셨습니다. 렌탈료로 잔고에서 20000원이 차감됩니다.");
			System.out.println("정말 [" + temp[0] + ", " + temp[1] + "] 차량을 렌탈하시겠습니까? (Y/N)");
			String sel = sc.nextLine();
			// sel을 대문자로 만들고(toUpperCase()), 공백을 제거하고(trim()), "Y"랑 같은지 본다.
			if (sel.toUpperCase().trim().equals("Y")){
				if (this.getBalance() < 20000){
					System.out.println("잔고가 부족합니다. 먼저 잔고를 충전해주세요.");
					br.close();
					return ;
				};
				this.setBalance(this.getBalance()-20000);
			} else if (sel.toUpperCase().trim().equals("N")){
				br.close();
				return ;
			} else {
				System.out.println("Y나 N을 입력해주세요.");
			}
		} else {
			System.out.println("렌트 중 오류가 발생했습니다. 다시 시도해주세요.");
			br.close();
			return ;
		}
		temp[3] = "true";
		String changed = String.join(", ", temp);
		this.isRenting = changed;
		dummy += (changed + "\r\n");
		
		while((line = br.readLine())!=null) {
			dummy += (line +"\r");
		}
		System.out.println("[ " + temp[0] + ", " + temp[1] + " ] 예약이 완료 되었습니다.");
		this.position = position;
		FileWriter fw = new FileWriter(RentalSystem.carListPath);
		fw.write(dummy);
		fw.flush();
		fw.close();
		br.close();
	}
	
	public void returnCar() throws IOException { // is Renting 다시 false 로 바꿔주고 덮어쓰고  isRenting null 처리 해주고 
		if (this.isRenting == null) {
			System.out.println("반납하실 차량이 없습니다!");
			return ;
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(RentalSystem.carListPath))));
		String dummy = "";
		String line = "";
		for(int i = 0 ; i < this.position; i++) {
			line = br.readLine();
			dummy += (line +"\r\n");
		}
		String delData = br.readLine(); // 고객이 고른 차량 목록 번호 문자열 
		String[] temp = delData.split(",");
		temp[3] = "false";
		String changed = String.join(", ", temp);
		dummy += (changed + "\r\n");
		
		while((line = br.readLine())!=null) {
			dummy += (line +"\r");
		}
		System.out.println("[ " + temp[0] + ", " + temp[1] + " ] 의 반납처리가 완료 되었습니다.");
		this.isRenting = null;
		this.position = 0;
		FileWriter fw = new FileWriter(RentalSystem.carListPath);
		fw.write(dummy);
		fw.flush();
		fw.close();
		br.close();
	}
	public void charge(int money){
		this.balance += money;
	}
	
	
}
