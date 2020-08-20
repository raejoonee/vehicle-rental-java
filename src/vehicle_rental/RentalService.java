package vehicle_rental;

import java.io.*;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class RentalService {
	public static void main(String[] args) throws IOException {
		MemberService ms = MemberService.getInstance();
		CarManager cm = CarManager.getInstance();
		RentalSystem rs = RentalSystem.getInstance();
		Scanner sc = new Scanner(System.in);
		
		Admin admin = new Admin("admin", "admin", 0);
		Customer customer = null;
		MemberService.mb.add(admin);

		System.out.println("--------------------------------");
		System.out.println("자동차 렌탈 서비스에 오신 것을 환영합니다.");
		
		while(MemberService.run){
			MemberService.run();
			while(MemberService.login){
				if (MemberService.isAdmin){
					Loop9 : while (MemberService.login){
						System.out.println("------------------------------------------------------------------------------------------------------");
						System.out.println("차량 목록 보기(1)  |  차량 등록하기(2)  |  차량 삭제하기(3)  |  고객 목록 보기 (4)  |  비밀번호 변경하기(5)  |  로그아웃(6)");
						System.out.println("------------------------------------------------------------------------------------------------------");
						int service2 = 0;
						try {
							service2 = Integer.parseInt(sc.nextLine());
						} catch (NumberFormatException e){
						}
						switch(service2){
						case 1:
							cm.showList();
							break;
						case 2:
							System.out.println("차종을 선택해주세요.\n1: 경차\t2: 승용차\t3: SUV");
							int model =  0;
							try {
								model = Integer.parseInt(sc.nextLine());
							} catch (NumberFormatException e){
								System.out.println("차종 입력이 잘못되었습니다.");
								break;
							}
							System.out.println("차량 번호를 입력해주세요.");
							String nb = sc.nextLine();
							Car car = null;
							switch(model){
							case 1:
								car = new CompactCar(nb);
								break;
							case 2:
								car = new PassengerCar(nb);
								break;
							case 3:
								car = new SUVCar(nb);
								break;
							default:
								System.out.println("오류가 발생했습니다.");
								break Loop9;
							}
							rs.registerCar(car);
							System.out.println("차량 번호 [" + nb + "] 정상적으로 등록되었습니다.");
							break;
						case 3:
							cm.showList();
							System.out.println("\n목록에서 삭제할 차량 번호를 입력해주세요.");
							int numPlate = Integer.parseInt(sc.nextLine());
							System.out.println("차량 "+rs.deleteCar(numPlate) + " 가 삭제되었습니다. ");
							break;
						case 4:
							admin.showMember();
							break;
						case 5:
							System.out.println("변경할 비밀번호를 입력해주세요.");
							admin.changePW("admin", sc.nextLine());
							break;
						case 6:
							MemberService.isAdmin = false;
							MemberService.login = false;
							ms.logout("admin");
							break;
						default:
							System.out.println("명령은 1부터 6까지의 숫자로 입력해주세요.");
						}
					}
					break;
				} else {
					while(MemberService.login){
						int loginNo = 0;
						for (Customer cst : Customer.cl){
							if (cst != null){
								if (cst.getId().equals(MemberService.loginedID)){
									customer = Customer.cl.get(loginNo);
								}
							}
							loginNo++;
						}
						System.out.println("--------------------------------------------------------------------------------------------------");
						System.out.println("차량 목록 보기(1)  |  차량 렌탈하기(2)  |  차량 반납하기 (3)  |  충전하기(4)  |  비밀번호 변경하기(5)  |  로그아웃(6)");
						System.out.println("--------------------------------------------------------------------------------------------------");
						int service2 = 0;
						try {
							service2 = Integer.parseInt(sc.nextLine());
						} catch (NumberFormatException e){
						}
						switch(service2){
						case 1:
							cm.showList();
							break;
						case 2: 
							cm.showList();					
							System.out.println("\n목록에서 대여 차량 번호를 입력해주세요.");
							int num = 0;
							try {
								num = Integer.parseInt(sc.nextLine());
							} catch (NumberFormatException e){
								System.out.println("숫자만 입력 가능합니다.");
							}
							customer.rentCar(num);
							break;
						case 3: 
							while(true){
								System.out.println("사용중이신 "+ customer.getIsRenting() + "을(를) 반납하시겠습니까? (Y/N)");
								String sel = sc.nextLine();
								if (sel.toUpperCase().trim().equals("Y")){
									customer.returnCar();								
									break;
								} else if (sel.toUpperCase().trim().equals("N")){
									break;
								} else {
									System.out.println("Y나 N을 입력해주세요.");
								}
							}
							break;
						case 4:
							System.out.println("돈을 얼마나 충전하시겠어요?");
							System.out.println("현재 잔고: " + customer.getBalance());
							int service3 = 0;
							try {
								service3 = Integer.parseInt(sc.nextLine());
							} catch (NumberFormatException e){
								System.out.println("숫자 외의 입력이 감지되어 충전이 종료되었습니다.");
								break;
							}
							if (service3 <= 0){
								System.out.println("충전은 1원 이상만 가능합니다.");
								break;
							}
							customer.charge(service3);
							System.out.println("감사합니다. " + service3 + " 원이 충전되었습니다.");
							System.out.println("현재 잔고: " + customer.getBalance());
							break;
						case 5:
							System.out.println("변경할 비밀번호를 입력해주세요.");
							System.out.println(ms.changePW(MemberService.loginedID, sc.nextLine()));
							break;
						case 6:
							MemberService.login = false;
							ms.logout(MemberService.loginedID);
							break;
						default:
							System.out.println("명령은 1부터 6까지의 숫자로 입력해주세요.");
						}
					}
					break;
				}
			}
		}
		sc.close();
	}
}