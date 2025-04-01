package dbutil;

import java.sql.*;

public class DBUtil {
    private static Connection conn = null;

    public static Connection getConnection() {
        try {
            if (conn == null) {
                // Load mySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Oracle JDBC driver loaded successfully!");

                // Establish the connection
                String url = "jdbc:mysql://localhost:3306/vehicle_maintenance";
                String username = "vehicle_app";
                String password = "T3c#Crunc#";
                System.out.println("Connecting to database: " + url + " with username: " + username);

                conn = DriverManager.getConnection(url, username, password);

                System.out.println("Connection established successfully!");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading database driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error establishing connection: " + e.getMessage());
            System.out.println("Error code: " + e.getErrorCode());
            System.out.println("Error message: " + e.getMessage());
        }

        return conn;
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Connection closed successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}

/*
 * public static Connection getConnection()
	{
		Connection conn = null;
		try 
		{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/free","system","FuckYouBitch");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public static void closeConnection(Connection conn)
	{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/