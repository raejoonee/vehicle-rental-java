package vehicle_rental;

public class Member {
	protected String id;
	protected String pw;
	protected int age;
	protected boolean login = false;
	
	public Member(){}
	
	public Member(String id, String pw, int age){
		this.id = id;
		this.pw = pw;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return " [id=" + id + ", age=" + age + ", login=" + login + "]";
	}
	
	
}
