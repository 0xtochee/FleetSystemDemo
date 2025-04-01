package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dbutil.DBUtil;
import pojo.LoginInfo;

public class LoginDAO {

	public static boolean isUserValid(LoginInfo userDetails) {
	    boolean validStatus = false;
	    Connection conn = null;
	    try {
	        conn = DBUtil.getConnection();
	        if (conn != null) {
	            Statement st = conn.createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM login_info WHERE user_name = '" + userDetails.getUsername() + "' AND password = '" + userDetails.getPassword() + "'");
	            while (rs.next()) {
	                validStatus = true;
	            }
	        } else {
	            System.out.println("Connection is null!");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (conn != null) {
	            DBUtil.closeConnection(conn);
	        }
	    }
	    return validStatus;
	}
	
	
}
