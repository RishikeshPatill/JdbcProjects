package MiniProject5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class EmpUpdate {
	public static Connection con = null;
	public static void updateEmp()
	{
		Scanner sc=new Scanner(System.in);
		try (sc){
		con = DBConnection1.getMyConnection();
		
		Statement stmt1=con.createStatement();
		
		PreparedStatement ptmt1=con.prepareStatement("update emp_info set salary=salary+(salary*0.10) where salary<=10000");
		ptmt1.executeUpdate();
		PreparedStatement ptmt2=con.prepareStatement("delete  from emp_info  where salary>=10000");
		ptmt2.executeUpdate();
//		ResultSet rs1=stmt1.executeQuery("select * from emp_info");
//		ResultSetMetaData  rsmd1=rs1.getMetaData();
//		
//		for(int i=1;i<=rsmd1.getColumnCount();i++)
//		{
//			System.out.println(rsmd1.getColumnCount()+ "column count");
//			System.out.println(rsmd1.getColumnName(i)+"\t");
//			
//			System.out.println(rsmd1.getColumnTypeName(i)+"\t");
//			System.out.println("-------------------------------");
//		}
//		System.out.println("-------------------------------");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
