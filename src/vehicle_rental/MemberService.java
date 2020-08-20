package vehicle_rental;

import java.util.Scanner;
import java.util.Vector;

//import class08_gettersetter.Member;

public class MemberService {
	// Member 타입 객체를 저장하기 위한 배열
	public static Vector<Member> mb = new Vector<>();
	public static MemberService instance = new MemberService();
	private int count = 0;
	public static boolean login = false;
	public static String loginedID = null;
	public static boolean run = true;
	public static boolean isAdmin = false;
	
	private MemberService() {
		
	}
	
	public void regist(String id, String pw, int age) {
		mb.add(new Member(id, pw, age));
	}

	public static boolean login(String id, String pw) {
		for (Member m : mb){
			if (m != null){ // null check
				if (m.getId().equals(id) && m.getPw().equals(pw)){
					m.setLogin(true);
					return true;
				}
			}
		}
		return false;
	}

	public void logout(String id) {
		for (Member m : mb){
			if (m != null){ // null check
				if (m.getId().equals(id) && m.isLogin()){
					m.setLogin(false);
				}
			}
		}
		if (id.equals("admin")) id = "관리자 계정에서 ";
		else id += " 님, ";
		System.out.println(id + "정상적으로 로그아웃되었습니다.");
	}
	
	public String changePW(String id, String pw){
		for (Member m : mb){
			if (m != null){ // null check
				if (m.getId().equals(id)){
					m.setPw(pw);
				}
			}
		}
		return "비밀번호가 변경되었습니다.";
	}

	public void listMember(String id) {
		for (Member m : mb){
			if (m == null) continue;
			else {
				if (id.equals(m.getId())){
					if (m.isLogin()){
						int num = 0;
						for (Member t : mb){
							if (t == null) continue;
							num++;
							System.out.println(t);
						}
						System.out.println("총 회원수: "+num);
						return ;
					} else {
						System.out.println("로그인된 회원에게만 제공되는 기능입니다.");
						return ;
					}
				}
			}
		}
		System.out.println("로그인된 회원에게만 제공되는 기능입니다.");
	}
	
	public static void run() {
		Scanner sc = new Scanner(System.in);
		int age = 0;
		String id = null;
		String pw = null;
		String pwtemp = null;
		
		Loop1 : do {
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
						Customer.cl.add(new Customer(id));
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
				if (login(id, pw)) {
					if (id.equals("admin")) isAdmin = true;
					else {
						
					}
					System.out.println("로그인 성공");
					loginedID = id;
					login = true;
					return ;
				}
				else System.out.println("아이디 또는 비밀번호가 잘못되었습니다.");
				break;
			case 3:
				while(true){
					System.out.println("프로그램을 종료하시겠습니까? (Y/N)");
					String sel = sc.nextLine();
					// sel을 대문자로 만들고(toUpperCase()), 공백을 제거하고(trim()), "Y"랑 같은지 본다.
					if (sel.toUpperCase().trim().equals("Y")){
						System.out.println("안녕히 가세요.");
						run = false;
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
		} while (!login);
	}
	
	public static MemberService getInstance() {
		if(instance == null) instance = new MemberService();
		return instance;
	}

}
