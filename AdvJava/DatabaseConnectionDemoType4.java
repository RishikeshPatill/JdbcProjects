package AdvJava;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectionDemoType4 {

	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String username = "RISHIKESH";
	private static final String password = "RISHI";

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established Successfully!!!");
			System.out.println("----------------------------------------------------");
			con.close();
		} catch (Exception e) {
			System.err.println(e);
		}

	}

}
