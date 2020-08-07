package vehicle_rental;

import java.io.*;
import java.util.Scanner;

public class RentalService {
	public static void main(String[] args) throws IOException {
		MemberService ms = new MemberService();
		CarManager cm = CarManager.getInstance();
		RentalSystem rs = RentalSystem.getInstance();
		
		Scanner sc = new Scanner(System.in);
		
		int age = 0;
		String id = null;
		String pw = null;
		String pwtemp = null;
		String loginedID = null;
		boolean login = false;
		boolean isAdmin = false;
		boolean test = true;
		
		Admin admin = new Admin("admin", "admin", 0);
		MemberService.mb.add(admin);

		System.out.println("--------------------------------");
		System.out.println("자동차 렌탈 서비스에 오신 것을 환영합니다.");
		
		while(test){
			Loop1 : while (!login){
				System.out.println("--------------------------------");
				System.out.println("회원가입(1)  |  로그인(2)  |  종료(3)");
				System.out.println("--------------------------------");
				
				int service = 0;
				try {
					service = Integer.parseInt(sc.nextLine());
				} catch (NumberFormatException e){
				}
				switch(service){
				case 1:
					while(true){
						System.out.println("만 나이를 입력해주세요. >>> ");
						try {
							age = Integer.parseInt(sc.nextLine());
							break;
						} catch (NumberFormatException e){
							System.out.println("나이는 숫자로 입력하셔야 합니다.");
						}
					}
					if (age <= 19){
						System.out.println("죄송합니다. 만 19세 이하 미성년자는 가입할 수 없습니다.");
						break;
					}
					System.out.print("환영합니다! ");
					boolean flag = true;
					Loop2: while (flag){
						System.out.println("사용하고자 하는 아이디를 입력해주세요 >>> \n(회원가입 취소는 exit을 입력해주세요.)");
						id = sc.nextLine();
						if (id.equals("exit")) break Loop1;
						for (Member m : MemberService.mb){
							if (m != null){ // null check
								if (m.getId().equals(id)){
									System.out.println("죄송합니다. 이미 다른 사람이 사용중인 ID입니다.");
									break Loop2;
								}
							}
						}
						flag = false;
					}
					flag = true;
					while (flag){
						System.out.println("사용할 비밀번호를 입력해주세요. >>> \n(회원가입을 취소하고 싶으시면 exit을 입력해주세요.)");
						pw = sc.nextLine();
						if (pw.equals("exit")) break Loop1;
						System.out.println("비밀번호를 다시 한 번 입력해주세요 >>> \n(회원가입을 취소하고 싶으시면 exit을 입력해주세요.)");
						pwtemp = sc.nextLine();
						if (pwtemp.equals("exit")) break Loop1;
						if (!pw.equals(pwtemp)){
							System.out.print("처음 입력한 비밀번호와 다릅니다. 다시 ");
						} else {
							MemberService.mb.add(new Member(id, pw, age));
							System.out.println("환영합니다! 가입에 성공했습니다!");
							break;
						}
					}
					break;
				case 2:
					System.out.println("아이디를 입력해주세요. >>> ");
					id = sc.nextLine();
					
					System.out.println("비밀번호를 입력해주세요. >>> ");
					pw = sc.nextLine();
					if (ms.login(id, pw)) {
						if (id.equals("admin")) isAdmin = true;
						System.out.println("로그인 성공");
						login = true;
						loginedID = id;
					}
					else System.out.println("아이디 또는 비밀번호가 잘못되었습니다.");
					break;
//				case 3:
//					System.out.println("id >>> ");
//					id = sc.nextLine();
//					System.out.println(ms.logout(id));
//					break;
//				case 4:
//					System.out.println("id >>> ");
//					ms.listMember(id);
//					id = sc.nextLine();
//					ms.listMember(id);
//					break;
				case 3:
					while(true){
						System.out.println("프로그램을 종료하시겠습니까? (Y/N)");
						String sel = sc.nextLine();
						// sel을 대문자로 만들고(toUpperCase()), 공백을 제거하고(trim()), "Y"랑 같은지 본다.
						if (sel.toUpperCase().trim().equals("Y")){
							System.out.println("안녕히 가세요.");
							return ;
						} else if (sel.toUpperCase().trim().equals("N")){
							break;
						} else {
							System.out.println("Y나 N을 입력해주세요.");
						}
					}
					break;
				default:
					System.out.println("명령은 1부터 3까지의 숫자로 입력해주세요.");
				}
			}
			while(login){
				if (isAdmin){
					Loop9 : while (login){
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
							MemberService.mb.add(new Member(id, pw, age));
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
							isAdmin = false;
							login = false;
							ms.logout("admin");
							break;
						default:
							System.out.println("명령은 1부터 3까지의 숫자로 입력해주세요.");
						}
					}
					break;
				} else {
					Loop0: while(login){
						System.out.println("-----------------------------------------------------------------------------------");
						System.out.println("차량 목록 보기(1)  |  차량 렌탈하기(2)  |  차량 반납하기 (3)  | 비밀번호 변경하기(4)  |  로그아웃(5)");
						System.out.println("-----------------------------------------------------------------------------------");
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
							String model = sc.nextLine();
							System.out.println("차량 번호를 입력해주세요.");
							String nb = sc.nextLine();
							Car car = null;
							switch(model){
							case "1":
								car = new CompactCar(nb);
								break;
							case "2":
								car = new PassengerCar(nb);
								break;
							case "3":
								car = new SUVCar(nb);
								break;
							default:
								System.out.println("차종은 1부터 6까지의 숫자로 입력해주세요.");
							}
							rs.registerCar(car);
							break;
						case 3:
						case 4:
							System.out.println("변경할 비밀번호를 입력해주세요.");
							System.out.println(ms.changePW(loginedID, sc.nextLine()));
							break;
						case 5:
							login = false;
							ms.logout(loginedID);
							break;
						default:
							System.out.println("명령은 1부터 5까지의 숫자로 입력해주세요.");
						}
					}
					break;
				}
			}
		}
		sc.close();
	}
}
