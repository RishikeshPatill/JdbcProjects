package MiniProject1;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CreateTableUser {
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String username = "RISHIKESH";
	private static final String password = "RISHI";

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established Successfully!!!");
			System.out.println("-----------------------------------------");
			
			// CREATE TABLE USERDETAILS
			Statement stmt = con.createStatement();
			String query = "CREATE TABLE USERDETAILS(USERNAME VARCHAR2(10),PASSWORD VARCHAR2(10),"
					+"UFNAME VARCHAR2(10),ULNAME VARCHAR2(10),MAILID VARCHAR2(20),PNUMBER NUMBER(10))";
			boolean execute = stmt.execute(query);
			System.out.println(execute);
			if(execute=false)
				System.out.println("table already exists!!!");
			else
				System.out.println("table created successfully!!!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}