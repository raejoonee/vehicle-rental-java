package vehicle_rental;

import java.util.Vector;

//import class08_gettersetter.Member;

public class MemberService {
	// Member 타입 객체를 저장하기 위한 배열
	public static Vector<Member> mb = new Vector<>();
	private int count = 0;

	public void regist(String id, String pw, int age) {
		mb.add(new Member(id, pw, age));
	}

	public boolean login(String id, String pw) {
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
		System.out.println(id + " 님, 정상적으로 로그아웃되었습니다.");
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
}
