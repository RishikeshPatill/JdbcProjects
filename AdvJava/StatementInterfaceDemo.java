package AdvJava;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.Statement;

public class StatementInterfaceDemo {

	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String username = "RISHIKESH";
	private static final String password = "RISHI";

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established Successfully!!!");
			System.out.println("----------------------------------------------------");

			//CREATE TABLE IN JAVA USING EXECUTE.
			Statement stmt = con.createStatement();
//			String query1 = "create table emp(eid number(2),ename varchar2(10),esal number(7,3),epost varchar2(15))";
//			boolean execute = stmt.execute(query1);
//			System.out.println("table created successfully!!!");
            
		    String query2="insert into emp values(33,'hari',6700,'css')";
			int executeUpdate = stmt.executeUpdate(query2);
			System.out.println(executeUpdate+" row updated");
			// HOW TO GET THE DATA FROM THE TABLE OF DATABASE IN JAVA.
		
		} catch (Exception e) {
			System.err.println(e);
		}

	}

}
