package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.LoginDAO;
import pojo.LoginInfo; 


public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	String username;
	String password;
	
	public String execute() {
		String statusCode = "";
		System.out.println("Login execute() method called");
		boolean isUserValid = LoginDAO.isUserValid(new LoginInfo(username, password));
		if (isUserValid) {
			statusCode = "success";
		} else {
			statusCode = "input";
		}
		return statusCode;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}