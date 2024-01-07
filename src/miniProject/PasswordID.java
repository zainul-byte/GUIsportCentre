package miniProject;
import java.util.HashMap;

public class PasswordID {
	//instance member...
	private HashMap<String, String> loginInfo = new HashMap<String, String>();
	//instance member
	
	//default constructor...
	public PasswordID() {
		loginInfo.put("Afiq", "2020627832");
		loginInfo.put("Zainul", "2020828578");
		loginInfo.put("Akmal", "2020819092");
		loginInfo.put("Farhana", "2020828182");
	}
	//default constructor

	//getter and setter...
	public HashMap<String, String> getLoginInfo() {
		return loginInfo;
	}

	public void setLoginInfo(HashMap<String, String> loginInfo) {
		this.loginInfo = loginInfo;
	}
	//getter and setter
	
}
