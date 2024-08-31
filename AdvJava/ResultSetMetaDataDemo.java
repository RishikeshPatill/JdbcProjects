package AdvJava;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ResultSetMetaDataDemo {
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String username = "RISHIKESH";
	private static final String password = "RISHI";

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established Successfully!!!");
            System.out.println("--------------------------------------");
            
            Statement stmt=con.createStatement();
            String query1="select * from student";
            ResultSet rs=stmt.executeQuery(query1);
            
            ResultSetMetaData rsmd = rs.getMetaData();
            
            for(int i=1;i<=rsmd.getColumnCount();i++)
            {
            	System.out.print(rsmd.getColumnName(i)+"\t");
            }
            System.out.println("\n---------------------------------------------------");
            while(rs.next())
            {
            	
            	int eid = rs.getInt(1);
            	String ename= rs.getString(2);
            	double esal = rs.getDouble(3);
            	String epost = rs.getString(4);
            	
            	System.out.print(eid+"\t");
            	System.out.print(ename+"\t");
            	System.out.print(esal+"\t");
            	System.out.print(epost+"\t");
            	System.out.println();
            	
            }
            
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
